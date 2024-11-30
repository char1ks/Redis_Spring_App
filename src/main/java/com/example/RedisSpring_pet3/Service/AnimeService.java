package com.example.RedisSpring_pet3.Service;

import com.example.RedisSpring_pet3.Model.Anime;
import com.example.RedisSpring_pet3.Redis.RedisPublisher;
import com.example.RedisSpring_pet3.Repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnimeService {

    @Autowired
    private RedisPublisher publisher;

    @Autowired
    private AnimeRepository operations;

    public List<Anime> getAllAnime(){
        publisher.publish("Были получены все аниме");
        return operations.findAll();
    }

    @Cacheable(value = "anime", key = "#id")
    public Anime getConcreteAnime(int id){
        publisher.publish("Было получено аниме с ID-"+id);
        return operations.findById(id).orElse(null);
    }

    @CachePut(value = "anime", key = "#anime.id")
    public Anime saveAnime(Anime anime) {
        Anime savedAnime = operations.save(anime);
        publisher.publish("Было сохранено аниме с ID-" + savedAnime.getId());
        return savedAnime; // Возвращаем сохраненный объект
    }

    @CacheEvict(value = "anime", key = "#id")
    public void deleteAnime(int id){
        operations.deleteById(id);
        publisher.publish("Было удалено аниме с ID-"+id);
    }
}
