package com.funny.behavior;
import java.util.Date;

import com.funny.behavior.service.ApBehaviorEntryService;
import com.funny.model.behavior.pojos.ApBehaviorEntry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
public class TestBehavior {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void test1(){
        ApBehaviorEntry apBehaviorEntry = new ApBehaviorEntry();
        apBehaviorEntry.setType((short)0);
        apBehaviorEntry.setRefId(0);
        apBehaviorEntry.setCreatedTime(new Date());
        mongoTemplate.save(apBehaviorEntry);
        System.out.println("已保存数据");

    }

    @Autowired
    ApBehaviorEntryService apBehaviorEntryService;
    @Test
    public void testApBehaviorEntryService(){
        ApBehaviorEntry byUserIdOrEquipmentId = apBehaviorEntryService.findByUserIdOrEquipmentId(2, null);
        System.out.println(byUserIdOrEquipmentId);
    }
}
