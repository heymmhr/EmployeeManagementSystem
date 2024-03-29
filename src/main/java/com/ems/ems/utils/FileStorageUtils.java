package com.ems.ems.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.UUID;

@Component
public class FileStorageUtils {

    private final String userHome = System.getProperty("user.home");
    @Value("${course.file.storage.directory}")
    private String courseStoragePath;

    //this function takes multipart file as input parameter and saves it and then returns the file location
    public String storeFile(MultipartFile multipartFile) throws IOException {
        String directoryPath = userHome + courseStoragePath;
        File directoryFile = new File(directoryPath);

        if (!directoryFile.exists()) {
            directoryFile.mkdirs();
        } else {
            System.out.println("+++++++++++ Directory already exists ++++++++");
        }

        String fileStorageLocation = directoryPath + File.separator + UUID.randomUUID() + "_" + multipartFile.getOriginalFilename();
        File fileToSave = new File(fileStorageLocation);
        multipartFile.transferTo(fileToSave);

        return fileStorageLocation;
    }

    public String getBase64FileFromFilePath (String filePath) throws IOException {

        File readingFile = new File(filePath);
        if (readingFile.exists()){
            // i will get byte array of file and convert it to base64
            System.out.println("File found");
            byte [] bytes = Files.readAllBytes(readingFile.toPath());

            String base64String = Base64.getEncoder().encodeToString(bytes);
            return "data:image/jpeg;base64," + base64String;
        }else {
            System.out.println("File not found");
            return null;
        }
    }
}
