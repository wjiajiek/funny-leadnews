package com.funny.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.funny.model.admin.pojos.AdChannel;
import com.funny.model.admin.pojos.ChannelDTO;
import com.funny.model.common.dtos.ResponseResult;

public interface AdChannelService extends IService<AdChannel> {
    /**
     * 根据名称分页查询频道列表
     * @param dto
     * @return
     */
    public ResponseResult findByNameAndPage(ChannelDTO dto);


    /**
     * 新增
     * @param channel
     * @return
     */
    public ResponseResult insert(AdChannel channel);


    /**
     * 更改
     * @param adChannel
     * @return
     */
    public ResponseResult update(AdChannel adChannel);


    /**
     * 删除
     * @param id
     * @return
     */
    public ResponseResult deleteById(Integer id);


}