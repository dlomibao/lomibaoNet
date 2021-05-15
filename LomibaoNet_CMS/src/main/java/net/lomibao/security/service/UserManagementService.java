package net.lomibao.security.service;

import io.micronaut.context.annotation.Value;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;
import lombok.extern.slf4j.Slf4j;
import net.lomibao.entity.User;
import net.lomibao.repository.UserRepository;
import io.micronaut.runtime.server.event.ServerStartupEvent;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.time.Instant;
import java.util.Collections;
@Slf4j
@Singleton

public class UserManagementService {
    private final UserRepository userRepository;
    @Value("${user.default.email:deload@gmail.com}")
    private String defaultUserEmail;
    @Value("${user.default.password:qwerty123}")
    private String defaultUserPassword;

    private final PasswordEncoderService passwordService;
    public UserManagementService(UserRepository userRepository, PasswordEncoderService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }
    @EventListener
    @Async
    public void initUser(final ServerStartupEvent event){
        if(userRepository.findFirstByRole("ADMIN").isPresent()){
            log.info("an admin user exists already, skip initialize");
            return;//already has an admin, skip
        }
        log.info("init root admin {} pass={}",defaultUserEmail,"*".repeat(defaultUserPassword.length()));
        this.userRepository.save(User.builder()
                .email(defaultUserEmail)
                .role("ADMIN")
                .passwordHash(passwordService.encode(defaultUserPassword))
                .created(Instant.now())
                .modified(Instant.now())
                .attributes(Collections.emptyMap())
                .build());
    }
}
