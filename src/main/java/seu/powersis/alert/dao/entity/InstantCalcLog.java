package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName instant_calc_log
 */
@TableName(value ="instant_calc_log")
@Data
public class InstantCalcLog implements Serializable {
    /**
     * 
     */
    private Integer 模型实例计算数量;

    /**
     * 
     */
    private String 运行状态;

    /**
     * 
     */
    private Date 日志插入时间;

    /**
     * 
     */
    private Double 读取配置耗时;

    /**
     * 
     */
    private Double json解析1耗时;

    /**
     * 
     */
    private Double 读exa耗时;

    /**
     * 
     */
    private Double 调python模型计算;

    /**
     * 
     */
    private Double 写exa耗时;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}