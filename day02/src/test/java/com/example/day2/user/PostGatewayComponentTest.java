package com.example.day2.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.Optional;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
class PostGatewayComponentTest {

    @Autowired
    private PostGateway postGateway;

    @Test
    void getPostById() throws IOException {
        stubFor(get(urlPathEqualTo("/posts/1"))
                .willReturn(aResponse()
                        .withBody(FileLoader.read("classpath:postApiResponse.json"))
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)));

        Optional<PostResponse> postResponse = postGateway.getPostById(1);
        assertEquals(11, postResponse.get().getId());
        assertEquals(11, postResponse.get().getUserId());
        assertEquals("Test Title", postResponse.get().getTitle());
        assertEquals("Test Body", postResponse.get().getBody());
    }
}