package com.pyq.blog.controller;

import com.pyq.blog.model.Link;
import com.pyq.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author Suave
 * @Date 2019/9/10 11:38
 * @Version 1.0
 */
@Controller
public class LinkController {

    @Autowired
    LinkService linkService;

    @RequestMapping("link")
    public String link(Model model) {
        try {
            List<Link> linkList = linkService.selectAllLink();
            model.addAttribute("linkList",linkList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index/link";
    }
}
