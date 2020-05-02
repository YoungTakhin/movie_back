package com.ydx.movie.mapper;

import com.ydx.movie.controller.vo.RegisterVo;
import com.ydx.movie.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("SELECT * FROM users LIMIT #{pageNo}, #{perPage}")
    List<User> findAll(@Param("pageNo") int pageNo, @Param("perPage") int perPage);

    /**
     * 查询用户总数
     * @return
     */
    @Select("SELECT COUNT(*) FROM users LIMIT 1")
    int getUserCount();

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("SELECT * FROM users WHERE userid=#{userId} LIMIT 1")
    User findById(@Param("userId") int userId);

    /**
     * 根据用户名分页模糊查询用户
     * @param userName
     * @param pageNo
     * @return
     */
    @Select("SELECT * FROM users WHERE username LIKE '%${value}%' LIMIT #{pageNo}, #{perPage}")
    List<User> findByUserName(@Param("value") String userName,
                              @Param("pageNo") int pageNo, @Param("perPage") int perPage);

    /**
     * 根据用户名查询的用户结果数
     * @param userName
     * @return
     */
    @Select("SELECT COUNT(*) FROM users WHERE username LIKE '%${value}%' LIMIT 1")
    int findByNameCount(@Param("value") String userName);

    /**
     * 根据用户名查询精确查找用户数
     * @param userName
     * @return
     */
    @Select("SELECT COUNT(*) FROM users WHERE username = #{userName} LIMIT 1")
    int countByName(@Param("userName") String userName);

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @Select("SELECT * FROM users WHERE username=#{userName} AND password=#{password}")
    User login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 添加用户
     * @return
     */
    @Insert("INSERT INTO users(username, password, admin) VALUES(#{userName}, #{password}, 0)")
    int register(@Param("userName") String userName, @Param("password") String password);

    /**
     * 修改密码
     * @return
     */
    @Update("UPDATE users SET password=#{password} WHERE userid=#{userId} LIMIT 1")
    int setPassword(@Param("userId") int userId, @Param("password") String password);

}
