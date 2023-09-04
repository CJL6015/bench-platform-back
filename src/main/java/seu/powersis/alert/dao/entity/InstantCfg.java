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
 * @TableName instant_cfg
 */
@TableName(value ="instant_cfg")
@Data
public class InstantCfg implements Serializable {
    /**
     * 
     */
    private Integer mpId;

    /**
     * 
     */
    private Integer modelId;

    /**
     * 
     */
    private String mpName;

    /**
     * 
     */
    private String instantInfo;

    /**
     * 
     */
    private Integer interval;

    /**
     * 
     */
    private Integer hisSto;

    /**
     * 
     */
    private Integer visible;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Date setupTime;

    /**
     * 
     */
    private String newestUpdateTime;

    /**
     * 是否运行正常
     */
    private String running;

    /**
     * 运行日志
     */
    private String runningLog;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}