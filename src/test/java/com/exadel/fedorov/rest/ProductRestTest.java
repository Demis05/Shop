//package com.exadel.fedorov.rest;
//
//import com.exadel.fedorov.config.TestConfig;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.AnnotationConfigContextLoader;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(classes = TestConfig.class,
//        loader = AnnotationConfigContextLoader.class)
//public class ProductRestTest {
//
//
//    private FooLookUpService service;
//    private Connection connection;
//
//    @Before
//    public void setUp() throws SQLException {
//        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:request_no;MODE=Oracle");
//        connection = setUpDatabase(dataSource);
//        service = new FooLookupService(dataSource);
//    }
//
//    @After
//    public void tearDown() throws SQLException {
//        destroyDatabase();
//    }
//    private MockMvc mockMvc;
//
//    @Autowired
//    protected WebApplicationContext webApplicationContext;
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @Test
//    public void t() {
//        System.out.println("dd");
//    }
//}