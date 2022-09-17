package com.yww.robot.handler;

import com.yww.robot.utils.GlobalException;
import com.yww.robot.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 *      全局异常处理
 * </p>
 *
 * @ClassName ControllerAdviceHandler
 * @Author yww
 * @Date 2022/9/17 23:26
 */
@RestControllerAdvice
public class ControllerAdviceHandler {

    /**
     * 处理所有异常信息
     * @param e 服务异常
     * @return 异常信息
     */
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception e) {
        return Result.failure(e.getMessage());
    }

    /**
     * 处理通用的服务异常信息
     * @param e 服务异常
     * @return 异常信息
     */
    @ExceptionHandler(value = GlobalException.class)
    public Result errorHandler(GlobalException e) {
        return Result.failure(e.getMessage());
    }

}