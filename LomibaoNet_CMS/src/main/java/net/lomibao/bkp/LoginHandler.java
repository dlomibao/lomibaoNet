package net.lomibao.bkp;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.config.RedirectConfiguration;
import io.micronaut.security.errors.PriorToLoginPersistence;
import io.micronaut.security.handlers.RedirectingLoginHandler;
import io.micronaut.security.oauth2.endpoint.token.response.IdTokenLoginHandler;
import io.micronaut.security.token.config.TokenConfiguration;
import io.micronaut.security.token.jwt.bearer.AccessRefreshTokenLoginHandler;
import io.micronaut.security.token.jwt.cookie.AccessTokenCookieConfiguration;
import io.micronaut.security.token.jwt.generator.AccessRefreshTokenGenerator;

import javax.inject.Singleton;

//@Singleton
public class LoginHandler extends AccessRefreshTokenLoginHandler {


    /**
     * @param accessRefreshTokenGenerator AccessRefresh Token generator
     */
    public LoginHandler(AccessRefreshTokenGenerator accessRefreshTokenGenerator) {
        super(accessRefreshTokenGenerator);
    }
}




