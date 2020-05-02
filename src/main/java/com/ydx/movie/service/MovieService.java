package com.ydx.movie.service;

import com.ydx.movie.entity.Movie;

import java.util.List;

public interface MovieService {

    /**
     * 分页查询电影列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Movie> getMovies(int pageNo, int pageSize);

    /**
     * 根据tmdb id查询电影
     * @param tmdbid
     * @return
     */
    Movie findMovieByTmdbid(int tmdbid);

    /**
     * 查询电影总数
     * @return
     */
    int numOfMovies();

    /**
     * 通过电影名模糊查询电影
     * @param movieName
     * @return
     */
    List<Movie> findMoviesByName(String movieName, int pageNo, int pageSize);

    /**
     * 查询搜索结果总数
     * @param movieName
     * @return
     */
    int countOfSearch(String movieName);

    /**
     * 删除电影
     * @param tmdbId
     * @return
     */
    int deleteMovie(int tmdbId);
}
