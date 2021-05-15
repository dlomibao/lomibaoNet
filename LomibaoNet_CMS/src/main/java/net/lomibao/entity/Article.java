package net.lomibao.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MappedEntity
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String urlName;//url name

    private String title;
    private String body;
    private String author;

    private Long categoryId;

    @TypeDef(type = DataType.JSON)
    Map<String,String> tags;

    private boolean published;
}
