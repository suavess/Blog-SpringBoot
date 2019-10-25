package com.pyq.blog.controller.index;

import com.pyq.blog.model.ArticleCategoryExt;
import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.service.ArticleCategoryService;
import com.pyq.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    ArticleCategoryService articleCategoryService;

    @Autowired
    ArticleService articleService;

    @Value("${uploadFile.uploadLocation}")
    private String uploadLocation;

    @RequestMapping("/category")
    public String category(String cid, String page, Model model) {
        //查询该分类下文章数量，未指定分类则查询所有文章数量
        Integer countAllArticle = articleService.countArticlesByCateId(cid);
        //查询分类列表
        List<ArticleCategoryExt> categoryExtList = articleCategoryService.selectAllCategory();
        //查询该分类该页码下的文章列表
        List<ArticleExt> articleExtList = articleService.selectArticlesByCidAndPage(cid, page);
        //图片根路径
        model.addAttribute("uploadLocation", uploadLocation);
        model.addAttribute("ArticleCount", countAllArticle);
        model.addAttribute("categoryList", categoryExtList);
        model.addAttribute("articleList", articleExtList);
        //添加当前页码，交给前端js分页插件处理
        if (page == null){
            model.addAttribute("curpage", 1);
        }else {
            model.addAttribute("curpage", Integer.valueOf(page));
        }
        return "index/category";
    }
}
