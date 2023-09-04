package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 陈小黑
 * @TableName alarm_level_cfg
 */
@TableName(value = "alarm_level_cfg")
@Data
public class AlarmLevelCfg implements Serializable {
    /**
     *
     */
    private Integer alarmLevel;

    /**
     *
     */
    private String alarmLevelName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}