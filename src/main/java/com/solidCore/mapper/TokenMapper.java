package com.solidCore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solidCore.entity.Token;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TokenMapper extends BaseMapper<Token> {
}
