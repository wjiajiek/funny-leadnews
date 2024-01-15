package com.funny.behavior.service;

import com.funny.model.behavior.dtos.LikesBehaviorDTO;
import com.funny.model.common.dtos.ResponseResult;

public interface ApLikesBehaviorService {
    /**
     * 点赞或取消点赞
     * @param dto
     * @return
     */
    public ResponseResult like(LikesBehaviorDTO dto);
}
