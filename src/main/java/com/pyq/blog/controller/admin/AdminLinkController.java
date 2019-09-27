package com.pyq.blog.controller.admin;

import com.pyq.blog.model.Link;
import com.pyq.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminLinkController {

    @Autowired
    private LinkService linkService;

    @RequestMapping("linkList")
    public String linkPage(Model model){
        List<Link> linkList = null;
        try {
            linkList = linkService.selectAllLink();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("linkList",linkList);
        return "admin/linkList";
    }

    @GetMapping("addLink")
    public String addLinkPage(){
        return "admin/addLink";
    }

    @PostMapping("addLink")
    @ResponseBody
    public void addLink(String linkName,String linkHref){
        Link link = new Link();
        link.setName(linkName);
        link.setHref(linkHref);
        try {
            linkService.addLink(link);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("editLink")
    public String editLinkPage(String id,Model model){
        Link link = null;
        try {
            link = linkService.selectLinkById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("link",link);
        return "admin/editLink";
    }

    @PostMapping("editLink")
    @ResponseBody
    public void editLink(Link link){
        try {
            linkService.updateLink(link);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("delLink")
    @ResponseBody
    public void delLink(String id){
        try {
            linkService.delLink(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
