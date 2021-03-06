package com.yc.blog.web.controller;


import com.yc.blog.domain.Article;
import com.yc.blog.future.ArticleFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleFuture articleFuture;


    private static Logger logger = LoggerFactory.getLogger(ArticleController.class.getName());


    @RequestMapping(value = "/{id}")
    public CompletableFuture<String> findById(@PathVariable Integer id) {
        return articleFuture.findById(id);
    }

    @RequestMapping(value = "/category/{id}")
    public CompletableFuture<String> findCategory(@PathVariable Integer id) {
        return articleFuture.findByCategory(id);
    }

    @RequestMapping(value = "/findNew")
    public CompletableFuture<String> findNew() {
        return articleFuture.findNew();
    }

    @RequestMapping(value = "/findHot")
    public CompletableFuture<String> findHot() {
        return articleFuture.findHot();
    }

    @GetMapping(path= {"index","index.html","/"})
    public CompletableFuture<String> Index() {
        return articleFuture.findById(12);
    }

    @RequestMapping(value = "/category")
    public CompletableFuture<String> Category() {
        return articleFuture.findCategory();
    }

    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    public CompletableFuture<String> addArticle(Article article) {
        return articleFuture.addArticle(article);
    }

}
