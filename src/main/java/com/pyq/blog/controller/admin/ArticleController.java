package com.pyq.blog.controller.admin;

import com.pyq.blog.model.Article;
import com.pyq.blog.model.ArticleCategoryExt;
import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.service.ArticleCategoryService;
import com.pyq.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class ArticleController {

    @Autowired
    ArticleCategoryService articleCategoryService;

    @Autowired
    ArticleService articleService;

    @Value("${uploadFile.uploadLocation}")
    private String uploadLocation;

    @Value("${uploadFile.location}")
    private String uploadFileLocation;


    @RequestMapping("articleList")
    public String articleList(Model model){
        List<ArticleExt> allArticles = null;
        try {
            allArticles = articleService.selectAllArticles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("allArticles",allArticles);
        model.addAttribute("uploadLocation",uploadLocation);
        return "admin/articleList";
    }

    @GetMapping("addArticle")
    public String addArticlePage(Model model){
        List<ArticleCategoryExt> categoryList = null;
        try {
            categoryList = articleCategoryService.selectAllCategory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("categoryList",categoryList);
        return "admin/addArticle";
    }

    @PostMapping("addArticle")
    @ResponseBody
    public void addArticle(MultipartFile image, String title, String cate_id, String desc, String content){
        Article article = new Article();
        article.setTitle(title);
        article.setCateId(Integer.valueOf(cate_id));
        article.setDesc(desc);
        article.setContent(content);
        try {
            //将图片保存到static文件夹里，并保存image路径到数据库
            article.setImage(saveImage(image));
            articleService.saveArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("editArticle")
    public String editArticlePage(String id, Model model){
        ArticleExt articleExt = null;
        List<ArticleCategoryExt> categoryList = null;
        try {
            articleExt = articleService.selectArticleById(id);
            categoryList = articleCategoryService.selectAllCategory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("article",articleExt);
        model.addAttribute("uploadLocation",uploadLocation);
        return "admin/editArticle";
    }

    @DeleteMapping("editArticle")
    @ResponseBody
    public void editArticle(MultipartFile image,String id, String title, String cate_id, String desc, String content){
        Article article = new Article();
        article.setId(Integer.valueOf(id));
        article.setTitle(title);
        article.setCateId(Integer.valueOf(cate_id));
        article.setDesc(desc);
        article.setContent(content);
        try {
            if (!image.isEmpty()){
                article.setImage(saveImage(image));
            }else{
                article.setImage(null);
            }
            articleService.updateArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @PostMapping("delArticle")
    @ResponseBody
    public void delArticle(String id){
        try {
            articleService.delArticle(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String saveImage(MultipartFile image) throws IOException {
        //获取文件名
        String fileName = image.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;
        image.transferTo(new File(uploadFileLocation+fileName));
        return fileName;
    }

}
