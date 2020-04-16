package com.ydx.movie.entity;

import java.io.Serializable;

public class Rating implements Serializable {

    private int userId;
    private int tmdbid;
    private float ratingScore;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTmdbid() {
        return tmdbid;
    }

    public void setTmdbid(int tmdbid) {
        this.tmdbid = tmdbid;
    }

    public float getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(float ratingScore) {
        this.ratingScore = ratingScore;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "userId=" + userId +
                ", tmdbid=" + tmdbid +
                ", ratingScore=" + ratingScore +
                '}';
    }
}
