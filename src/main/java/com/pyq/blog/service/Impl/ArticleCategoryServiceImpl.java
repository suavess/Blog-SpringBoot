package com.pyq.blog.service.Impl;

import com.pyq.blog.mapper.ArticleCategoryMapper;
import com.pyq.blog.mapper.ArticleMapper;
import com.pyq.blog.model.ArticleCategory;
import com.pyq.blog.model.ArticleCategoryExt;
import com.pyq.blog.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 14:59
 * @Version 1.0
 */
@Service("ArticleCategoryService")
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Autowired
    ArticleCategoryMapper articleCategoryMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<ArticleCategoryExt> selectAllCategory() throws Exception {
        List<ArticleCategoryExt> categoryExtArrayList = articleCategoryMapper.selectAll();
        return categoryExtArrayList;
    }

    @Transactional
    @Override
    public void addCategory(String cateName) throws Exception {
        articleCategoryMapper.addCategory(cateName);
    }

    @Override
    public ArticleCategory selectCategoryById(String id) throws Exception {
        return articleCategoryMapper.selectCategoryById(id);
    }

    @Transactional
    @Override
    public void updateCategoryById(ArticleCategory articleCategory) throws Exception {
        articleCategoryMapper.updateCategoryById(articleCategory);
    }

    @Transactional
    @Override
    public void delCategoryById(String id) throws Exception {
        articleCategoryMapper.delCategoryById(id);
    }
}
