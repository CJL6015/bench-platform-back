package seu.powersis.alert.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-16 22:38
 */
@Data
@Builder
@ToString
@AllArgsConstructor
public class SelectAllOptionVO {
    /**
     * 机组选项
     */
    private List<OptionItemVO> units;
    /**
     * 系统选项
     */
    private List<OptionItemVO> types;
    /**
     * 子系统选项
     */
    private List<OptionItemVO> systems;
}
