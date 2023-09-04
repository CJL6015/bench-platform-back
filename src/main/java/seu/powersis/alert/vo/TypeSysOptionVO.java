package seu.powersis.alert.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-17 23:59
 */
@Data
@Builder
@ToString
@AllArgsConstructor
public class TypeSysOptionVO {
    /**
     * 系统选项
     */
    private List<OptionItemVO> types;
    /**
     * 子系统选项
     */
    private List<OptionItemVO> systems;
}
