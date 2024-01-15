package com.funny.behavior.controller.v1;

import com.funny.behavior.service.ApLikesBehaviorService;
import com.funny.model.behavior.dtos.LikesBehaviorDTO;
import com.funny.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1")
@Validated
public class ApLikesBehaviorController {
    @Autowired
    ApLikesBehaviorService apLikesBehaviorService;

    @PostMapping("/likes_behavior")
    public ResponseResult likeBehavior(@RequestBody LikesBehaviorDTO dto){
        return apLikesBehaviorService.like(dto);
    }

}
