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

/**
 * @Author Suave
 * @Date 2019/9/10 11:23
 * @Version 1.0
 */
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
        Integer offset = null;
        Integer curpage = null;
        Integer countArticle = null;
        List<ArticleExt> articleList = null;
        try {
            List<Archive> archiveList = archiveService.selectArchive();
            model.addAttribute("archiveList", archiveList);
            if (year == null && month == null) {
                countArticle = articleService.countAllArticle();
                if (page == null){
                    offset = 0;
                    curpage = 1;
                    articleList = articleService.selectArticlesByPage(offset);
                }else {
                    offset = Integer.valueOf(page)*5-5;
                    curpage = Integer.valueOf(page);
                    articleList = articleService.selectArticlesByPage(offset);
                }
            } else {
                countArticle = articleService.countArticlesByYearAndMonth(year, month);
                if (page == null){
                    offset = 0;
                    curpage = 1;
                    articleList = articleService.selectArticlesByDateAndPage(year, month, offset);
                }else {
                    offset = Integer.valueOf(page)*5-5;
                    curpage = Integer.valueOf(page);
                    articleList = articleService.selectArticlesByDateAndPage(year, month, offset);
                }
            }
            model.addAttribute("uploadLocation",uploadLocation);
            model.addAttribute("articleList",articleList);
            model.addAttribute("ArticleCount",countArticle);
            model.addAttribute("curpage",curpage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index/archive";
    }
}
