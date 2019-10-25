package com.pyq.blog.controller.index;

import com.pyq.blog.model.Archive;
import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.service.ArchiveService;
import com.pyq.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ArchiveController {

    @Autowired
    ArchiveService archiveService;

    @Autowired
    ArticleService articleService;

    @Value("${uploadFile.uploadLocation}")
    private String uploadLocation;

    @RequestMapping("archive")
    public String archive(String year, String month, String page, Model model) {
        //查询所有归档日期
        List<Archive> archiveList = archiveService.selectArchive();
        //查询文章数量
        Integer countArticle = articleService.countArticlesByYearAndMonth(year, month);
        //查询文章列表
        List<ArticleExt> articleList = articleService.selectArticlesByDateAndPage(year, month, page);
        model.addAttribute("archiveList", archiveList);
        model.addAttribute("uploadLocation", uploadLocation);
        model.addAttribute("articleList", articleList);
        model.addAttribute("ArticleCount", countArticle);
        //发送当前页码到前端交给js分页插件处理
        if (page == null) {
            model.addAttribute("curpage", 1);
        } else {
            model.addAttribute("curpage", Integer.valueOf(page));
        }
        return "index/archive";
    }
}
