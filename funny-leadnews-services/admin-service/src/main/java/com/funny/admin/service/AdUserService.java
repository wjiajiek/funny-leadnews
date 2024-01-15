package com.funny.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.funny.model.admin.dtos.AdUserDTO;
import com.funny.model.admin.pojos.AdUser;
import com.funny.model.common.dtos.ResponseResult;

public interface AdUserService extends IService<AdUser> {

    /**
     * 登录功能
     * @param DTO
     * @return
     */
    ResponseResult login(AdUserDTO DTO);
}
