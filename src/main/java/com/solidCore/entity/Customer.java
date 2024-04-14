package com.solidCore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 客户实体类
 * 对应数据库表：customer
 */
@TableName(value ="customer")
@Data
public class Customer implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户类别
     */
    @TableField(value = "customer_category")
    private String customerCategory;

    /**
     * 客户姓名
     */
    @TableField(value = "customer_name")
    private String customerName;

    /**
     * 客户电话
     */
    @TableField(value = "customer_phone")
    private String customerPhone;

    /**
     * 客户地址
     */
    @TableField(value = "customer_address")
    private String customerAddress;

    /**
     * 客户微信/QQ
     */
    @TableField(value = "customer_contact_info")
    private String customerContactInfo;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDate createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDate updateTime;

    /**
     * 删除标志
     */
    @TableField(value = "is_delete")
    private boolean isDelete;

    /**
     * 序列化版本号
     */
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
