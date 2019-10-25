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

@Service("ArticleCategoryService")
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Autowired
    ArticleCategoryMapper articleCategoryMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<ArticleCategoryExt> selectAllCategory(){
        List<ArticleCategoryExt> categoryExtArrayList = articleCategoryMapper.selectAll();
        return categoryExtArrayList;
    }

    @Transactional
    @Override
    public void addCategory(String cateName){
        articleCategoryMapper.addCategory(cateName);
    }

    @Override
    public ArticleCategory selectCategoryById(String id){
        return articleCategoryMapper.selectCategoryById(id);
    }

    @Transactional
    @Override
    public void updateCategoryById(ArticleCategory articleCategory){
        articleCategoryMapper.updateCategoryById(articleCategory);
    }

    @Transactional
    @Override
    public void delCategoryById(String id){
        articleCategoryMapper.delCategoryById(id);
    }


}
