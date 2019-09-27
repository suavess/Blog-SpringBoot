package com.pyq.blog.service.Impl;
import java.util.List;

import com.pyq.blog.mapper.ArticleCategoryMapper;
import com.pyq.blog.mapper.ArticleMapper;
import com.pyq.blog.model.Article;
import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Suave
 * @Date 2019/9/10 12:40
 * @Version 1.0
 */
@Service(value = "ArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleCategoryMapper articleCategoryMapper;

    @Override
    public Integer countAllArticle() throws Exception {
        return articleMapper.countAllArticle();
    }

    @Override
    public Integer countArticlesByCateId(Integer cateId) throws Exception {
        return articleMapper.countArticleByCateId(cateId);
    }

    @Override
    public Integer countArticlesByYearAndMonth(String year, String month) throws Exception {
        return articleMapper.countArticleByYearAndMonth(year,month);
    }

    @Override
    public String selectTitleById(String id) throws Exception {
        return articleMapper.selectTitleById(id);
    }

    @Override
    public List<ArticleExt> selectAllArticles() throws Exception {
        return articleMapper.selectAllArticles();
    }

    @Override
    public ArticleExt selectArticleById(String id) throws Exception {
        return articleMapper.selectArticleById(id);
    }

    @Override
    public List<ArticleExt> selectArticlesByPage(Integer offset) throws Exception {
        return articleMapper.selectArticlesByPage(offset);
    }

    @Override
    public List<ArticleExt> selectArticlesByCidAndPage(Integer cateId, Integer offset) throws Exception {
        return articleMapper.selectArticlesByCidAndPage(cateId,offset);
    }

    @Override
    public List<ArticleExt> selectArticlesByDateAndPage(String year, String month, Integer offset) throws Exception {
        return articleMapper.selectArticlesByDateAndPage(year, month, offset);
    }

    @Transactional
    @Override
    public void saveArticle(Article article) throws Exception {
        articleMapper.saveArticle(article);
    }

    @Override
    public void delArticle(String id) throws Exception {
        articleMapper.delArticle(id);
    }
}
