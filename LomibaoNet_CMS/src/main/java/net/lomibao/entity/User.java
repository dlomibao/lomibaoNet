package net.lomibao.entity;

import javax.validation.constraints.NotBlank;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MappedEntity
public class User {
    @Id
    String email;
    String role;
    Instant created;
    Instant modified;
    @TypeDef(type = DataType.JSON)
    Map<String,String> attributes;
    String passwordHash;

}
