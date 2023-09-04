package seu.powersis.alert.common.enums;

import lombok.AllArgsConstructor;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 13:48
 */
@AllArgsConstructor
public enum ModelStatus {
    /**
     * 模型状态
     */
    TRAINING(0, "训练中"),
    FINISH(1, "已下装");


    public final Integer code;

    public final String desc;
}
