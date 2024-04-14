package com.solidCore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 装备信息实体类
 * 对应数据库表：equipment_information
 */
@TableName(value ="equipment_information")
@Data
public class EquipmentInformation implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 装备类别
     */
    @TableField(value = "equipment_category")
    private String equipmentCategory;

    /**
     * 装备品牌
     */
    @TableField(value = "equipment_brand")
    private String equipmentBrand;

    /**
     * 装备型号
     */
    @TableField(value = "equipment_model")
    private String equipmentModel;

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
