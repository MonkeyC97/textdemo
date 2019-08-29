package com.monkeyc.blog.exception;

import lombok.Data;

@Data
public class BussinessException extends RuntimeException {
    private String code;
    public BussinessException(String message) {
        super("业务异常"+message);
        this.code="401";
    }

    public BussinessException(String message, Throwable cause) {
        super("业务异常"+message, cause);
        this.code="401";
    }
}
