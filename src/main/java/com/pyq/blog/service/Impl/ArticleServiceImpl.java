package com.pyq.blog.service.Impl;

import java.util.List;

import com.pyq.blog.mapper.ArticleCategoryMapper;
import com.pyq.blog.mapper.ArticleMapper;
import com.pyq.blog.model.Article;
import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "ArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    ArticleCategoryMapper articleCategoryMapper;

    @Override
    public Integer countAllArticle() {
        return articleMapper.countAllArticle();
    }

    @Override
    public Integer countArticlesByCateId(String cateId) {
        if (cateId == null) {
            return articleMapper.countAllArticle();
        } else {
            return articleMapper.countArticleByCateId(Integer.valueOf(cateId));
        }
    }

    @Override
    public Integer countArticlesByYearAndMonth(String year, String month) {
        if (year==null&&month==null){
            return articleMapper.countAllArticle();
        }else{
            return articleMapper.countArticleByYearAndMonth(year, month);
        }
    }

    @Override
    public String selectTitleById(String id) {
        return articleMapper.selectTitleById(id);
    }

    @Override
    public List<ArticleExt> selectAllArticles() {
        return articleMapper.selectAllArticles();
    }

    @Override
    public ArticleExt selectArticleById(String id) {
        return articleMapper.selectArticleById(id);
    }

    @Override
    public List<ArticleExt> selectArticlesByPage(String page) {
        List<ArticleExt> articleList = null;
        if (page == null) {
            articleList = articleMapper.selectArticlesByPage(0);
        } else {
            articleList = articleMapper.selectArticlesByPage(Integer.valueOf(page) * 5 - 5);
        }
        return articleList;
    }

    @Override
    public List<ArticleExt> selectArticlesByCidAndPage(String cateId, String page) {
        List<ArticleExt> articleExtList = null;
        if (cateId == null) {
            //显示所有文章时文章总数量
            if (page == null) {
                //默认为第一页
                articleExtList = articleMapper.selectArticlesByPage(0);
            } else {
                articleExtList = articleMapper.selectArticlesByPage(Integer.valueOf(page) * 5 - 5);
            }
        } else {
            //显示该分类下文章总数量
            if (page == null) {
                //默认该分类下第一页
                articleExtList = articleMapper.selectArticlesByCidAndPage(Integer.valueOf(cateId), 0);
            } else {
                articleExtList = articleMapper.selectArticlesByCidAndPage(Integer.valueOf(cateId), Integer.valueOf(page) * 5 - 5);
            }
        }
        return articleExtList;
    }

    @Override
    public List<ArticleExt> selectArticlesByDateAndPage(String year, String month, String page) {
        if (year == null && month == null){
            if (page == null) {
                return articleMapper.selectArticlesByPage(0);
            } else {
                return articleMapper.selectArticlesByPage(Integer.valueOf(page) * 5 - 5);
            }
        }else {
            if (page == null) {
                return articleMapper.selectArticlesByDateAndPage(year, month, 0);
            }else {
                return articleMapper.selectArticlesByDateAndPage(year, month, Integer.valueOf(page));
            }
        }
    }

    @Override
    public void saveArticle(Article article) {
        articleMapper.saveArticle(article);
    }

    @Override
    public void delArticle(String id) {
        articleMapper.delArticle(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }
}
