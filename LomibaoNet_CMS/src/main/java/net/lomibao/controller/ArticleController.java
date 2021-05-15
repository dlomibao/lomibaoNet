package net.lomibao.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import net.lomibao.entity.Article;
import net.lomibao.exception.NotFoundException;
import net.lomibao.service.ArticleService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller("/api/v1/article")
public class ArticleController {
    @Inject
    ArticleService articleService;


    @Get
    List<Article> getArticles(){
        return StreamSupport.stream(articleService.findAll().spliterator(),false).collect(Collectors.toList());
    }
    @Post
    Article updateArticle(Article article){
        return articleService.save(article);
    }
    @Get("/{name}")
    Article getArticleByUrlName(String name){
        return articleService.getArticleByUrlName(name).orElseThrow(()->new NotFoundException());
    }
    @Delete("/{id}")
    void deleteArticleById(Long id){
        articleService.deleteById(id);
    }
}
