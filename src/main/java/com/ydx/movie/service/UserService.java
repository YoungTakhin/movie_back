package com.ydx.movie.service;

import com.ydx.movie.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 分页查询所有用户
     * @return
     */
    List<User> findAll(int pageNo, int perPage);

    /**
     * 根据id查询用户
     * @return
     */
    User findById(int userId);

    /**
     * 根据用户名模糊查询用户
     * @param userName
     * @return
     */
    List<User> findByUserName(String userName, int pageNo, int perPage);

    /**
     * 登录
     * @param userId
     * @param password
     * @return
     */
    User login(int userId, String password);

    /**
     * 注册
     * @param userName
     * @param password
     * @return
     */
    User register(String userName, String password);

    /**
     * 修改密码
     * @param userId
     * @param password
     * @return
     */
    int resetPassword(int userId, String password);
}
