package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName model_condition
 */
@TableName(value ="model_condition")
@Data
public class ModelCondition implements Serializable {
    /**
     * 
     */
    private String algorithm;

    /**
     * 
     */
    private String condition;

    /**
     * 
     */
    private Integer id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}