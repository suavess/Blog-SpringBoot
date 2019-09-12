package com.pyq.blog.controller;

import com.pyq.blog.model.ArticleCategoryExt;
import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.service.ArticleCategoryService;
import com.pyq.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 11:22
 * @Version 1.0
 */
@Controller
public class CategoryController {

    @Autowired
    ArticleCategoryService articleCategoryService;

    @Autowired
    ArticleService articleService;

    @RequestMapping("category")
    public String category(String cid,String page,Model model){
        try {
            //左侧文章分类栏目
            List<ArticleCategoryExt> categoryExtList = articleCategoryService.selectAllCategory();
            model.addAttribute("categoryList",categoryExtList);
            if (cid==null){
                //显示所有文章时文章总数量
                Integer countAllArticle = articleService.countAllArticle();
                model.addAttribute("ArticleCount",countAllArticle);
                if (page==null){
                    //默认为第一页
                    List<ArticleExt> articleExtList = articleService.selectArticlesByPage(0);
                    model.addAttribute("articleList",articleExtList);
                    model.addAttribute("curpage",1);
                }else{
                    List<ArticleExt> articleExtList = articleService.selectArticlesByPage(Integer.valueOf(page)*5-5);
                    model.addAttribute("articleList",articleExtList);
                    model.addAttribute("curpage",Integer.valueOf(page));
                }
            }else{
                //显示该分类下文章总数量
                Integer countArticleByCid = articleService.countArticlesByCateId(Integer.valueOf(cid));
                model.addAttribute("ArticleCount",countArticleByCid);
                if (page == null) {
                    //默认该分类下第一页
                    List<ArticleExt> articleExtList = articleService.selectArticlesByCidAndPage(Integer.valueOf(cid),0);
                    model.addAttribute("articleList",articleExtList);
                    model.addAttribute("curpage",1);
                }else{
                    List<ArticleExt> articleExtList = articleService.selectArticlesByCidAndPage(Integer.valueOf(cid),Integer.valueOf(page)*5-5);
                    model.addAttribute("articleList",articleExtList);
                    model.addAttribute("curpage",Integer.valueOf(page));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index/category";
    }
}
