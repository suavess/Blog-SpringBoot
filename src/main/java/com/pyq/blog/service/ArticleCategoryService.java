package com.pyq.blog.service;

import com.pyq.blog.model.ArticleCategoryExt;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 14:57
 * @Version 1.0
 */
public interface ArticleCategoryService {
    List<ArticleCategoryExt> selectAllCategory() throws Exception;
}
