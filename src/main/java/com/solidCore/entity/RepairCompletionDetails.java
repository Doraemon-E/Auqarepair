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
 * 维修完成详情实体类
 * 对应数据库表：repair_completion_details
 */
@TableName(value ="repair_completion_details")
@Data
public class RepairCompletionDetails implements Serializable {
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
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 图片URL
     */
    @TableField(value = "image_url")
    private String imageUrl;

    /**
     * 一级头中压参数
     */
    @TableField(value = "primary_head_middle_pressure_1")
    private BigDecimal primaryHeadMiddlePressure1;

    /**
     * 主二级吸阻参数
     */
    @TableField(value = "primary_secondary_suction_resistance_1")
    private BigDecimal primarySecondarySuctionResistance1;

    /**
     * 备二级吸阻参数
     */
    @TableField(value = "secondary_secondary_suction_resistance_1")
    private BigDecimal secondarySecondarySuctionResistance1;

    /**
     * 残压表比对值
     */
    @TableField(value = "residual_pressure_table_comparison_value_1")
    private String residualPressureTableComparisonValue1;

    /**
     * 胶管状态
     */
    @TableField(value = "hose_status_1")
    private String hoseStatus1;

    /**
     * 一二级表况
     */
    @TableField(value = "primary_secondary_condition_1")
    private String primarySecondaryCondition1;

    /**
     * 其他物品表况
     */
    @TableField(value = "other_items_condition_1")
    private String otherItemsCondition1;

    /**
     * 检测日期
     */
    @TableField(value = "inspection_date_1")
    private LocalDate inspectionDate1;

    // 省略了2和3的字段，你可以依此类推添加

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
