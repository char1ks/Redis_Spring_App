package com.example.RedisSpring_pet3.Service;

import com.example.RedisSpring_pet3.Model.Anime_Character;
import com.example.RedisSpring_pet3.Redis.RedisPublisher;
import com.example.RedisSpring_pet3.Repository.AnimeCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnimeCharacterService {

    @Autowired
    private AnimeCharacterRepository operations;

    @Autowired
    private RedisPublisher publisher;

    public List<Anime_Character> getAllCharacters(){
        publisher.publish("Были получены все аниме-персонажи");
        return operations.findAll();
    }
    public Anime_Character getConcreteCharacter(int id){
        publisher.publish("Был получен аниме-персонаж с ID-"+id);
        return operations.findById(id).orElse(null);
    }
    public void saveCharacter(Anime_Character character){
        operations.save(character);
        publisher.publish("Был сохранен аниме-персонаж с ID-"+character.getId());
    }
    public void deleteCharacter(int id){
        operations.deleteById(id);
        publisher.publish("Был удален аниме-персонаж с ID-"+id);
    }

}
