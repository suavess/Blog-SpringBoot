package com.pyq.blog.service;

import com.pyq.blog.model.ArticleCategory;
import com.pyq.blog.model.ArticleCategoryExt;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 14:57
 * @Version 1.0
 */
public interface ArticleCategoryService {
    List<ArticleCategoryExt> selectAllCategory() throws Exception;
    ArticleCategory selectCategoryById(String id) throws Exception;
    void delCategoryById(String id) throws Exception;
    void updateCategoryById(ArticleCategory articleCategory) throws Exception;
    void addCategory(String cateName) throws Exception;
}
