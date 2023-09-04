package seu.powersis.alert.param;

import lombok.Data;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 13:25
 */
@Data
public class ModelSelectQuery {
    /**
     * 机组id
     */
    private Integer unitId;
    /**
     * 系统id
     */
    private Integer typeId;
    /**
     * 子系统id
     */
    private Integer systemId;

    /**
     * 名称
     */
    private String name;

    /**
     * @see seu.powersis.alert.common.enums.ModelStatus
     * 模型状态
     */
    private Integer status;

    /**
     * @see seu.powersis.alert.common.enums.ModelTrash
     * 可见状态
     */
    private Integer visible;

    /**
     * @see seu.powersis.alert.common.enums.ModelTrash
     * 删除状态
     */
    private Integer trash;
}
