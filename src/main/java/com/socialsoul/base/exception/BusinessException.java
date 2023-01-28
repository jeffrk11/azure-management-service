package com.socialsoul.base.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 3619566296497839843L;

    private String specificMessage;
    private Object data;
    private HttpStatus status;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, HttpStatus status) {
        this.specificMessage = message;
        this.status = status;
    }

    public String getSpecificMessage() {
        return specificMessage;
    }

    public void setSpecificMessage(String specificMessage) {
        this.specificMessage = specificMessage;
    }

    public BusinessException(HttpStatus status) {
        this.status = status;
    }

    public BusinessException(Throwable e) {
        super(e);
    }

    public BusinessException(String message, Throwable e) {
        super(message, e);
    }

    public BusinessException(Object data) {
        this.data = data;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
