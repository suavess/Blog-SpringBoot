package com.pyq.blog.controller;

import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.model.Profile;
import com.pyq.blog.service.ArticleService;
import com.pyq.blog.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/9 17:24
 * @Version 1.0
 */

@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;
    @Autowired
    ProfileService profileService;

    @RequestMapping(value = {"/","/index"})
    public String index(String page, Model model) throws Exception {
        Integer offset = null;
        Integer curpage = null;
        List<ArticleExt> articleList = null;
        if (page == null){
            offset = 0;
            curpage = 1;
            articleList = articleService.selectArticlesByPage(offset);
        }else {
            offset = Integer.valueOf(page)*5-5;
            curpage = Integer.valueOf(page);
            articleList = articleService.selectArticlesByPage(offset);
        }
        Integer countAllArticle = articleService.countAllArticle();
        Profile profile = profileService.selectAll();
        model.addAttribute("articleList",articleList);
        model.addAttribute("ArticleCount",countAllArticle);
        model.addAttribute("Profile",profile);
        model.addAttribute("curpage",curpage);
        return "index/index";
    }
}
