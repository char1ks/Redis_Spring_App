package com.example.RedisSpring_pet3.Controller.ThymeleafController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anime_character")
public class AnimeCharacterThymeleafController {

    @GetMapping("/main")
    public String mainPage(){
        return "anime_character/mainPage";
    }
    @GetMapping("/concrete/{id}")
    public String concretePage(){
        return "anime_character/concretePage";
    }
    @GetMapping("/new")
    public String newPage(){
        return "anime_character/newPage";
    }
}
