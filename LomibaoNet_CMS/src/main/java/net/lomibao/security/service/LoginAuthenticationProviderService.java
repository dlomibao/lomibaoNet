package net.lomibao.security.service;

import io.micronaut.context.annotation.Value;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import lombok.extern.slf4j.Slf4j;
import net.lomibao.entity.User;
import net.lomibao.repository.UserRepository;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.HashMap;

@Slf4j
@Singleton
public class LoginAuthenticationProviderService implements AuthenticationProvider {

    private final UserRepository userRepository;
    private final PasswordEncoderService passwordEncoderService;
    private final GoogleLoginService googleLoginService;
    @Value("${auth.user-test.enabled:false}")
    boolean testEnabled;
    @Value("${auth.user-test.google.password:}")
    String testPass;

    public LoginAuthenticationProviderService(UserRepository userRepository, PasswordEncoderService passwordEncoderService, GoogleLoginService googleLoginService) {
        this.userRepository = userRepository;
        this.passwordEncoderService = passwordEncoderService;
        this.googleLoginService = googleLoginService;
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        String email = (String) authenticationRequest.getIdentity();
        String password = (String) authenticationRequest.getSecret();
        User user = userRepository.findById(email).orElse(null);
        if (email == null || password == null || user == null) {
            return Flowable.create(emitter -> {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }, BackpressureStrategy.ERROR);
        } else if (password != null && password.toLowerCase().startsWith("external:")) {
            return Flowable.create(emitter -> {
                processExternal(emitter, email, password);
            }, BackpressureStrategy.ERROR);
        } else if (user != null && passwordEncoderService.matches(password, user.getPasswordHash())) {
            return Flowable.create(emitter -> {
                        emitter.onNext(new UserDetails(email, Collections.singleton(user.getRole()), new HashMap<>(user.getAttributes())));
                        emitter.onComplete();
                    }
                    , BackpressureStrategy.BUFFER);
        }
        return  Flowable.create(emitter -> {
            emitter.onError(new AuthenticationException(new AuthenticationFailed()));
        }, BackpressureStrategy.ERROR);
    }

    public void processExternal(FlowableEmitter<AuthenticationResponse> emitter, String email, String password) {
        log.debug("processing external login");
        String[] parts = password.split(":");
        var extern = parts[0];
        if (!"external".equalsIgnoreCase(extern)) {
            emitter.onError(new AuthenticationException(new AuthenticationFailed()));
        } else {
            var source = parts[1];
            var token = parts[2];
            boolean validated = false;
            User user = userRepository.findById(email).orElse(null);
            if ("GOOGLE".equalsIgnoreCase(source)) {
                //run google validation
                if(user.getEmail().equalsIgnoreCase(googleLoginService.validate(token))){
                    log.info("validated google");
                    validated=true;
                }
            } else if ("AMAZON".equalsIgnoreCase(source)) {
                //TODO
                log.warn("no aws login handler found");
            } else if ("MICROSOFT".equalsIgnoreCase(source)) {
                //TODO
                log.warn("no microsoft login handler found");
            } else if ("GITHUB".equalsIgnoreCase(source)) {
                //TODO
                log.warn("no github login handler found");
            }else{
                log.error("no handler found for source {} for {}",source,password);
            }
            if (validated) {
                emitter.onNext(new UserDetails(email, Collections.singleton(user.getRole()), new HashMap<>(user.getAttributes())));
                emitter.onComplete();
            }else{
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
        }

    }
}
