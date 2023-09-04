package seu.powersis.alert.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import seu.powersis.alert.common.enums.ResultCode;

import java.io.Serializable;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-14 22:49
 */
@Data
@AllArgsConstructor
public class Result<T> implements Serializable {
    private int code;
    private String type;
    private String message;
    private T result;

    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultCode.SUCCESS, "ok", data);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(ResultCode.FAIL, message, null);
    }

    public Result(ResultCode code, String message, T result) {
        this.code = code.code;
        this.type = code.type;
        this.message = message;
        this.result = result;
    }

}
