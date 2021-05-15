package net.lomibao.bkp;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.micronaut.security.oauth2.endpoint.authorization.state.State;
import io.micronaut.security.oauth2.endpoint.token.response.*;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

//@Replaces(DefaultOpenIdUserDetailsMapper.class)
//@Singleton
public class GoogleUserDetailsMapper implements OpenIdUserDetailsMapper {


    @Override
    public UserDetails createUserDetails(String providerName, OpenIdTokenResponse tokenResponse, OpenIdClaims openIdClaims) {
        throw new RuntimeException("doesn't exist");
    }

    @Override
    public AuthenticationResponse createAuthenticationResponse(String providerName, OpenIdTokenResponse tokenResponse, OpenIdClaims openIdClaims, @Nullable State state) {
       return new UserDetails("deload@gmail.com", List.of("ROLE_ADMIN"));
    }

//    @Override
//    public Publisher<UserDetails> createUserDetails(TokenResponse tokenResponse) {
//        //tokenResponse.getAccessToken()
//        return Flowable.just(new UserDetails("deload@gmail.com", List.of("ROLE_ADMIN")));
//    }
}
