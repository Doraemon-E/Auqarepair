package com.solidCore.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solidCore.entity.User;
import com.solidCore.mapper.UserMapper;
import com.solidCore.model.dto.LoginUser;
import com.solidCore.utils.GuavaCacheUtils;
import com.solidCore.utils.Result;
import com.solidCore.service.UserService;
import com.solidCore.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Objects;

/**
* @author tongshengchen
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-02-06 12:25:57
*/
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    UserMapper userMapper;

    @Autowired
    GuavaCacheUtils guavaCacheUtils;

    @Override
    public Result login(User user) throws Exception {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();

        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        // 判断authenticate 是否为空，如果为空则认证没有通过
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登陆认证失败");
        }

        // 使用Jwt根据UserId生成Token
        LoginUser loginUser = (LoginUser)authenticate.getPrincipal();
        String username = loginUser.getUsername();
        String jwt = JwtUtils.generateToken(username);
        HashMap<String, String> token = new HashMap<>();
        token.put("token", jwt);

        // 写入Cache
        guavaCacheUtils.put("Login:" + username, loginUser);

        return Result.ok("登陆成功",token);
    }

    @Override
    public Result getUserByUsername(HttpServletRequest httpServletRequest) {
        LoginUser loginUser = (LoginUser) httpServletRequest.getAttribute("LoginUser");
        User user =  loginUser.getUser();
        if (Objects.isNull(user) || StrUtil.isEmpty(user.getUsername()) || StrUtil.isBlank(user.getUsername())) {
            QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
            userQueryWrapper.eq("username", user.getUsername());
            user = userMapper.selectOne(userQueryWrapper);
            if (StrUtil.isEmpty(user.getUsername()) || StrUtil.isBlank(user.getUsername()) ) {
                return Result.error("请求失败");
            }
        }
        return Result.ok("请求成功", user);
    }

    @Override
    public Result logout(HttpServletRequest httpServletRequest) {
        LoginUser loginUser = (LoginUser) httpServletRequest.getAttribute("LoginUser");
        guavaCacheUtils.remove("Login:" + loginUser.getUsername());
        log.info("登出成功");
        return Result.ok("请求成功");
    }
}




