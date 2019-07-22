package com.example;

import com.example.controllers.BookController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SmokeTest {

    @Autowired
    private BookController bookController;

    @Autowired
    private LoadData loadData;

    @Test
    void contexLoads() {
        Assertions.assertNotNull(bookController);
        Assertions.assertNotNull(loadData);
    }
}
