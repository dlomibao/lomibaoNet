package net.lomibao.bkp;

import io.micronaut.context.annotation.Primary;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.Collections;
//@Primary
//@Singleton

@Slf4j
public class BearerAuthenticationProvider implements AuthenticationProvider {


    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        if(httpRequest!=null){
            log.info(httpRequest.getHeaders().get("Authentication"));
        }
        return Flowable.just(new UserDetails("derek", Collections.singletonList("admin") ) );
    }
}
