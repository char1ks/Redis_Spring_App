package com.example.RedisSpring_pet3.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "Friend")
public class Friend {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "friend_role")
    @Enumerated(EnumType.STRING)
    private Friend_Role friend_role;

    public Friend() {}

    public Friend(String username, String password, Friend_Role friend_role) {
        this.username = username;
        this.password = password;
        this.friend_role = friend_role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Friend_Role getFriend_role() {
        return friend_role;
    }

    public void setFriend_role(Friend_Role friend_role) {
        this.friend_role = friend_role;
    }
}
