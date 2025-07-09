package seu.powersis.alert.param;

import lombok.Data;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2024-07-16 23:05
 */
@Data
public class OptimisticQuery {
    private Integer id;

    private String search;
    private String st;
    private String et;
}
