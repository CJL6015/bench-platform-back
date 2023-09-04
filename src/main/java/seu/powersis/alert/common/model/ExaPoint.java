package seu.powersis.alert.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-20 20:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExaPoint {
    /**
     * 点号
     */
    @JsonProperty("ItemName")
    private String itemName;
    /**
     *
     */
    @JsonProperty("SerialNumber")
    private int serialNumber;
    /**
     * 组名
     */
    @JsonProperty("GroupName")
    private String groupName;
    /**
     * 类型
     */
    @JsonProperty("ItemType")
    private int itemType;
    /**
     * 描述
     */
    @JsonProperty("Descriptor")
    private String descriptor;
    /**
     * 单位
     */
    @JsonProperty("EngUnits")
    private String engUnits;
    /**
     * 上限
     */
    @JsonProperty("UpperLimit")
    private Double upperLimit;
    /**
     * 下限
     */
    @JsonProperty("LowerLimit")
    private Double lowerLimit;
    /**
     * 上边界
     */
    @JsonProperty("LowerBound")
    private Double lowerBound;
    /**
     * 下变价
     */
    @JsonProperty("UpperBound")
    private Double upperBound;
}
