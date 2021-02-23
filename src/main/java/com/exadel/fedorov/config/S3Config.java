package com.exadel.fedorov.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.exadel.fedorov")
@Configuration
public class S3Config {

    public static final String ACCESS_KEY_ID = "AKIA35Y2MPKISBLUGXWU";
    public static final String ACCESS_SEC_KEY = "ds9hf5Eib0cS0GWQGcK+AmyJ8b6BxyMDy1uAv7Xh";

    @Bean(name = "amazonS3")
    public AmazonS3 api() {
        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY_ID, ACCESS_SEC_KEY);
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .disableChunkedEncoding()
                .build();
    }

}

