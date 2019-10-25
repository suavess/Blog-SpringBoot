package com.pyq.blog.service;

import com.pyq.blog.model.ArticleCategory;
import com.pyq.blog.model.ArticleCategoryExt;

import java.util.List;

public interface ArticleCategoryService {
    List<ArticleCategoryExt> selectAllCategory();
    ArticleCategory selectCategoryById(String id);
    void delCategoryById(String id);
    void updateCategoryById(ArticleCategory articleCategory);
    void addCategory(String cateName);
}
