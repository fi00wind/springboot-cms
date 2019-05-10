package cn.coolwind.manager.core.base;

public enum ResultCode {
    SUCCESS("200", "操作成功"),
    PARAMETER_ERROR("1000", "传入参数错误"),
    INTERFACE_ERROR("2000", "接口异常"),
    SQL_ERROR("3000", "数据库异常"),
    DATA_NOT_EXIST("3001", "数据不存在"),
    LOGIC_ERROR("4000", "逻辑异常"),
    NOT_FILL_CONDITION("4001", "插入条件不满足"),
    OPERATION_NOT_ALLOWED("5000", "操作不允许");

    private final String code;
    private final String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
