package com.funny.behavior.service.impl;

import com.funny.behavior.service.ApBehaviorEntryService;
import com.funny.behavior.service.ApLikesBehaviorService;
import com.funny.model.behavior.dtos.LikesBehaviorDTO;
import com.funny.model.behavior.pojos.ApBehaviorEntry;
import com.funny.model.behavior.pojos.ApLikesBehavior;
import com.funny.model.common.dtos.ResponseResult;
import com.funny.model.common.enums.AppHttpCodeEnum;
import com.funny.model.threadlocal.AppThreadLocalUtils;
import com.funny.model.user.pojos.ApUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ApLikesBehaviorServiceImpl implements ApLikesBehaviorService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    ApBehaviorEntryService apBehaviorEntryService;

    @Override
    public ResponseResult like(LikesBehaviorDTO dto) {
        // 1. 校验参数
        // 点赞需要登录
        //校验文章id不能为空     使用注解校验
        // 校验点赞方式 只能是0 或 1   使用注解校验
        ApUser user = AppThreadLocalUtils.getUser();
        Integer id = user.getId();
        // 2. 根据当前登录用户id查询行为实体对象
        ApBehaviorEntry apBehaviorEntry = apBehaviorEntryService.findByUserIdOrEquipmentId(id, null);
        String idEntry = apBehaviorEntry.getId();

        // 3. 如果是点赞操作  判断是否已经点过赞
        // 4. 没有点过赞则 像mongo点赞集合中 添加点赞数据
        // 5. 如果是取消点赞操作  在mongo点赞集合中 删除对应点赞数据
        Short operation = dto.getOperation();
        Query query = Query.query(Criteria.where("entryId").is(idEntry));
        ApLikesBehavior one = mongoTemplate.findOne(query, ApLikesBehavior.class);
        if(operation == 0){
            if(one != null){
                return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST,"点赞过了");
            }
            ApLikesBehavior apLikesBehavior = new ApLikesBehavior();
            apLikesBehavior.setCreatedTime(new Date());
            apLikesBehavior.setOperation((short)0);
            apLikesBehavior.setArticleId(dto.getArticleId());
            apLikesBehavior.setEntryId(idEntry);
            mongoTemplate.save(apLikesBehavior);
            return ResponseResult.okResult();
        }
        mongoTemplate.remove(query,ApLikesBehavior.class);
        return ResponseResult.okResult();


    }
}
