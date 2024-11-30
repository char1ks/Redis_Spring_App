package com.example.RedisSpring_pet3.Controller.ThymeleafController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anime")
public class AnimeThymeleafController {

    @GetMapping("/main")
    public String mainPage(){
        return "anime/mainPage";
    }
    @GetMapping("/concrete/{id}")
    public String concretePage(){
        return "anime/concretePage";
    }
    @GetMapping("/new")
    public String newPage(){
        return "anime/newPage";
    }
}
