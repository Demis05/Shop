//package com.exadel.fedorov.service;
//
//
//import com.amazonaws.services.s3.AmazonS3;
//import com.exadel.fedorov.config.S3Config;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = S3Config.class,
//        loader = AnnotationConfigContextLoader.class)
//class S3ImageServiceTest {
//
//    public static final String BUCKET_NAME = "exadel.shop.bucket";
//    public static final String DEFAULT_IMAGE_NAME = "default_image.jpeg";
//    public static final String IMAGE_FOLDER_PATH = "storeFiles/images/";
//
//    @InjectMocks
//    S3ImageService imageService;
//
//    @Mock
//    private AmazonS3 s3Client;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @After
//    public void delete() {
//    }
//
//    @Test
//    public void test_create_image_method() {
//
////        when(s3Client.putObject(BUCKET_NAME, imageName, new In, data);
////        when(s3Client.getObject()).thenReturn(new EmployeeVO(1,"Lokesh","Gupta","user@email.com"));
////        EmployeeVO emp = manager.getEmployeeById(1);
////        assertNotNull(s3Client);
////        when(s3Client.isAvailable()).thenReturn(true);
////        imageService.createImage()
////        s3Client.deleteBucket();
//    }
//
//    @Test
//    public void updateImage() {
//    }
//
//    @Test
//    public void deleteImage() {
//    }
//}