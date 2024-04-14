package com.solidCore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 电脑维修图片实体类
 * 对应数据库表：computer_repair_images
 */
@TableName(value ="computer_repair_images")
@Data
public class ComputerRepairImage implements Serializable {
    /**
     * 图片ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 报告ID
     */
    @TableField(value = "form_id")
    private Integer formId;

    /**
     * 图片名称
     */
    @TableField(value = "image_name")
    private String imageName;

    /**
     * 图片URL
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDate createTime;

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
