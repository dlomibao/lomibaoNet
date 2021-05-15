package net.lomibao.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.repository.CrudRepository;
import net.lomibao.entity.Article;

import java.util.Optional;

@JdbcRepository
public interface ArticleRepository extends CrudRepository<Article,Long> {

    Optional<Article> findByUrlName(String urlName);
}
