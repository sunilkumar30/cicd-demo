package com.example.cicd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "spring.main.web-application-type=servlet")
class AppTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void contextLoads() {
        // Test that the Spring context loads successfully
    }

    @Test
    void testHelloEndpoint() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertEquals("Hello World from CI/CD Demo!", response);
    }

    @Test
    void testHealthEndpoint() {
        String response = restTemplate.getForObject("http://localhost:" + port + "/health", String.class);
        assertEquals("Application is running successfully!", response);
    }
}
