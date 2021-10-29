package org.lmmarise.seata.common.constants;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:02 下午
 */
public enum ResponseCode {
    SUCCESS(200,"成功"),
    SYSTEM_EXCEPTION(500,"系统异常"),
    FAILED(999, "系统错误");

    private int code;
    private String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
