package com.funny.user.service;

import com.funny.model.common.dtos.ResponseResult;
import com.funny.model.user.dtos.UserRelationDTO;

public interface ApUserRelationService {
    /**
     * 用户关注/取消关注
     * @param dto
     * @return
     */
    public ResponseResult follow(UserRelationDTO dto);
}