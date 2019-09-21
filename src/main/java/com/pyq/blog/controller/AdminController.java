package com.pyq.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Suave
 * @Date 2019/9/12 16:49
 * @Version 1.0
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String admin(){
        return "admin/index";
    }
}
