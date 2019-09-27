package com.pyq.blog.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.pyq.blog.model.Profile;
import com.pyq.blog.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SystemController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/system")
    public String system(Model model){
        Profile profile = null;
        try {
            profile = profileService.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("profile",profile);
        return "admin/system";
    }

    @PostMapping("/system")
    @ResponseBody
    public boolean saveProfile(Profile profile){
        try {
            profileService.updateProfile(profile);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
