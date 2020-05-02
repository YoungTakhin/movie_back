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
    @PostMapping(value = "{pageNo}/users/{perPage}")
    @ApiOperation(value="获取用户列表", notes="分页查询所有用户")
    public String findAll(@PathVariable("pageNo") int pageNo, @PathVariable("perPage") int perPage) {
        List<User> users = userService.findAll(perPage * (pageNo - 1), perPage);
        return JSON.toJSONString(users);
    }

    /**
     * 查询用户总数
     * @return
     */
    @GetMapping(value = "/users/count")
    @ApiOperation(value = "用户总数", notes = "返回用户总数")
    public int getUserCount() {
        return userService.getUserCount();
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
    @GetMapping(value = "{pageNo}/users/{perPage}/{userName}")
    @ApiOperation(value="根据用户名查询用户", notes="根据用户名模糊查询用户")
    public String findByUserName(@PathVariable("userName") String userName,
                                 @PathVariable("pageNo") int pageNo, @PathVariable("perPage") int perPage) {
        List<User> users = userService.findByUserName(userName, perPage * (pageNo - 1), perPage);
        return JSON.toJSONString(users);
    }

    /**
     * 模糊搜索用户结果数
     * @param userName
     * @return
     */
    @GetMapping(value = "users/search/count")
    @ApiOperation(value = "搜索用户结果数", notes = "返回搜索用户的总数")
    public int findByNameCount(String userName) {
        return userService.findByNameCount(userName);
    }

    /**
     * 用户登录
     * @param loginVo
     * @return
     */
    @PostMapping(value = "/login")
    @ApiOperation(value="用户登录", notes="根据用户id和密码查询用户")
    public String login(@RequestBody LoginVo loginVo) {
        return JSON.toJSONString(userService.login(loginVo.getUserName(), loginVo.getPassword()));
    }

    /**
     * 用户注册
     * @param registerVo
     * @return
     */
    @PostMapping(value = "/register")
    @ApiOperation(value="用户注册", notes="新增用户")
    public String register(@RequestBody RegisterVo registerVo) {
        return JSON.toJSONString(userService.register(registerVo));
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
