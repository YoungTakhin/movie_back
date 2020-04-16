package com.ydx.movie.service;

import com.ydx.movie.entity.Recommend;

public interface RecommendService {

    /**
     * 为用户推荐电影
     * @param userId 用户id
     * @return 电影推荐map
     */
    String recommendForUser(int userId);
    //Recommend recommend(int userId);
}
