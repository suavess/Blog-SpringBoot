package com.pyq.blog.controller.admin;

import com.pyq.blog.mapper.AdminMapper;
import com.pyq.blog.model.Admin;
import com.pyq.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    AdminMapper adminMapper;

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Map<String,String> login(String username, String password, HttpSession httpSession){
        Map<String, String> map = new HashMap<>();
        Admin admin = adminMapper.selectAdminByUsername(username);
        if (admin==null){
            map.put("status","false");
            map.put("msg","没有该用户！");
        }else{
            if (admin.getPassword().equals(MD5Utils.MD5Encoding(password))){
                map.put("status","true");
                map.put("msg","登陆成功！");
                httpSession.setAttribute("loginUser",admin);
            }else{
                map.put("status","false");
                map.put("msg","密码错误！");
            }
        }
        return map;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("loginUser");
        return "redirect:/index";
    }

}
