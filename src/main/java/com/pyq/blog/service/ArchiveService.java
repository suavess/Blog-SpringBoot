package com.pyq.blog.service;

import com.pyq.blog.model.Archive;
import com.pyq.blog.model.ArticleExt;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 16:58
 * @Version 1.0
 */
public interface ArchiveService {
    List<Archive> selectArchive() throws Exception;
    List<ArticleExt> selectArticlesByYearAndMonth(String year, String month) throws Exception;
}
