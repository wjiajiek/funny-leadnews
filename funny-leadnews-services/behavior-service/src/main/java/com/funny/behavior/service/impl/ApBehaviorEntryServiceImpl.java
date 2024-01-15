package com.funny.behavior.service.impl;

import com.funny.behavior.service.ApBehaviorEntryService;
import com.funny.model.behavior.pojos.ApBehaviorEntry;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class ApBehaviorEntryServiceImpl implements ApBehaviorEntryService {

    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public ApBehaviorEntry findByUserIdOrEquipmentId(Integer userId, Integer equipmentId) {

        //1. 判断userId是否为空
        if(userId != null ){
            Query query = Query.query(Criteria.where("refId").is(userId));
            ApBehaviorEntry entry = mongoTemplate.findOne(query,ApBehaviorEntry.class);
            if(entry == null){
                entry = new ApBehaviorEntry();
                entry.setType((short)1);
                entry.setRefId(userId);
                entry.setCreatedTime(new Date());
                mongoTemplate.save(entry);
                return entry;
            }
            return entry;
        }
        //2. 判断设备id是否为空
        if(equipmentId != null){
            Query query = Query.query(Criteria.where("refId").is(equipmentId));
            ApBehaviorEntry entry = mongoTemplate.findOne(query,ApBehaviorEntry.class);
            if(entry == null){
                entry = new ApBehaviorEntry();
                entry.setType((short)0);
                entry.setRefId(equipmentId);
                entry.setCreatedTime(new Date());
                mongoTemplate.save(entry);
            }
            return entry;
        }
        return null;
    }
}
