package com.ydx.movie.service.impl;

import java.lang.String;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ydx.movie.entity.Recommend;
import com.ydx.movie.service.MovieService;
import com.ydx.movie.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Recommend recommend;

    @Autowired
    private MovieService movieService;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Recommend recommend() {
        return new Recommend();
    }

    @Override
    public String recommendForUser(int userId) {
        recommend.clearRecommendList();

        String url = "http://127.0.0.1:5000/" + userId + "/recommend/";
        ResponseEntity<String> r = restTemplate.getForEntity(url, String.class);
        JSONObject jsonObject = JSONObject.parseObject(String.valueOf(r.getBody()));

        for (String tId : jsonObject.keySet()) {
            recommend.addRecommend(movieService.findMovieByTmdbid(Integer.parseInt(tId)),
                    jsonObject.getFloat(tId));
        }
        return JSON.toJSONString(recommend);
    }
}
