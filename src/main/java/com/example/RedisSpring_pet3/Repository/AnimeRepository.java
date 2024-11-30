package com.example.RedisSpring_pet3.Repository;

import com.example.RedisSpring_pet3.Model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends JpaRepository<Anime,Integer> {
}
