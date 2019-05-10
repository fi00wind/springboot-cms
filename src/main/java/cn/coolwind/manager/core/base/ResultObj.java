package cn.coolwind.manager.core.base;

import java.io.Serializable;

public class ResultObj<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    public ResultObj() {
    }

    public ResultObj(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultObj(String code, String msg) {
        this(code,msg,null);
    }

    public ResultObj(T data) {
        this(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
    }

    public ResultObj(String msg, T data) {
        this(ResultCode.SUCCESS.getCode(),msg,data);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
