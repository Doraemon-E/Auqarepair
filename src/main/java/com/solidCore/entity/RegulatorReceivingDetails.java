package com.solidCore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 调压器接收详情实体类
 * 对应数据库表：regulator_receiving_details
 */
@TableName(value ="regulator_receiving_details")
@Data
public class RegulatorReceivingDetails implements Serializable {
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
     * 一级中压值
     */
    @TableField(value = "primary_middle_pressure")
    private BigDecimal primaryMiddlePressure;

    /**
     * 主二吸阻
     */
    @TableField(value = "main_secondary_suction_resistance")
    private String mainSecondarySuctionResistance;

    /**
     * 备二吸阻
     */
    @TableField(value = "backup_secondary_suction_resistance")
    private BigDecimal backupSecondarySuctionResistance;

    /**
     * 残压表比值
     */
    @TableField(value = "residual_pressure_table_ratio")
    private String residualPressureTableRatio;

    /**
     * 气管状况
     */
    @TableField(value = "trachea_condition")
    private String tracheaCondition;

    /**
     * 二级表况
     */
    @TableField(value = "secondary_meter_condition")
    private String secondaryMeterCondition;

    /**
     * 附件表况
     */
    @TableField(value = "attachment_condition")
    private String attachmentCondition;

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
