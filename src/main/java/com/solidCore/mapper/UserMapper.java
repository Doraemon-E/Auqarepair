package com.solidCore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solidCore.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * @return 返回账户信息
     */
    String queryByUserName(String username);
}
