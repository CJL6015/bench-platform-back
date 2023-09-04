package seu.powersis.alert.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 22:48
 */
@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 目标点号
     */
    @JsonProperty("target_point")
    private String targetPoint;

    /**
     * 描述
     */
    private String description;

    /**
     * 单位
     */
    private String unit;

    /**
     * 类型
     */
    private String marktype;

    /**
     * 上限
     */
    private BigDecimal upperlimit;

    /**
     * 下限
     */
    private BigDecimal lowerlimit;

    /**
     * 网格数
     */
    private Integer gridNumber;
}
