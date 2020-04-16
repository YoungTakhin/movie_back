package com.ydx.movie.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ydx.movie.entity.Movie;
import com.ydx.movie.entity.Recommend;
import com.ydx.movie.service.MovieService;
import com.ydx.movie.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.annotation.Retention;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags="推荐模块")
public class RecommedController {

    @Autowired
    private RecommendService recommendService;

    /**
     * 电影推荐
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/recommend")
    @ApiOperation(value="电影推荐", notes="使用协同过滤算法")
    public String recommendForUser(@PathVariable("userId") int userId) {
        return recommendService.recommendForUser(userId);
    }

}
