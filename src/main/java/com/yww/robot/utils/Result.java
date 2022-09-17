package com.yww.robot.utils;

import lombok.Data;

/**
 * <p>
 *      返回结果封装类
 * </p>
 *
 * @ClassName Result
 * @Author yww
 * @Date 2022/9/17 23:23
 */
@Data
public class Result {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回内容
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 无参构造函数
     */
    private Result() {}

    /**
     * 全参构造函数
     *
     * @param code    状态码
     * @param message 返回内容
     * @param data    返回数据
     */
    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回一个成功的信息
     */
    public static Result success() {
        return new Result(ResultCode.SUCCESS.getStatus(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 返回一个成功的信息
     *
     * @param data    返回数据
     */
    public static Result success(Object data) {
        return new Result(ResultCode.SUCCESS.getStatus(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     *  返回一个错误的信息
     */
    public static Result failure() {
        return new Result(ResultCode.FAILED.getStatus(), ResultCode.FAILED.getMessage(),null);
    }

    /**
     *  返回一个错误的信息
     *  @param message   返回内容
     */
    public static Result failure(String message) {
        return new Result(ResultCode.FAILED.getStatus(), message,null);
    }

    /**
     *  返回一个错误的信息
     *  @param resultCode  状态码
     */
    public static Result failure(ResultCode resultCode) {
        return new Result(resultCode.getStatus(), resultCode.getMessage(),null);
    }

}

