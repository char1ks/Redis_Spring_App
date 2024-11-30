package com.example.RedisSpring_pet3.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "anime")
public class Anime implements Serializable {
    private static final long serialVersionUID = 1L; // Рекомендуется для сериализации

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "anime_name") // Исправлено имя колонки для соответствия стандартам
    private String animeName;

    @Column(name = "creator")
    private String creator;

    @Column(name = "rating")
    private int rating;

    @JsonBackReference
    @OneToMany(mappedBy = "anime")
    private List<Anime_Character> anime_chars;

    public Anime() {}

    public Anime(String animeName, String creator, int rating) {
        this.animeName = animeName;
        this.creator = creator;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Anime_Character> getAnime_chars() {
        return anime_chars;
    }

    public void setAnime_chars(List<Anime_Character> anime_chars) {
        this.anime_chars = anime_chars;
    }
}