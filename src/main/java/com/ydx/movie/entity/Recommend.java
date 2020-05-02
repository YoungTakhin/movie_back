package com.ydx.movie.entity;


import java.io.Serializable;
import java.util.*;

public class Recommend implements Serializable {

    private List<Movie> recommendList;

    public Recommend() {
        this.recommendList = new ArrayList<>();
    }

    public List<Movie> getRecommendList() {
        return recommendList;
    }

    public void setRecommendList(List<Movie> recommendList) {
        this.recommendList = recommendList;
    }

    /**
     * 把电影放到推荐列表里
     * @param movie 电影
     * @param recommendScore 推荐指数
     */
    public void addRecommend(Movie movie, Float recommendScore) {
        movie.setRecommendScore(recommendScore);
        this.recommendList.add(movie);
    }

    public void clearRecommendList() {
        this.recommendList.clear();
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "recommendList=" + recommendList +
                '}';
    }
}
