package com.ydx.movie.service;

import com.ydx.movie.entity.Rating;

import java.util.List;

public interface RatingService {

    public float findByUserIdAndTmdbId(int userId, int tmdbId);

    public List<Rating> findByUserId(int pageNo, int userId);

    public int addRating(int userId, int tmdbId, float rating);
}
