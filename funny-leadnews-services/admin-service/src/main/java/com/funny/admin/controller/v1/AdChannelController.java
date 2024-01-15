package com.funny.admin.controller.v1;

import com.funny.admin.service.AdChannelService;
import com.funny.common.exception.CustException;
import com.funny.model.admin.pojos.AdChannel;
import com.funny.model.admin.pojos.ChannelDTO;
import com.funny.model.common.dtos.ResponseResult;
import com.funny.model.common.enums.AppHttpCodeEnum;
import com.funny.model.common.validator.ValidatorAdd;
import com.funny.model.common.validator.ValidatorUpdate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/channel")
@Api(value = "频道管理",tags="频道管理",description = "频道管理API")
public class AdChannelController{

    @Autowired
    AdChannelService channelService;
    @PostMapping("/list")
    @ApiOperation("频道分页列表查询")
    @ApiImplicitParams(
            @ApiImplicitParam(value = "dto",dataType = "ChannelDTO",required = true)
    )
    public ResponseResult list(@RequestBody ChannelDTO dto){
        return channelService.findByNameAndPage(dto);
    }


    @ApiOperation("频道新增")
    @PostMapping("/save")
    public ResponseResult insert(@RequestBody @Validated(ValidatorAdd.class) AdChannel channel){
        return channelService.insert(channel);
    }


    @ApiOperation("频道修改")
    @PostMapping("/update")
    public ResponseResult update(@RequestBody @Validated(ValidatorUpdate.class) AdChannel adChannel) {
        return channelService.update(adChannel);
    }


    @ApiOperation("根据频道ID删除")
    @GetMapping("/del/{id}")
    public ResponseResult deleteById(@PathVariable("id") Integer id) {

//        if(true){
//            CustException.cust(AppHttpCodeEnum.DATA_NOT_EXIST);
//        }
        return channelService.deleteById(id);
    }

    @ApiOperation("查询全部频道")
    @GetMapping("/channels")
    public ResponseResult findAll() {
        List<AdChannel> list = channelService.list();
        return ResponseResult.okResult(list);
    }


    @ApiOperation("根据id查询频道")
    @GetMapping("/one/{id}")
    public ResponseResult findOne(@PathVariable Integer id) {
        return ResponseResult.okResult(channelService.getById(id));
    }
}