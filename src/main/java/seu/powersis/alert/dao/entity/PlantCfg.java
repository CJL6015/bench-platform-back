package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName plant_cfg
 */
@TableName(value ="plant_cfg")
@Data
public class PlantCfg implements Serializable {
    /**
     * 
     */
    private Integer plantId;

    /**
     * 
     */
    private Integer areaId;

    /**
     * 
     */
    private String plantName;

    /**
     * 
     */
    private String plantShortname;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}