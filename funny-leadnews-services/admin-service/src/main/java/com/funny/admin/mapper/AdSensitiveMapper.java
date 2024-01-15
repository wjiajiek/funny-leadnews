package com.funny.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.funny.model.admin.pojos.AdSensitive;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdSensitiveMapper extends BaseMapper<AdSensitive> {
    @Select("select sensitives from ad_sensitive")
    List<String> findAllSensitives();
}