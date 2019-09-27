package com.pyq.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("")
    public String admin(){
        return "admin/index";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "admin/welcome";
    }


}
