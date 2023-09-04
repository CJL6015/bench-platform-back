package seu.powersis.alert.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-20 11:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovingWindows {
    @JsonProperty("window_length")
    private BigDecimal windowLength;

    @JsonProperty("sampling_interval")
    private BigDecimal samplingInterval;

    @JsonProperty("moving_speed")
    private BigDecimal movingSpeed;
}
