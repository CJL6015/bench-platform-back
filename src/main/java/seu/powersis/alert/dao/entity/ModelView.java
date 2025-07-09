package seu.powersis.alert.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName MODEL_VIEW
 */
@TableName(value ="MODEL_VIEW")
@Data
public class ModelView implements Serializable {
    /**
     * 
     */
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
    private Integer systemTypeId;

    /**
     * 
     */
    private String systemShortname;

    /**
     * 
     */
    private String systemName;

    /**
     * 
     */
    private Integer unitId;

    /**
     * 
     */
    private String systemTypeName;

    /**
     * 
     */
    private String systemTypeShortname;

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
    private String areaName;

    /**
     * 
     */
    private String areaShortname;

    /**
     * 
     */
    private String plantName;

    /**
     * 
     */
    private String plantShortname;

    /**
     * 
     */
    private Integer areaId;

    /**
     * 
     */
    private Integer instantNum;

    /**
     * 
     */
    private Integer visible;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}