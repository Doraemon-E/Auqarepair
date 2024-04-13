package com.solidCore.controller;

import com.solidCore.entity.User;
import com.solidCore.service.UserService;
import com.solidCore.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation("用户登陆")
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        try {
            return userService.login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error("登陆失败");
    }

    @ApiOperation("注销登陆")
    @GetMapping("/logout")
    public Result logout(HttpServletRequest httpServletRequest){
        try {
            return userService.logout(httpServletRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.error("请求失败");
    }

}
