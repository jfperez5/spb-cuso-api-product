package com.caneksoft.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String year;
    private String votes;
    private double rating;
    
    @JsonProperty("imagenUrl")
    @Column(name="imagen_url")
    private String imagenUrl;


    public Movie(Long id, String title, String year, String votes, double rating, String imagenUrl) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.votes = votes;
        this.rating = rating;
        this.imagenUrl = imagenUrl;
    }


    public Movie() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getYear() {
        return year;
    }


    public void setYear(String year) {
        this.year = year;
    }


    public String getVotes() {
        return votes;
    }


    public void setVotes(String votes) {
        this.votes = votes;
    }


    public double getRating() {
        return rating;
    }


    public void setRating(double rating) {
        this.rating = rating;
    }


    public String getImagenUrl() {
        return imagenUrl;
    }


    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }


    @Override
    public String toString() {
        return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", votes=" + votes + ", rating=" + rating
                + ", imagenUrl=" + imagenUrl + "]";
    }

    




}


// Dominando API REST con Spring Boot. Taller Completo | GOGODEV     3:16:39
// by GOGODEV