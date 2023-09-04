package seu.powersis.alert.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 23:02
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ModelInfo {
    /**
     * id
     */
    private Integer id;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 名称
     */
    private String modelName;

    @JsonProperty("steady_point")
    private List<Object> steadyPoint;
    /**
     * 滑动窗参数
     */
    @JsonProperty("moving_windows")
    private MovingWindows movingWindows;

    @JsonProperty("target_parameter")
    private Point targetParameter;

    @JsonProperty("relation_parameter")
    private List<Point> relationParameter;

    @JsonProperty("boundary_parameter")
    private List<Point> boundaryParameter;
}
