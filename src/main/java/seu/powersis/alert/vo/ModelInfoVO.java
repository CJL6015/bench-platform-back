package seu.powersis.alert.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 22:41
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ModelInfoVO {
    /**
     * id
     */
    private Integer id;
    /**
     * 创建人
     */
    private String createName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 运行条件
     */
    private String condition;

    /**
     * 名称
     */
    private String modelName;

    private List<Object> steadyPoint;
    /**
     * 滑动窗参数
     */
    private MovingWindows movingWindows;

    private PointVO targetParameter;

    private List<PointVO> relationParameter;

    private List<PointVO> boundaryParameter;


    @Data
    public static class MovingWindows {
        private Integer windowLength;

        private Integer samplingInterval;

        private Integer movingSpeed;
    }
}
