package com.example.RedisSpring_pet3.Service;

import com.example.RedisSpring_pet3.Model.Friend;
import com.example.RedisSpring_pet3.Redis.RedisPublisher;
import com.example.RedisSpring_pet3.Repository.FriendRepository;
import com.example.RedisSpring_pet3.Security.FriendDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FriendService implements UserDetailsService {
    @Autowired
    private RedisPublisher publisher;

    @Autowired
    private FriendRepository operations;

    public List<Friend> getAllFriend(){
        return operations.findAll();
    }
    public Friend getConcreteFriend(int id){
        return operations.findById(id).orElse(null);
    }

    public void saveFriend(Friend friend){
        operations.save(friend);
    }
    public void deleteFriend(int id){
        operations.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Friend> friendFind= Optional.ofNullable(operations.findByUsername(username));
        if(friendFind.isEmpty())
            throw new UsernameNotFoundException("Друг не найден :(");
        return new FriendDetails(friendFind.get());
    }
}
