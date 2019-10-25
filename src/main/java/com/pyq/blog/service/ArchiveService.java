package com.pyq.blog.service;

import com.pyq.blog.model.Archive;
import com.pyq.blog.model.ArticleExt;

import java.util.List;


public interface ArchiveService {
    List<Archive> selectArchive();
}
