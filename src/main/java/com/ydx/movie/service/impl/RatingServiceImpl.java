package com.ydx.movie.service.impl;

import com.ydx.movie.entity.Rating;
import com.ydx.movie.mapper.RatingMapper;
import com.ydx.movie.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ratingService")
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingMapper ratingMapper;

    @Override
    public float findByUserIdAndTmdbId(int userId, int tmdbId) {
        return ratingMapper.findByUserIdAndTmdbId(userId, tmdbId);
    }

    @Override
    public List<Rating> findByUserId(int pageNo, int userId) {
        return ratingMapper.findByUserId(pageNo, userId, 24);
    }

    @Override
    public int addRating(int userId, int tmdbId, float rating) {
        return ratingMapper.addRating(userId, tmdbId, rating);
    }
}
