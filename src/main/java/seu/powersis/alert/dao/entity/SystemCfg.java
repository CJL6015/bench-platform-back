package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName system_cfg
 */
@TableName(value ="system_cfg")
@Data
public class SystemCfg implements Serializable {
    /**
     * 
     */
    private Integer systemId;

    /**
     * 
     */
    private Integer systemTypeId;

    /**
     * 
     */
    private String systemName;

    /**
     * 
     */
    private String systemShortname;

    /**
     * 
     */
    private Integer unitId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}