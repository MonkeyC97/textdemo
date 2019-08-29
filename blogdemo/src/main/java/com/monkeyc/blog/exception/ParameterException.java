package com.monkeyc.blog.exception;

/**
 * 自定义异常
 */

public class ParameterException extends RuntimeException{

    private String code;


    public ParameterException() {
    }

    public ParameterException(String message) {
        super("客户端异常"+message);
        code="400";
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterException(Throwable cause) {
        super(cause);
    }

    public ParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
