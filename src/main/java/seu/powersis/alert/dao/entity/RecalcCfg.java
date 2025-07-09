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
 * @TableName recalc_cfg
 */
@TableName(value ="recalc_cfg")
@Data
public class RecalcCfg implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer nno;

    /**
     * 
     */
    private Integer modelId;

    /**
     * 
     */
    private Date starttime;

    /**
     * 
     */
    private Date endtime;

    /**
     * 
     */
    private Integer visible;

    /**
     * 
     */
    private Double process;

    /**
     * 
     */
    private Date inserttime;

    /**
     * 
     */
    private Integer samplenumber;

    /**
     * 
     */
    private Double computetime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}