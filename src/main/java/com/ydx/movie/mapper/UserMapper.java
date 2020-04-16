package com.ydx.movie.mapper;

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
    @Select("SELECT * FROM users LIMIT #{pageNo}, 50")
    List<User> findAll(@Param("pageNo") int pageNo);

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
    @Select("SELECT * FROM users WHERE username LIKE '%${value}%' LIMIT #{pageNo}, 50")
    List<User> findByUserName(@Param("value") String userName, @Param("pageNo") int pageNo);

    /**
     * 用户登录
     * @param userId
     * @param password
     * @return
     */
    @Select("SELECT * FROM users WHERE userid=#{userId} AND password=#{password}")
    User login(@Param("userId") int userId, @Param("password") String password);

    /**
     * 添加用户
     * @return
     */

    @Insert("INSERT INTO users(username, password, admin) VALUES(#{user.userName}, #{user.password}, 0)")
    @SelectKey(statement = "SELECT max(userid) from users",
            keyProperty = "user.userId",
            before = false,
            resultType = int.class)
    // @Options(useGeneratedKeys = true, keyProperty = "user.userId", keyColumn = "userid")
    int addUser(@Param("user") User user);

    /**
     * 修改密码
     * @return
     */
    @Update("UPDATE users SET passwrod=#{password} WHERE userid=#{userId} LIMIT 1")
    int setPassword(@Param("userId") int userId, @Param("password") String password);

}