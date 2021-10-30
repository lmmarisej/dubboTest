package org.lmmarise.seata.common.response;

import lombok.Getter;
import lombok.Setter;
import org.lmmarise.seata.common.constants.ResponseCode;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:04 下午
 */
@Getter
@Setter
public class ObjectResponse<T> extends AbstractResponse {
    private Object data;

    public ObjectResponse() {
    }

    public ObjectResponse(ResponseCode responseCode) {
        this(responseCode.getCode(), responseCode.getMessage(), null);
    }

    public ObjectResponse(int code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.data = data;
    }

    public  ObjectResponse<T> setResponseCode(ResponseCode responseCode) {
        this.setCode(responseCode.getCode());
        this.setMsg(responseCode.getMessage());
        return this;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
