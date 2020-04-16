package com.ydx.movie.controller;

import com.alibaba.fastjson.JSON;
import com.ydx.movie.controller.vo.LoginVo;
import com.ydx.movie.controller.vo.PasswordVo;
import com.ydx.movie.controller.vo.RegisterVo;
import com.ydx.movie.entity.User;
import com.ydx.movie.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags="用户模块")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 分页查询所有用户
     * @return
     */
    @PostMapping(value = "{pageNo}/user")
    @ApiOperation(value="获取用户列表", notes="分页查询所有用户")
    public String findAll(@PathVariable("pageNo") int pageNo) {
        List<User> users = userService.findAll(pageNo);
        return JSON.toJSONString(users);
    }

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @GetMapping(value = "/user/{userId}")
    @ApiOperation(value="根据id查询用户", notes="根据id查询用户")
    public String findById(@PathVariable("userId") int userId) {
        User user = userService.findById(userId);
        return JSON.toJSONString(user);
    }

    /**
     * 根据用户名模糊查询用户
     * @param userName
     * @return
     */
    @PostMapping(value = "{pageNo}/user/{userName}")
    @ApiOperation(value="根据用户名查询用户", notes="根据用户名模糊查询用户")
    public String findByUserName(@PathVariable String userName, @PathVariable int pageNo) {
        List<User> users = userService.findByUserName(userName, pageNo);
        return JSON.toJSONString(users);
    }

    /**
     * 用户登录
     * @param loginVo
     * @return
     */
    @PostMapping(value = "/login")
    @ApiOperation(value="用户登录", notes="根据用户id和密码查询用户")
    public String login(@RequestBody LoginVo loginVo) {
        User user = userService.login(loginVo.getUserId(), loginVo.getPassword());
        if (user == null) {
            return null;
        }
        return JSON.toJSONString(user);
    }

    /**
     * 用户注册
     * @param registerVo
     * @return
     */
    @PostMapping(value = "/register")
    @ApiOperation(value="用户注册", notes="新增用户")
    public String register(@RequestBody RegisterVo registerVo) {
        User user = userService.register(registerVo.getUserName(), registerVo.getPassword());
        return JSON.toJSONString(user);
    }

    /**
     * 修改密码
     * @param passwordVo
     * @return
     */
    @PostMapping(value = "/user/password")
    @ApiOperation(value="修改密码", notes="修改用户密码")
    public int resetPassword(@RequestBody PasswordVo passwordVo) {
        return userService.resetPassword(passwordVo.getUserId(), passwordVo.getPassword());
    }
}
