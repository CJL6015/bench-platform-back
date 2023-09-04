package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName alarm_type_cfg
 */
@TableName(value ="alarm_type_cfg")
@Data
public class AlarmTypeCfg implements Serializable {
    /**
     * 
     */
    private Integer unitId;

    /**
     * 
     */
    private Integer alarmTypeId;

    /**
     * 
     */
    private String alarmName;

    /**
     * 
     */
    private String alarmThershold;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}