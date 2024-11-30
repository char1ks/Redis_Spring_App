package com.example.RedisSpring_pet3.Security;

import com.example.RedisSpring_pet3.Model.Friend;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FriendDetails implements UserDetails {

    private Friend friend;

    public FriendDetails(Friend friend) {
        this.friend = friend;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(friend.getFriend_role().name()));
    }

    @Override
    public String getPassword() {
        return friend.getPassword();
    }

    @Override
    public String getUsername() {
        return friend.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Friend getFriend() {
        return friend;
    }
}
