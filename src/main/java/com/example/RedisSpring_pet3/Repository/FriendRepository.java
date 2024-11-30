package com.example.RedisSpring_pet3.Repository;

import com.example.RedisSpring_pet3.Model.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<Friend,Integer> {
    Friend findByUsername(String username);
}
