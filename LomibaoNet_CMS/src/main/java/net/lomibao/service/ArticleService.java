package net.lomibao.service;

import io.micronaut.context.annotation.Bean;
import net.lomibao.entity.Article;
import net.lomibao.repository.ArticleRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class ArticleService extends  CrudService<ArticleRepository,Article,Long>{


    public ArticleService(ArticleRepository articleRepository){
        super(articleRepository);
    }

    public Optional<Article> getArticleByUrlName(String name){
        return getCrudRepository().findByUrlName(name);
    }




}
