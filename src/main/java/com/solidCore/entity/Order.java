package com.solidCore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 订单实体类
 * 对应数据库表：orders
 */
@TableName(value ="orders")
@Data
public class Order implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 接收日期
     */
    @TableField(value = "receive_date")
    private LocalDate receiveDate;

    /**
     * 客户id
     */
    @TableField(value = "customer_id")
    private Integer customerId;

    /**
     * 接收快递号
     */
    @TableField(value = "receive_tracking_number")
    private String receiveTrackingNumber;

    /**
     * 是否为老客户
     */
    @TableField(value = "existing_customer")
    private Boolean existingCustomer;

    /**
     * 经手人
     */
    @TableField(value = "handler")
    private String handler;

    /**
     * 维修单号
     */
    @TableField(value = "repair_order_number")
    private String repairOrderNumber;

    /**
     * 装备类型
     */
    @TableField(value = "equipment_type")
    private String equipmentType;

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
     * 装备编号
     */
    @TableField(value = "equipment_serial_number")
    private String equipmentSerialNumber;

    /**
     * 故障描述
     */
    @TableField(value = "fault_description")
    private String faultDescription;

    /**
     * 表盘颜色
     */
    @TableField(value = "dial_color")
    private String dialColor;

    /**
     * 表盘状态
     */
    @TableField(value = "dial_condition")
    private String dialCondition;

    /**
     * 表带材质
     */
    @TableField(value = "strap_material")
    private String strapMaterial;

    /**
     * 表带颜色
     */
    @TableField(value = "strap_color")
    private String strapColor;

    /**
     * 表带状态
     */
    @TableField(value = "strap_condition")
    private String strapCondition;

    /**
     * 其它详情
     */
    @TableField(value = "other_details")
    private String otherDetails;

    /**
     * 其它跟随物品
     */
    @TableField(value = "accompanying_items")
    private String accompanyingItems;

    /**
     * 操作者
     */
    @TableField(value = "operator")
    private String operator;

    /**
     * 用户自定义编号
     */
    @TableField(value = "other_serial_number")
    private String otherSerialNumber;

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
