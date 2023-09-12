package seu.powersis.alert.vo;

import lombok.*;

import java.util.List;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-09-05 22:50
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ModelDataVO {
    /**
     * 目标数值
     */
    private List<Double> targetValue;
    /**
     * 参数个数
     */
    private int[] sampleValue;
    /**
     * 边界数据
     */
    private List<List<Double>> dataList;

    /**
     * 热力图数据
     */
    private List<int[]> heatData;
}
