package net.lomibao.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MappedEntity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String urlName;
    private String thumbnailPath;

    @Relation(value = Relation.Kind.ONE_TO_MANY,mappedBy = "categoryId")
    private List<Article> articles;
}
