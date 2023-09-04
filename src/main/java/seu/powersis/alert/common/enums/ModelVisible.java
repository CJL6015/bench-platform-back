package seu.powersis.alert.common.enums;

import lombok.AllArgsConstructor;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 14:00
 */
@AllArgsConstructor
public enum ModelVisible {
    /**
     * 模型可见状态
     */
    VISIBLE(1),
    INVISIBLE(0),
    ;
    public final Integer code;
}
