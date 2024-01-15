package com.funny.behavior.service;

import com.funny.model.behavior.pojos.ApBehaviorEntry;

public interface ApBehaviorEntryService {
     /**
      * 查询行为实体
      * @param userId  用户id
      * @param equipmentId  设备id
      * @return
      */
     ApBehaviorEntry findByUserIdOrEquipmentId(Integer userId, Integer equipmentId);
}