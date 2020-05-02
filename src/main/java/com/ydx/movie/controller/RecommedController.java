package com.ydx.movie.controller;

import com.ydx.movie.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
