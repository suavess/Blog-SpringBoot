package com.pyq.blog.service.Impl;

import com.pyq.blog.mapper.ArchiveMapper;
import com.pyq.blog.mapper.ArticleMapper;
import com.pyq.blog.model.Archive;
import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 16:58
 * @Version 1.0
 */
@Service("ArchiveService")
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    ArchiveMapper archiveMapper;

    @Autowired
    ArticleMapper articleMapper;

    /**
     * 归档列表
     * @return
     * @throws Exception
     */
    @Override
    public List<Archive> selectArchive() throws Exception {
        List<Archive> archiveList = archiveMapper.selectArchive();
        for (Archive archive:archiveList) {
            String year = archive.getYear();
            String month = archive.getMonth();
            if (Integer.valueOf(month)<10){
                month = "0"+month;
                archive.setMonth(month);
            }
            Integer count = archiveMapper.countArticleByYearAndMonth(year, month);
            archive.setArticleNum(String.valueOf(count));
        }
        return archiveList;
    }

    //文章列表
    @Override
    public List<ArticleExt> selectArticlesByYearAndMonth(String year, String month) throws Exception {
        return articleMapper.selectArticlesByYearAndMonth(year, month);
    }
}
