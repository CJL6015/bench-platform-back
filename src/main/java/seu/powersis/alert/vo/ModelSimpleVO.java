package seu.powersis.alert.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 13:08
 */
@Data
@Builder
@ToString
@AllArgsConstructor
public class ModelSimpleVO {
    /**
     * 模型id
     */
    private Integer id;
    /**
     * 模型名称
     */
    private String name;
    /**
     * 算法名称
     */
    private String algorithm;
    /**
     * 创建人
     */
    private String creatName;

    /**
     * 模型状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date creatTime;
}
