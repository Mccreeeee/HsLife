package com.hnsfdx.hslife.util;

import com.hnsfdx.hslife.exception.ArgsIntroduceException;
import com.hnsfdx.hslife.exception.AuthException;
import com.hnsfdx.hslife.exception.StorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    private static final String BASE_DIR = "temp/images/";

    // 相对路径（暂定为reviewerId + xxxId） + 文件名用于存储
    public static void uploadToServer(String relativePath, MultipartFile multipartFile) {
        if ("".equals(relativePath) || relativePath == null) {
            throw new ArgsIntroduceException();
        }
        if (multipartFile.isEmpty() || multipartFile == null) {
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

    // 删除文件夹相对路径下的所有图片文件
    public static void deleteInServer(String relativePath) {
        if ("".equals(relativePath) || relativePath == null) {
            throw new ArgsIntroduceException();
        }
        File file = new File(BASE_DIR + relativePath);
        if (!file.isDirectory()) {
            throw new ArgsIntroduceException();
        }
        // 可能会出现访问权限的异常，使用的时候再捕获异常
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            for (File tmpFile : listFiles) {
                tmpFile.delete();
            }
        }
    }
}
