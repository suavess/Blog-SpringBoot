package com.pyq.blog.service;

import com.pyq.blog.model.Article;
import com.pyq.blog.model.ArticleExt;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 12:39
 * @Version 1.0
 */
public interface ArticleService {
    Integer countAllArticle() throws Exception;
    Integer countArticlesByCateId(Integer cateId) throws Exception;
    Integer countArticlesByYearAndMonth(String year, String month) throws Exception;
    String selectTitleById(String id) throws Exception;
    ArticleExt selectArticleById(String id) throws Exception;
    List<ArticleExt> selectArticlesByPage(Integer offset) throws Exception;
    List<ArticleExt> selectArticlesByCidAndPage(Integer cateId,Integer offset) throws Exception;
    List<ArticleExt> selectArticlesByDateAndPage(String year, String month ,Integer offset) throws Exception;
}
