package com.example.RedisSpring_pet3.Controller.RestController;

import com.example.RedisSpring_pet3.Model.Friend;
import com.example.RedisSpring_pet3.Service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend/api")
public class FriendRestController {

    @Autowired
    private FriendService operations;

    @GetMapping("/all")
    public List<Friend> getAll(){
        return operations.getAllFriend();
    }
    @GetMapping("/concrete/{id}")
    public Friend getConcrete(@PathVariable("id")int id){
        return operations.getConcreteFriend(id);
    }
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveFriend(@RequestBody Friend friend){
        operations.saveFriend(friend);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFriend(@PathVariable("id")int id){
        operations.deleteFriend(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
