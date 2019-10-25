package com.pyq.blog.controller.index;

import com.pyq.blog.model.ArticleExt;
import com.pyq.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DetailController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/detail")
    public String detail(String id, Model model) {
        if (id == null) {
            //当未传Id时直接抛出运行时异常
            throw new RuntimeException();
        } else {
            //查询该篇文章详情
            ArticleExt article = articleService.selectArticleById(id);
            //查询上一篇文章标题
            String lastTitle = articleService.selectTitleById(String.valueOf(Integer.valueOf(id) + 1));
            //查询下一篇文章标题
            String nextTitle = articleService.selectTitleById(String.valueOf(Integer.valueOf(id) + 1));
            model.addAttribute("lastTitle", lastTitle);
            model.addAttribute("lastId", String.valueOf(Integer.valueOf(id) - 1));
            model.addAttribute("nextTitle", nextTitle);
            model.addAttribute("nextId", String.valueOf(Integer.valueOf(id) + 1));
            model.addAttribute("article", article);
        }
        return "index/article-detail";
    }
}
