package seu.powersis.alert.common.enums;

import lombok.AllArgsConstructor;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 13:53
 */
@AllArgsConstructor
public enum ModelTrash {
    /**
     * 删除状态
     */
    NORMAL(0, "正常"),
    TRASH(1, "已删除"),
    ;
    public final Integer code;

    public final String desc;
}
