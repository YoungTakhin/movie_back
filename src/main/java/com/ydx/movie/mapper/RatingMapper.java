package com.ydx.movie.mapper;

import com.ydx.movie.entity.Rating;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RatingMapper {

    /**
     * 查询指定用户对指定电影的评分
     * @param userId 用户id
     * @param tmdbId tmdb id
     * @return
     */
    @Select("SELECT * FROM ratings WHERE userId=#{userId} AND tmdbid=#{tmdbId} LIMIT 1")
    public float findByUserIdAndTmdbId(@Param("userId") int userId, @Param("tmdbId") int tmdbId);

    /**
     * 分页查询指定用户的评分列表
     * @param userId 用户id
     * @return
     */
    @Select("SELECT * FROM ratings WHERE userId=#{userId} LIMIT #{pageNo}, #{pageSize}")
    public List<Rating> findByUserId(@Param("pageNo") int pageNo,
                                     @Param("userId") int userId, @Param("pageSize") int pageSize);

    /**
     * 用户添加评分
     * @param userId 用户id
     * @param tmdbId tmdb id
     * @param rating 评分
     * @return 添加记录数
     */
    @Insert("INSERT INTO ratings(userid, tmdbid, rating) VALUES(#{userId}, #{tmdbId}, #{rating})")
    public int addRating(@Param("userId") int userId, @Param("tmdbId") int tmdbId, @Param("rating") float rating);
}
