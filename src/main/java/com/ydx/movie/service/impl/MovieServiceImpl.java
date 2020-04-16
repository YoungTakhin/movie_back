package com.ydx.movie.service.impl;

import com.ydx.movie.entity.Movie;
import com.ydx.movie.mapper.MovieMapper;
import com.ydx.movie.service.MovieService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("movieService")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> getMovies(int pageNo, int pageSize) {
        return movieMapper.getMovies(pageNo, pageSize);
    }

    @Override
    public Movie findMovieByTmdbid(int tmdbid) {
        return movieMapper.findMoviesByTmdbid(tmdbid);
    }

    @Override
    public int numOfMovies() {
        return movieMapper.numOfMovies();
    }

    @Override
    public List<Movie> findMoviesByName(String movieName, int pageNo, int pageSize) {
        return movieMapper.findMoviesByName(movieName, pageNo, pageSize);
    }

    @Override
    public int countOfSearch(String movieName) {
        return movieMapper.countOfSearch(movieName);
    }
}
