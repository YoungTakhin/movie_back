package com.ydx.movie.service.impl;

import com.ydx.movie.entity.User;
import com.ydx.movie.mapper.UserMapper;
import com.ydx.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
    public User findById(int userId){
        return userMapper.findById(userId);
    }

    @Override
    public List<User> findByUserName(String userName, int pageNo, int perPage) {
        return userMapper.findByUserName(userName, pageNo, perPage);
    }

    @Override
    public User login(int userId, String password) {
        User user = userMapper.login(userId, password);
        try {
            if (user == null) {
                return null;
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
        return user;
    }

    @Override
    public User register(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        if (userMapper.addUser(user) != 1) {
            return null;
        }
        return user;
    }

    @Override
    public int resetPassword(int userId, String password) {
        return userMapper.setPassword(userId, password);
    }
}
