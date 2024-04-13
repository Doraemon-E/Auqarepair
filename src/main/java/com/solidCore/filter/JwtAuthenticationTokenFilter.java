package com.solidCore.filter;

import com.solidCore.model.dto.LoginUser;
import com.solidCore.utils.GuavaCacheUtils;
import com.solidCore.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @projectName: AquaRepair
 * @package: com.solidCore.filter
 * @className: JwtAuthenticationTokenFilter
 * @author: tongsheng
 * @description: TODO
 * @date: 2024/4/13 21:01
 * @version: 1.0
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {


    @Autowired
    GuavaCacheUtils guavaCacheUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        // 获取token
        String authorization = httpServletRequest.getHeader("Authorization");
        if (!JwtUtils.judgeTokenIsExist(authorization)){
            // 放行去登陆
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        // 解析token
        Claims tokenBody = JwtUtils.getTokenBody(authorization);
        String username = tokenBody.getSubject();
        // 从Cache中获取用户信息
        LoginUser loginUser = (LoginUser) guavaCacheUtils.get("Login:" + username);
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("token非法");
        }
        HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(httpServletRequest);
        httpServletRequestWrapper.setAttribute("LoginUser",loginUser);

        filterChain.doFilter(httpServletRequestWrapper, httpServletResponse);
    }
}
