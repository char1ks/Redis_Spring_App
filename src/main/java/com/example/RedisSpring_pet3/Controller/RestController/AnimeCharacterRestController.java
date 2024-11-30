package com.example.RedisSpring_pet3.Controller.RestController;

import com.example.RedisSpring_pet3.Model.Anime_Character;
import com.example.RedisSpring_pet3.Service.AnimeCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime_character/api")
public class AnimeCharacterRestController {

    @Autowired
    private AnimeCharacterService operations;

    @GetMapping("/all")
    public List<Anime_Character> getAllCharacters(){
        return operations.getAllCharacters();
    }
    @GetMapping("/concrete/{id}")
    public Anime_Character getConcreteCharacter(@PathVariable("id") int id){
        return operations.getConcreteCharacter(id);
    }
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveCharacter(@RequestBody Anime_Character character){
        operations.saveCharacter(character);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCharacter(@PathVariable("id")int id){
        operations.deleteCharacter(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
