package net.lomibao.security.service;

import io.micronaut.core.annotation.NonNull;
import net.lomibao.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.inject.Singleton;
import javax.validation.constraints.NotBlank;

@Singleton
public class PasswordEncoderService {
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

    public String encode(@NotBlank @NonNull String password){
        return encoder.encode(password);
    }
    public boolean matches(@NotBlank @NonNull String password, @NotBlank @NonNull String bcryptHash){
        return encoder.matches(password,bcryptHash);
    }

    public void setPassword(String password,@NonNull User user){
        user.setPasswordHash(encode(password));
    }
}
