package com.ydx.movie.controller;

import com.alibaba.fastjson.JSON;
import com.ydx.movie.controller.vo.MovieVo;
import com.ydx.movie.entity.Movie;
import com.ydx.movie.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@Api(tags="电影模块")
public class MovieController {
    @Autowired
    private MovieService movieService;

    /**
     * 分页查询电影
     * @param pageNo
     * @return
     */
    @GetMapping("/{pageNo}/movies/{perPage}")
    @ApiOperation(value="分页查询电影", notes="分页查询电影")
    public String getMovies(@PathVariable("pageNo") int pageNo, @PathVariable("perPage") int perPage) {
        List<Movie> movies = movieService.getMovies(perPage * (pageNo - 1), perPage);
        return JSON.toJSONString(movies);
    }

    /**
     * 根据tmdb id查询电影
     * @param tmdbid
     * @return
     */
    @GetMapping("/movie/{tmdbid}")
    @ApiOperation(value="根据tmdbid查询电影", notes="根据tmdbid查询电影")
    public String findMovieByTmdbid(@PathVariable("tmdbid") int tmdbid) {
        Movie movie = movieService.findMovieByTmdbid(tmdbid);
        return JSON.toJSONString(movie);
    }

    /**
     * 查询电影总数
     * @return
     */
    @GetMapping("/movies/count")
    @ApiOperation(value="查询电影总数", notes="查询电影总数")
    public int numOfMovies() {
        return movieService.numOfMovies();
    }

    /**
     * 搜索电影
     * @param movieVo
     * @return
     */
    @PostMapping(value="/movies/search")
    @ApiOperation(value="搜索电影", notes="根据电影名模糊分页搜索电影")
    public String findMoviesByName(@RequestBody MovieVo movieVo) {
        List<Movie> movies = movieService.findMoviesByName(movieVo.getMovieName(),
                movieVo.getPerPage() * (movieVo.getPageNo() - 1), movieVo.getPerPage());
        return JSON.toJSONString(movies);
    }

    /**
     * 搜索电影结果数
     * @param movieName
     * @return
     */
    @GetMapping(value="/movies/search/count")
    @ApiOperation(value="搜索电影结果数", notes="返回搜索出的电影数")
    public int countOfSearch(String movieName) {
        return movieService.countOfSearch(movieName);
    }

    /**
     * 删除电影
     * @param tmdbId
     * @return
     */
    @PostMapping(value = "/movie/delete/{tmdbId}")
    @ApiOperation(value="删除电影", notes="根据电影TMDB ID删除电影")
    public int deleteMovie(@PathVariable("tmdbId") int tmdbId) {
        return movieService.deleteMovie(tmdbId);
    }
}
