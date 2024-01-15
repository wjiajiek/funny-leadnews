package com.funny.admin.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.funny.model.admin.pojos.AdSensitive;
import com.funny.model.common.dtos.ResponseResult;
import com.funny.model.common.dtos.SensitiveDTO;

import java.util.List;


public interface AdSensitiveService extends IService<AdSensitive> {

    /**
     * 查询敏感词列表
     * @param dto
     * @return
     */
    public ResponseResult list(SensitiveDTO dto);

    /**
     * 新增
     * @param adSensitive
     * @return
     */
    public ResponseResult insert(AdSensitive adSensitive);

    /**
     * 修改
     * @param adSensitive
     * @return
     */
    public ResponseResult update(AdSensitive adSensitive);

    /**
     * 删除
     * @param id
     * @return
     */
    public ResponseResult delete(Integer id);

    /**
     * 查询敏感词内容列表
     * @return
     */
    public ResponseResult<List<String>> selectAllSensitives();
}
