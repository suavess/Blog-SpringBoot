package com.pyq.blog.controller.index;

import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Suave
 * @Date 2019/9/11 13:22
 * @Version 1.0
 */
@Controller
public class DetailController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("detail")
    public String detail(String id, Model model) {
        try {
            if (id == null) {
                throw new RuntimeException();
            } else {
                ArticleExt article = articleService.selectArticleById(id);
                System.out.println(article.getCreateTime());
                String lastTitle = articleService.selectTitleById(String.valueOf(Integer.valueOf(id)+1));
                String nextTitle = articleService.selectTitleById(String.valueOf(Integer.valueOf(id)+1));
                model.addAttribute("lastTitle",lastTitle);
                model.addAttribute("lastId",String.valueOf(Integer.valueOf(id)-1));
                model.addAttribute("nextTitle",nextTitle);
                model.addAttribute("nextId",String.valueOf(Integer.valueOf(id)+1));
                model.addAttribute("article",article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index/article-detail";
    }
}
