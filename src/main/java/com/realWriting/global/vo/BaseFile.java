package com.realWriting.global.vo;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseFile {
    private String fileUrl;
    private String originFileName;
    private String storedFileName;
}
