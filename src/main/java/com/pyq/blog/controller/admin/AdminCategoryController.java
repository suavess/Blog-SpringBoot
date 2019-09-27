package com.pyq.blog.controller.admin;

import com.pyq.blog.model.ArticleCategory;
import com.pyq.blog.model.ArticleCategoryExt;
import com.pyq.blog.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminCategoryController {

    @Autowired
    ArticleCategoryService articleCategoryService;

    @RequestMapping("/categoryList")
    public String categoryList(Model model){
        List<ArticleCategoryExt> articleCategoryList = null;
        try {
            articleCategoryList = articleCategoryService.selectAllCategory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("CategoryList",articleCategoryList);
        return "admin/categoryList";
    }

    @GetMapping("/addCategory")
    public String addCategoryPage(){
        return "admin/addCategory";
    }

    @PostMapping("/addCategory")
    @ResponseBody
    public void addCategory(String cateName){
        try {
            articleCategoryService.addCategory(cateName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/editCategory")
    public String editCategory(String id,Model model){
        ArticleCategory articleCategory = null;
        try {
            articleCategory = articleCategoryService.selectCategoryById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("articleCategory",articleCategory);
        return "admin/editCategory";
    }

    @PostMapping("/editCategory")
    @ResponseBody
    public void editCategory(ArticleCategory articleCategory){
        try {
            articleCategoryService.updateCategoryById(articleCategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/delCategory")
    @ResponseBody
    public void delCategory(String id){
        try {
            articleCategoryService.delCategoryById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
