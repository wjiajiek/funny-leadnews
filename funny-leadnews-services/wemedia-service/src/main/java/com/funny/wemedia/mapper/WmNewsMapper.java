package com.funny.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.funny.model.wemedia.dtos.NewsAuthDTO;
import com.funny.model.wemedia.pojos.WmNews;
import com.funny.model.wemedia.vos.WmNewsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WmNewsMapper extends BaseMapper<WmNews> {


    List<WmNewsVO> findListAndPage(@Param("dto") NewsAuthDTO dto);
    long findListCount(@Param("dto") NewsAuthDTO dto);
}