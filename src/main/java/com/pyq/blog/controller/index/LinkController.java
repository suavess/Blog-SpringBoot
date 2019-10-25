package com.pyq.blog.controller.index;

import com.pyq.blog.model.Link;
import com.pyq.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LinkController {

    @Autowired
    LinkService linkService;

    @RequestMapping("link")
    public String link(Model model) {
        //查询所有友链
        List<Link> linkList = linkService.selectAllLink();
        model.addAttribute("linkList", linkList);
        return "index/link";
    }
}
