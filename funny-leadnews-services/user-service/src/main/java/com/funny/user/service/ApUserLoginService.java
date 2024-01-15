package com.funny.user.service;

import com.funny.model.common.dtos.ResponseResult;
import com.funny.model.user.dtos.LoginDTO;

public interface ApUserLoginService {
    /**
     * app端登录
     * @param dto
     * @return
     */
    public ResponseResult login(LoginDTO dto);
}