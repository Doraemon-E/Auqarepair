package com.solidCore.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.solidCore.entity.User;
import com.solidCore.utils.Result;

import javax.servlet.http.HttpServletRequest;

/**
* @author tongshengchen
* @description 针对表【user】的数据库操作Service
* @createDate 2023-02-06 12:25:57
*/
public interface UserService extends IService<User> {

    /**
     * 用户登陆
     * @param user
     * @return
     * @throws Exception
     */
    Result login(User user) throws Exception;

    /**
     * 通过用户Id获取用户信息
     * @param httpServletRequest
     * @return
     * @throws Exception
     */
    Result getUserByUsername(HttpServletRequest httpServletRequest) throws Exception;

    /**
     * 注销登陆
     * @param httpServletRequest
     * @return
     */
    Result logout(HttpServletRequest httpServletRequest);

}
