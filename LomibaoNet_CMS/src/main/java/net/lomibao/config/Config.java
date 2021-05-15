package net.lomibao.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Primary;
import io.micronaut.core.convert.TypeConverter;
import io.micronaut.security.config.RedirectConfiguration;
import io.micronaut.security.errors.PriorToLoginPersistence;
import io.micronaut.security.handlers.RedirectingLoginHandler;
import io.micronaut.security.oauth2.endpoint.token.response.IdTokenLoginHandler;
import io.micronaut.security.token.config.TokenConfiguration;
import io.micronaut.security.token.jwt.bearer.AccessRefreshTokenLoginHandler;
import io.micronaut.security.token.jwt.cookie.AccessTokenCookieConfiguration;
import io.micronaut.security.token.jwt.generator.AccessRefreshTokenGenerator;

import javax.inject.Singleton;
import java.util.Map;

@Factory
public class Config {
//    AccessRefreshTokenGenerator tokenGenerator;
//    public Config(AccessRefreshTokenGenerator tokenGenerator){
//        this.tokenGenerator=tokenGenerator;
//    }
//    @Bean
//    public AccessRefreshTokenLoginHandler tokenConfig(AccessRefreshTokenGenerator gen){
//        return new AccessRefreshTokenLoginHandler(gen);
//    }
//    @Bean public RedirectConfiguration redirConfig(){}
//    @Bean public TokenConfiguration tokenConfig(){}
//    @Bean public PriorToLoginPersistence ptlP(){}
@Bean
@Singleton
public TypeConverter<String, Map> stringToFooConverter() {
    return TypeConverter.of(
            String.class,
            Map.class,
            x->{
                try {
                    return new ObjectMapper().readValue(x, Map.class);
                }catch (Exception e){
                    System.out.printf("failed");
                    e.printStackTrace();
                }
                return null;
            }
    );
}
}
