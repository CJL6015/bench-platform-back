package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName system_type_cfg
 */
@TableName(value ="system_type_cfg")
@Data
public class SystemTypeCfg implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer systemTypeId;

    /**
     * 
     */
    private String systemTypeName;

    /**
     * 
     */
    private String systemTypeShortname;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}