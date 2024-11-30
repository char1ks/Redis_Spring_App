package com.example.RedisSpring_pet3.Controller.RestController;

import com.example.RedisSpring_pet3.Model.Anime;
import com.example.RedisSpring_pet3.Service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime/api")
public class AnimeRestController {

    @Autowired
    private AnimeService operations;

    @GetMapping("/all")
    public List<Anime> getAllAnime(){
        return operations.getAllAnime();
    }
    @GetMapping("/concrete/{id}")
    public Anime getConcreteAnime(@PathVariable("id")int id){
        return operations.getConcreteAnime(id);
    }
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveAnime(@RequestBody Anime anime){
        operations.saveAnime(anime);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAnime(@PathVariable("id")int id){
        operations.deleteAnime(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
