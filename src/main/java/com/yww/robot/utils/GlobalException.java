package com.yww.robot.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.yww.robot.utils.ResultCode.FAILED;

/**
 * <p>
 *      全局异常类
 * </p>
 *
 * @ClassName GlobalException
 * @Author yww
 * @Date 2022/9/17 23:23
 */
@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer code = FAILED.getStatus();

    /**
     * 错误信息
     */
    private final String message;

    public GlobalException(String message) {
        this.message = message;
    }

    public GlobalException(ResultCode resultCode) {
        this.code = resultCode.getStatus();
        this.message = resultCode.getMessage();
    }

}
