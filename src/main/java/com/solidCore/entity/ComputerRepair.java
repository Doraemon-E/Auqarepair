package com.solidCore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 电脑维修实体类
 * 对应数据库表：computer_repair
 */
@TableName(value ="computer_repair")
@Data
public class ComputerRepair implements Serializable {
    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单ID
     */
    @TableField(value = "order_id")
    private Integer orderId;

    /**
     * 表盘状态
     */
    @TableField(value = "dial_condition")
    private String dialCondition;

    /**
     * 存储箱号
     */
    @TableField(value = "storage_box_number")
    private String storageBoxNumber;

    /**
     * 接收日期
     */
    @TableField(value = "receive_date")
    private LocalDate receiveDate;

    /**
     * 故障描述
     */
    @TableField(value = "fault_description")
    private String faultDescription;

    /**
     * 维修方式
     */
    @TableField(value = "repair_method")
    private String repairMethod;

    /**
     * 维修效果
     */
    @TableField(value = "repair_effect")
    private String repairEffect;

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
