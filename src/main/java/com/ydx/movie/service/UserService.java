package com.ydx.movie.service;

import com.ydx.movie.controller.vo.RegisterVo;
import com.ydx.movie.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 分页查询所有用户
     * @return
     */
    List<User> findAll(int pageNo, int perPage);

    /**
     * 查询用户总数
     * @return
     */
    int getUserCount();

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
     * 查询根据id查询的用户结果数
     * @param userName
     * @return
     */
    int findByNameCount(String userName);

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    User login(String userName, String password);

    /**
     * 注册
     * @param registerVo
     * @return
     */
    User register(RegisterVo registerVo);

    /**
     * 修改密码
     * @param userId
     * @param password
     * @return
     */
    int resetPassword(int userId, String password);
}
