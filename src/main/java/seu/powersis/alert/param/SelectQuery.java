package seu.powersis.alert.param;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-17 23:48
 */
@Data
public class SelectQuery {
    @NotNull
    private Integer unitId;
    @NonNull
    private Integer typeId;
}
