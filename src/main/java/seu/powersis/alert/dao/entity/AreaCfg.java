package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName area_cfg
 */
@TableName(value ="area_cfg")
@Data
public class AreaCfg implements Serializable {
    /**
     * 
     */
    private Integer areaId;

    /**
     * 
     */
    private String areaName;

    /**
     * 
     */
    private String areaShortname;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}