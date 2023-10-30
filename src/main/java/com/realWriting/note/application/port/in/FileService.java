package com.realWriting.note.application.port.in;

import com.realWriting.global.vo.BaseFile;
import com.realWriting.note.application.port.out.dto.NoteRes;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    List<NoteRes.FileRes> getNoteFileList(Long noteId);
    List<BaseFile> uploadNoteFileList(List<MultipartFile> multipartFiles);
    List<BaseFile> uploadFileList(List<MultipartFile> multipartFiles, String path);
    BaseFile uploadFile(MultipartFile multipartFile, String path);
    void deleteNoteFileList(Long noteId);
    void deleteFile(String storedName, String path);
}
