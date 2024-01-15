package com.funny.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.funny.model.common.dtos.ResponseResult;
import com.funny.model.wemedia.dtos.WmUserDTO;
import com.funny.model.wemedia.pojos.WmUser;

public interface WmUserService extends IService<WmUser> {
    /**
     * 登录
     * @param dto
     * @return
     */
    public ResponseResult login(WmUserDTO dto);
}
