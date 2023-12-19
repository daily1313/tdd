package com.example.tdd;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApiTest {

    @Autowired
    private DatabaseCleanUp databaseCleanUp;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        if(RestAssured.port == RestAssured.UNDEFINED_PORT) {
            RestAssured.port = port;
            databaseCleanUp.afterPropertiesSet();
        }

        databaseCleanUp.execute();
    }
}
