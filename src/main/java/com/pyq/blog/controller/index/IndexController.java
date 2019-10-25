package com.pyq.blog.controller.index;

import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.model.Profile;
import com.pyq.blog.service.ArticleService;
import com.pyq.blog.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 首页
 */
@Controller
public class IndexController {

    @Autowired
    ArticleService articleService;
    @Autowired
    ProfileService profileService;
    @Value("${uploadFile.uploadLocation}")
    private String uploadLocation;

    @RequestMapping(value = {"/","/index"})
    public String index(String page, Model model) throws Exception {
        //查询文章列表
        List<ArticleExt> articleList = articleService.selectArticlesByPage(page);
        //查询总文章数
        Integer countAllArticle = articleService.countAllArticle();
        //查询网站介绍
        Profile profile = profileService.selectAll();
        //首页每张图片的根链接
        model.addAttribute("uploadLocation",uploadLocation);
        model.addAttribute("articleList",articleList);
        model.addAttribute("ArticleCount",countAllArticle);
        model.addAttribute("Profile",profile);
        //添加当前页码
        if (page == null){
            model.addAttribute("curpage",0);
        }else{
            model.addAttribute("curpage",Integer.valueOf(page));
        }
        return "index/index";
    }

}
