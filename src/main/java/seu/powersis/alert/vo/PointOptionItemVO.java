package seu.powersis.alert.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-20 20:55
 */
@Data
@Builder
@ToString
@AllArgsConstructor
public class PointOptionItemVO {
    private String id;

    private String name;
}
