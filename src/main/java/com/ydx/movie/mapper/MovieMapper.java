package com.ydx.movie.mapper;

import com.ydx.movie.entity.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovieMapper {

    /**
     * 分页查询电影列表
     * @param pageNo 页码
     * @param pageSize 每页大小
     * @return
     */
    @Select("SELECT * FROM movies ORDER BY date DESC LIMIT #{pageNo}, #{pageSize}")
    List<Movie> getMovies(@Param("pageNo") int pageNo, @Param("pageSize") int pageSize);

    /**
     * 根据tmdb id查询电影
     * @param tmdbid tmdb id
     * @return
     */
    @Select("SELECT * FROM movies WHERE tmdbid=#{tmdbid}")
    Movie findMoviesByTmdbid(@Param("tmdbid") int tmdbid);

    /**
     * 查询总电影数
     * @return
     */
    // @Select("select NUM_ROWS from information_schema.INNODB_SYS_TABLESTATS where name='movie/movies'")
    @Select("SELECT COUNT(*) FROM movies")
    int numOfMovies();

    /**
     * 通过电影名模糊查询
     * @param movieName
     * @return
     */
    @Select("SELECT * FROM movies WHERE title LIKE '%${value}%' ORDER BY date DESC LIMIT #{pageNo}, #{pageSize}")
    List<Movie> findMoviesByName(@Param("value") String movieName,
                                 @Param("pageNo") int pageNo, @Param("pageSize") int pageSize);
    /**
     * 查询搜索电影总数
     * @param movieName
     * @return
     */
    @Select("SELECT COUNT(*) FROM movies WHERE title LIKE '%${value}%'")
    int countOfSearch(@Param("value") String movieName);


}
