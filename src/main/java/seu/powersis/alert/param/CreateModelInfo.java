package seu.powersis.alert.param;

import lombok.Data;
import seu.powersis.alert.vo.ModelInfoVO;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-20 22:57
 */
@Data
public class CreateModelInfo {
    private Integer systemId;
    private ModelInfoVO modelInfo;
}
