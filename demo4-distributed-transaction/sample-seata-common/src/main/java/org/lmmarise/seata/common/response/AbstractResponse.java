package org.lmmarise.seata.common.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.io.Serializable;

/**
 * @author lmmarise.j@gmail.com
 * @since 2021/10/29 10:02 下午
 */
@Getter
@Setter
public class AbstractResponse implements Serializable {
    private static final long serialVersionUID = 8131236360162671718L;
    private int code;
    private String msg;

    @SneakyThrows
    @Override
    public String toString() {
        return new ObjectMapper().writeValueAsString(this);
    }
}
