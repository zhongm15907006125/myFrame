package com.yscoco.myframe.dto;

/**
 * @author：ZhongM on 2019/6/15 16:15
 */
public class BaseDTO<T> {
    String errorMsg;
    int errorCode;
    T data;

    public BaseDTO(String errorMsg, int errorCode) {
        this.errorMsg = errorMsg;
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return errorMsg;
    }

    public void setMsg(String msg) {
        this.errorMsg = msg;
    }

    public int getCode() {
        return errorCode;
    }

    public void setCode(int code) {
        this.errorCode = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
