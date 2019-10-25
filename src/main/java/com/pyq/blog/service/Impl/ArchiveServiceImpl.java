package com.pyq.blog.service.Impl;

import com.pyq.blog.mapper.ArchiveMapper;
import com.pyq.blog.mapper.ArticleMapper;
import com.pyq.blog.model.Archive;
import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.service.ArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ArchiveService")
public class ArchiveServiceImpl implements ArchiveService {

    @Autowired
    ArchiveMapper archiveMapper;

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Archive> selectArchive(){
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
}
