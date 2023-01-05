package com.yww.robot.common;

import lombok.Getter;

import java.io.Serial;

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
public class GlobalException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -1574716826948451793L;

    /**
     * 错误码
     */
    private final Integer code;

    /**
     * 错误信息
     */
    private final String message;

    public GlobalException(String message) {
        this.code = 500;
        this.message = message;
    }

    public GlobalException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
