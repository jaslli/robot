package com.yww.robot.utils;

/**
 * <p>
 *      状态码枚举类
 * </p>
 *
 * @EnumName ResultCode
 * @Author yww
 * @Date 2022/9/17 23:24
 */
public enum ResultCode {

    /**
     * 成功
     */
    SUCCESS(20000, "成功"),

    /**
     * 权限不足
     */
    FORBIDDEN(40300, "权限不足"),

    /**
     * 未登录
     */
    NOT_LOGIN(40301, "用户未登录，请登录后再进行操作"),

    /**
     * 服务器错误
     */
    FAILED(500, "服务器发生错误"),

    /**
     * 用户名或密码错误
     */
    USER_ERROR(50001,"用户名或密码错误,登录失败，请重新登陆");

    private int status;
    private String message;

    ResultCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(int code) {
        this.status = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
