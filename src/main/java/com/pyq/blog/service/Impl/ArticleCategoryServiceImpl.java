package com.pyq.blog.service.Impl;

import com.pyq.blog.mapper.ArticleCategoryMapper;
import com.pyq.blog.mapper.ArticleMapper;
import com.pyq.blog.model.ArticleCategoryExt;
import com.pyq.blog.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
