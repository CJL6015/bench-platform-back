package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName model_or_rule_cfg
 */
@TableName(value ="model_or_rule_cfg")
@Data
public class ModelOrRuleCfg implements Serializable {
    /**
     * 
     */
    private Integer modelOrRule;

    /**
     * 
     */
    private String modelOrRuleName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}