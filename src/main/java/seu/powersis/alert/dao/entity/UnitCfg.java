package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName unit_cfg
 */
@TableName(value = "unit_cfg")
@Data
public class UnitCfg implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer unitId;
    /**
     *
     */
    private Integer plantId;
    /**
     *
     */
    private String unitName;
    /**
     *
     */
    private String unitShortname;
    /**
     *
     */
    private String 预警标准训练样本;
    /**
     *
     */
    private String loadpoint;
    /**
     *
     */
    private String temppoint;
    /**
     * exa数据组
     */
    private String exaGroup;
}