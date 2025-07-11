package com.example.cicd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(properties = "spring.main.web-application-type=none")
class AppTest {

    @Test
    void contextLoads() {
        // Test that the Spring context loads successfully
    }

    @Test
    void testAppExists() {
        // Simple test to ensure the App class can be instantiated
        App app = new App();
        assertNotNull(app);
    }

    @Test
    void testHelloMethod() {
        // Test the hello method directly
        App app = new App();
        String result = app.hello();
        assertEquals("Hello World from CI/CD Demo!", result);
    }

    @Test
    void testHealthMethod() {
        // Test the health method directly
        App app = new App();
        String result = app.health();
        assertEquals("Application is running successfully!", result);
    }

    @Test
    void testMainMethod() {
        // Test that main method doesn't throw exception
        assertDoesNotThrow(() -> {
            App.main(new String[]{});
        });
    }
}
