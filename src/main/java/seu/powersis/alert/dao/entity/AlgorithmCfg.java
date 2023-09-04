package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName algorithm_cfg
 */
@TableName(value ="algorithm_cfg")
@Data
public class AlgorithmCfg implements Serializable {
    /**
     * 
     */
    private Integer algorithmId;

    /**
     * 
     */
    private String algorithmName;

    /**
     * 
     */
    private String algorithmShortname;

    /**
     * 
     */
    private String path;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}