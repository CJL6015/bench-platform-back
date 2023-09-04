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
 * @TableName benchmark_log
 */
@TableName(value ="benchmark_log")
@Data
public class BenchmarkLog implements Serializable {
    /**
     * 
     */
    private Integer nno;

    /**
     * 
     */
    private Integer modelId;

    /**
     * 
     */
    private String calcLog;

    /**
     * 
     */
    private Date insertTime;

    /**
     * 
     */
    private Integer samplenumber;

    /**
     * 
     */
    private Double timeComsumption;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}