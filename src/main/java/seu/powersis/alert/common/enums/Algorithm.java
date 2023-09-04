package seu.powersis.alert.common.enums;

import lombok.AllArgsConstructor;

import java.util.Objects;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 14:07
 */
@AllArgsConstructor
public enum Algorithm {
    /**
     * 模型算法枚举
     */
    ERROR(-1),
    PCA(0),
    ANN(1);

    public final Integer code;


    public static Algorithm of(Integer code) {
        for (Algorithm algorithm : values()) {
            if (Objects.equals(algorithm.code, code)) {
                return algorithm;
            }
        }
        return ERROR;
    }
}
