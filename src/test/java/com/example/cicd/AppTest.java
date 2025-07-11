package com.example.cicd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "spring.main.web-application-type=none")
class AppTest {

    @Test
    void contextLoads() {
        // Test that the Spring context loads successfully
    }
}
