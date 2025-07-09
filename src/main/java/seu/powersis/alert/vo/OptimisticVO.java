package seu.powersis.alert.vo;

import lombok.*;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2024-07-16 22:17
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OptimisticVO {
    private String targetName;

    private String boundaryName;

    private String targetValue;

    private String boundaryValue;

    private String historyBest;
}
