package com.ydx.movie.controller;

import com.alibaba.fastjson.JSON;
import com.ydx.movie.controller.vo.RatingVo;
import com.ydx.movie.entity.Rating;
import com.ydx.movie.service.RatingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags="评分模块")
public class RatingController {

    @Autowired
    RatingService ratingService;

    /**
     * 查询指定用户对指定电影的评分
     * @param userId 用户id
     * @param tmdbId tmdb id
     * @return
     */
    @GetMapping(value="/rating/{userId}/{tmdbId}")
    @ApiOperation(value="获取指定评分", notes="查询指定用户对指定电影的评分")
    public float findByUserIdAndTmdbId(@PathVariable("userId") int userId, @PathVariable("tmdbId") int tmdbId) {
        return ratingService.findByUserIdAndTmdbId(userId, tmdbId);
    }

    /**
     * 查询指定用户的评分列表
     * @param userId 用户id
     * @return
     */
    @GetMapping(value="/{pageNo}/rating/{userId}")
    @ApiOperation(value="获取指定用户的评分列表", notes="分页查询指定用户的评分列表")
    public String findByUserId(@PathVariable("pageNo") int pageNo, @PathVariable("userId") int userId) {
        List<Rating> ratings = ratingService.findByUserId(pageNo, userId);
        return JSON.toJSONString(ratings);
    }

    /**
     * 用户添加评分
     * @param ratingVo
     * @return 添加记录数
     */
    @PostMapping(value = "/rating")
    @ApiOperation(value="用户添加评分", notes="用户为指定电影打分")
    public int addRating(@RequestBody RatingVo ratingVo) {
        return ratingService.addRating(ratingVo.getUserId(),
                ratingVo.getTmdbId(), ratingVo.getRating());
    }
}
