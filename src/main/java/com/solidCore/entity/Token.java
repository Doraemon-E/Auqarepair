package com.solidCore.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author tongsheng
 * @TableName token
 */
@Data
@TableName(value = "token")
public class Token implements Serializable {

    @TableField(value = "username")
    private String username;

    @TableField(value = "token")
    private String token;

    @TableField(value = "expire_time")
    private BigInteger expireTime;

    @TableField(value = "status")
    private String status;
}
