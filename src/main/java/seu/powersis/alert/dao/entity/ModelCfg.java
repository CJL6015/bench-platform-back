package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author 陈小黑
 * @TableName model_cfg
 */
@TableName(value ="model_cfg")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModelCfg implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer modelId;

    /**
     * 
     */
    private Integer systemId;

    /**
     * 
     */
    private Integer algorithmId;

    /**
     * 
     */
    private String modelName;

    /**
     * 
     */
    private Date creatTime;

    /**
     * 
     */
    private String creatName;

    /**
     * 
     */
    private String modelInfo;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    private Integer visible;

    /**
     * 
     */
    private String condition;

    /**
     * 
     */
    private Integer trash;

    /**
     *
     */
    private String marktype;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}