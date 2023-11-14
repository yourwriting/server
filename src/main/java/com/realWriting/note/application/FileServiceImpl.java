package com.realWriting.note.application;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.realWriting.global.error.ErrorCode;
import com.realWriting.global.error.exception.FileException;
import com.realWriting.global.vo.BaseFile;
import com.realWriting.note.application.port.in.FileService;
import com.realWriting.note.application.port.out.ImagePersistencePort;
import com.realWriting.note.application.port.out.dto.NoteRes;
import com.realWriting.note.domain.Image;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private final AmazonS3 amazonS3;
    private final ImagePersistencePort imagePersistencePort;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;
    @Value("${spring.application.name}")
    private String appName;

    @Override
    public List<NoteRes.FileRes> getNoteFileList(Long noteId) {
        List<Image> imageList = imagePersistencePort.findByNoteId(noteId);
        List<NoteRes.FileRes> imageFileResList = new ArrayList<>();
        imageList.forEach(image -> {
            imageFileResList.add(NoteRes.FileRes.of(image));
        });
        return imageFileResList;
    }

    @Override
    public List<BaseFile> uploadNoteFileList(List<MultipartFile> multipartFiles) {
        return uploadFileList(multipartFiles, appName);
    }

    @Transactional
    @Override
    public List<BaseFile> uploadFileList(List<MultipartFile> multipartFiles, String path) {
        List<BaseFile> fileList = new ArrayList<>();

        multipartFiles.stream().forEach(multipartFile -> {
            fileList.add(uploadFile(multipartFile, path));
        });

        return fileList;
    }

    @Override
    public BaseFile uploadFile(MultipartFile multipartFile, String path) {
        String originalFilename = multipartFile.getOriginalFilename();
        String fileExtension = FilenameUtils.getExtension(originalFilename);
        String storedFileName = UUID.randomUUID() + "." + fileExtension;
        String objectKey = path + "/" + storedFileName;

        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(multipartFile.getSize());
        objectMetadata.setContentType(multipartFile.getContentType());

        try(InputStream inputStream = multipartFile.getInputStream()) {
            amazonS3.putObject(new PutObjectRequest(bucketName, objectKey, inputStream, objectMetadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "파일 업로드에 실패했습니다.");
        }

        return BaseFile.builder()
                .storedFileName(storedFileName)
                .originFileName(originalFilename)
                .fileUrl(amazonS3.getUrl(bucketName, objectKey).toString())
                .build();
    }

    @Override
    public void deleteNoteFileList(Long noteId) {
        List<Image> imageList = imagePersistencePort.findByNoteId(noteId);
        imageList.forEach(image -> {
            deleteFile(image.getStoredFileName(), appName);
            imagePersistencePort.delete(image);
        });
    }

    @Override
    public void deleteFile(String storedName, String path) {
        String objectKey = path + "/" + storedName;
        if (amazonS3.doesObjectExist(bucketName, objectKey)) {
            amazonS3.deleteObject(bucketName, objectKey);
        }
        else {
            throw new FileException(ErrorCode.FILE_NOT_FOUND);
        }
    }
}
