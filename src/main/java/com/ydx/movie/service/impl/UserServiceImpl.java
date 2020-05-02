package com.ydx.movie.service.impl;

import com.ydx.movie.controller.vo.RegisterVo;
import com.ydx.movie.entity.User;
import com.ydx.movie.mapper.UserMapper;
import com.ydx.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll(int pageNo, int perPage) {
        return userMapper.findAll(pageNo, perPage);
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public User findById(int userId){
        return userMapper.findById(userId);
    }

    @Override
    public List<User> findByUserName(String userName, int pageNo, int perPage) {
        return userMapper.findByUserName(userName, pageNo, perPage);
    }

    @Override
    public int findByNameCount(String userName) {
        return userMapper.findByNameCount(userName);
    }

    @Override
    public User login(String userName, String password) {
        User user = userMapper.login(userName, password);
        if (user != null) {
            user.setPassword("******");
        }
        return user;
    }

    @Override
    public User register(RegisterVo registerVo) {
        if (userMapper.countByName(registerVo.getUserName()) == 0) {
            if (userMapper.register(registerVo.getUserName(), registerVo.getPassword()) == 1) {
                return this.login(registerVo.getUserName(), registerVo.getPassword());
            }
        }
        return null;
    }

    @Override
    public int resetPassword(int userId, String password) {
        return userMapper.setPassword(userId, password);
    }
}
