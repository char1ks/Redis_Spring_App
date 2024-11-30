package com.example.RedisSpring_pet3.Controller.ThymeleafController;

import com.example.RedisSpring_pet3.Model.Friend_Role;
import com.example.RedisSpring_pet3.Security.FriendDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/friend")
public class FriendThymeleafController {

    @GetMapping("/login")
    public String loginPage(){
        return "friend/loginPage";
    }
    @GetMapping("/register")
    public String registerPage(){
        return "friend/registerPage";
    }
    @GetMapping("/mainPage")
    public String mainPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        FriendDetails current= (FriendDetails) authentication.getPrincipal();
        if(current.getFriend().getFriend_role() == Friend_Role.ROLE_ADMIN){
            return "friend/admin_mainPage";
        }
        else if(current.getFriend().getFriend_role() == Friend_Role.ROLE_GOOD){
            return "friend/good_mainPage";
        }
        else {
            return "friend/default_mainPage";
        }
    }
    @GetMapping("/changes")
    public String changes(){
        return "friend/lastChanges";
    }
}
