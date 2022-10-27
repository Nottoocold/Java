package com.zyc.controller.exception;

import com.zyc.controller.code.StatusCode;
import com.zyc.controller.result.ResultData;
import com.zyc.exception.BusinessException;
import com.zyc.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(SystemException.class)
    public ResultData handleSystemException(SystemException e) {
        //记录日志
        //运维处理
        //技术人员处理
        return new ResultData(null, e.getCode(), e.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public ResultData handleBusinessException(BusinessException e) {


        return new ResultData(null, e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultData handleException(Exception e) {

        return new ResultData(null, StatusCode.UNKNOWN_ERR, "系统繁忙...");
    }
}
