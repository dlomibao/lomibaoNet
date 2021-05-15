package net.lomibao;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.security.authentication.UsernamePasswordCredentials;
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class CmsTest {
    @Inject
    EmbeddedServer server;
    @Inject
    ApplicationContext context;
    @Inject
    @Client("/")
    RxHttpClient client;

    String idToken="eyJhbGciOiJSUzI1NiIsImtpZCI6ImUxYWMzOWI2Y2NlZGEzM2NjOGNhNDNlOWNiYzE0ZjY2ZmFiODVhNGMiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJhY2NvdW50cy5nb29nbGUuY29tIiwiYXpwIjoiODQ3ODgyNTIzNTQxLWpwMGt1bXZ1ZzFlNnN2NXI2dmg3anRtbjgwcXZwYW1tLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwiYXVkIjoiODQ3ODgyNTIzNTQxLWpwMGt1bXZ1ZzFlNnN2NXI2dmg3anRtbjgwcXZwYW1tLmFwcHMuZ29vZ2xldXNlcmNvbnRlbnQuY29tIiwic3ViIjoiMTAwNzM4NjA3OTQzNzQ4MTc3Mzk0IiwiZW1haWwiOiJkZWxvYWRAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiI4YXZsdXFkWVJzcV9PaWRNOHRFLXJ3IiwibmFtZSI6IkQgTCIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS0vQU9oMTRHZzFXSXBaUTNvX2lkb2pUSVRoTDZZWG5FVk5oQVRJRHRZQjFJTzlqQT1zOTYtYyIsImdpdmVuX25hbWUiOiJEIiwiZmFtaWx5X25hbWUiOiJMIiwibG9jYWxlIjoiZW4iLCJpYXQiOjE2MTc1OTE5MTgsImV4cCI6MTYxNzU5NTUxOCwianRpIjoiZDlmZjM2NTM3MzI1ZDAyYjY2MzY3OGM2YTVmNGVjMjliYjczZDk4MiJ9.CrcnoOjRkvhMOV5AxNfQOzueEqW2W86bv2E6oV2YBQc0MKJfvnhEppHa7NoIL2vqjPF4QDfRIrQPqX8KW-yR3s_RTAxQFOMffYXsAniD7lG0uvaA-LE8F3SMFVVgqlbQf26TcGsNm_7I1DNwTfNt4pxt8C8iKY95U_UsPS5Xl5lx8k5ZqeFJzdLSE0iHLntFfQxhfdovwQBhopsYvMFkIO7r_rU-hBgnG68ZKG7QL_YV_uo0P61mp8w1AIq6q2of2NDgxybUyjdmWvy30h50Oc_27Wd-S7PkYyhgPVmGKyzTrBqzlOnRuUtw_bVHIad5lXNyzJSIMBRm4AYVPy2wew";

    @BeforeAll
    public static void init() {

    }

    @Test
    void testItWorks() {
        Assertions.assertTrue(context.isRunning());
    }

    @Test
    void testLogin() {
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("deload@gmail.com", "qwerty123");
        var request = HttpRequest.POST("/login", credentials);
        var token = client.toBlocking().exchange(request, BearerAccessRefreshToken.class);
        assertEquals(HttpStatus.OK, token.status());
        assertEquals("deload@gmail.com", token.body().getUsername());

    }

    @Test
    void testGoogleLogin() {
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("deload@gmail.com", "external:google:"+idToken);
        var request = HttpRequest.POST("/login", credentials);
        var token = client.toBlocking().exchange(request, BearerAccessRefreshToken.class);
        assertEquals(HttpStatus.OK, token.status());
        assertEquals("deload@gmail.com", token.body().getUsername());
        credentials = new UsernamePasswordCredentials("deload@gmail.com", "external:google:badPass");

        var request2 = HttpRequest.POST("/login", credentials);
        assertThrows(HttpClientResponseException.class, () -> client.toBlocking().exchange(request2, BearerAccessRefreshToken.class));


    }

}
