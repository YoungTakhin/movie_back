package com.ydx.movie.entity;

import javax.print.DocFlavor;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Movie implements Serializable {
    private int tmdbid;
    private String title;
    private Date date;
    private String genres;
    private String directing;
    private String actor;
    private String country;
    private String language;
    private int budget;
    private int revenue;
    private float vote;
    private int vote_count;
    private float recommendScore; //推荐指数，电影推荐用到

    public int getTmdbid() {
        return tmdbid;
    }

    public void setTmdbid(int tmdbid) {
        this.tmdbid = tmdbid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getDirecting() {
        return directing;
    }

    public void setDirecting(String directing) {
        this.directing = directing;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public float getVote() {
        return vote;
    }

    public void setVote(float vote) {
        this.vote = vote;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public float getRecommendScore() {
        return recommendScore;
    }

    public void setRecommendScore(float recommendScore) {
        this.recommendScore = recommendScore;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "tmdbid=" + tmdbid +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", genres='" + genres + '\'' +
                ", directing='" + directing + '\'' +
                ", actor='" + actor + '\'' +
                ", country='" + country + '\'' +
                ", language='" + language + '\'' +
                ", budget=" + budget +
                ", revenue=" + revenue +
                ", vote=" + vote +
                ", vote_count=" + vote_count +
                ", recommendScore=" + recommendScore +
                '}';
    }
}
