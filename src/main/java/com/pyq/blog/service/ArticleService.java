package com.pyq.blog.service;

import com.pyq.blog.model.Article;
import com.pyq.blog.model.ArticleExt;

import java.util.List;

public interface ArticleService {
    Integer countAllArticle();
    Integer countArticlesByCateId(String cateId);
    Integer countArticlesByYearAndMonth(String year, String month);
    String selectTitleById(String id);
    ArticleExt selectArticleById(String id);
    List<ArticleExt> selectAllArticles();
    List<ArticleExt> selectArticlesByPage(String page);
    List<ArticleExt> selectArticlesByCidAndPage(String cateId, String page);
    List<ArticleExt> selectArticlesByDateAndPage(String year, String month ,String page);
    void saveArticle(Article article);
    void delArticle(String id);
    void updateArticle(Article article);
}
