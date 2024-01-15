package com.funny.common.exception;

import com.funny.model.common.enums.AppHttpCodeEnum;

public class CustomException extends RuntimeException {

    // 异常处理的枚举
    private AppHttpCodeEnum appHttpCodeEnum;

    public CustomException(AppHttpCodeEnum appHttpCodeEnum) {
        this.appHttpCodeEnum = appHttpCodeEnum;
    }
    public CustomException(AppHttpCodeEnum appHttpCodeEnum,String msg) {
        appHttpCodeEnum.setErrorMessage(msg);
        this.appHttpCodeEnum = appHttpCodeEnum;
    }
    public AppHttpCodeEnum getAppHttpCodeEnum() {
        return appHttpCodeEnum;
    }
}