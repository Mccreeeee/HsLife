package com.hnsfdx.hslife.util;

import com.hnsfdx.hslife.exception.StorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    private static final String BASE_DIR = "temp/images/";
    // 相对路径（暂定为reviewerId + xxxId） + 文件名用于存储
    public static void uploadToServer(String relativePath, MultipartFile multipartFile) {
        if(multipartFile.isEmpty()) {
            throw new StorageException();
        }
        String fileName = multipartFile.getOriginalFilename();
        File dir = new File(BASE_DIR + relativePath);
//        String absolutePath = dir.getAbsolutePath().endsWith("/") ? dir.getAbsolutePath() : dir.getAbsolutePath() + "/";
        File file = new File(dir.getAbsoluteFile(), fileName);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
            multipartFile.transferTo(file);
        } catch (IOException e) {
            throw new StorageException();
        }
    }
}
