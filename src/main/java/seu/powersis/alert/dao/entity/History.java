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
 * @TableName history
 */
@TableName(value ="history")
@Data
public class History implements Serializable {
    /**
     * 
     */
    private Date time;

    /**
     * 
     */
    private Double p1;

    /**
     * 
     */
    private Double p2;

    /**
     * 
     */
    private Double p3;

    /**
     * 
     */
    private Double p4;

    /**
     * 
     */
    private Double p5;

    /**
     * 
     */
    private Double p6;

    /**
     * 
     */
    private Double p7;

    /**
     * 
     */
    private Double p8;

    /**
     * 
     */
    private Double p9;

    /**
     * 
     */
    private Double p10;

    /**
     * 
     */
    private Double p11;

    /**
     * 
     */
    private Double p12;

    /**
     * 
     */
    private Double p13;

    /**
     * 
     */
    private Double p14;

    /**
     * 
     */
    private Double p15;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}