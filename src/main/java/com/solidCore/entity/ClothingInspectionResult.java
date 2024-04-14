package com.solidCore.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 服装检验结果实体类
 * 对应数据库表：clothing_inspection_results
 */
@TableName(value ="clothing_inspection_results")
@Data
public class ClothingInspectionResult implements Serializable {
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
     * 衣服领口
     */
    @TableField(value = "collar")
    private String collar;

    /**
     * 衣服左袖口
     */
    @TableField(value = "left_sleeve")
    private String leftSleeve;

    /**
     * 衣服右袖口
     */
    @TableField(value = "right_sleeve")
    private String rightSleeve;

    /**
     * 衣服左手
     */
    @TableField(value = "left_hand")
    private String leftHand;

    /**
     * 衣服右手
     */
    @TableField(value = "right_hand")
    private String rightHand;

    // 省略其他字段...

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
