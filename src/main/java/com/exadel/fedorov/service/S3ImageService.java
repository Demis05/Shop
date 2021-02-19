package com.exadel.fedorov.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class S3ImageService {

    public static final String BUCKET_NAME = "exadel.shop.bucket";
    public static final String DEFAULT_IMAGE_NAME = "default_image.jpeg";
    public static final String IMAGE_FOLDER_PATH = "storeFiles/images/";

    @Autowired
    private AmazonS3 s3Client;

    public void createImage(Long id, MultipartFile multipartFile) {
        String imageName = String.format(IMAGE_FOLDER_PATH + "%d.jpeg", id);
        try {
            if (!multipartFile.isEmpty()) {
                ObjectMetadata data = new ObjectMetadata();
                data.setContentType(multipartFile.getContentType());
                data.setContentLength(multipartFile.getSize());
                s3Client.putObject(BUCKET_NAME, imageName, multipartFile.getInputStream(), data);
            } else {
                setDefaultImage(imageName);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }

    public void updateImage(Long id, MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            deleteImage(id);
            createImage(id, multipartFile);
        }
    }

    public void deleteImage(Long id) {
        String imageName = String.format(IMAGE_FOLDER_PATH + "%d.jpeg", id);
        s3Client.deleteObject(BUCKET_NAME, imageName);
    }


    private void setDefaultImage(String imageName) {
        CopyObjectRequest copyObjRequest = new CopyObjectRequest(BUCKET_NAME, IMAGE_FOLDER_PATH + DEFAULT_IMAGE_NAME, BUCKET_NAME, imageName);
        s3Client.copyObject(copyObjRequest);
    }
}