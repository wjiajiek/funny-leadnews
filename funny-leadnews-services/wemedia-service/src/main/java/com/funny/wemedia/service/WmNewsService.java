package com.funny.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.funny.model.common.dtos.ResponseResult;
import com.funny.model.wemedia.dtos.NewsAuthDTO;
import com.funny.model.wemedia.dtos.WmNewsDTO;
import com.funny.model.wemedia.dtos.WmNewsPageReqDTO;
import com.funny.model.wemedia.pojos.WmNews;
public interface WmNewsService extends IService<WmNews> {
    /**
     * 查询所有自媒体文章
     * @return
     */
    public ResponseResult findList(WmNewsPageReqDTO dto);


    /**
     * 自媒体文章发布
     * @param WmNewsDTO
     * @return
     */
    ResponseResult submitNews(WmNewsDTO dto);



    /**
     * 根据文章id查询文章
     * @return
     */
    ResponseResult findWmNewsById(Integer id);


    /**
     * 删除文章
     * @return
     */
    ResponseResult delNews(Integer id);

    /**
     * 上下架
     * @param dto
     * @return
     */
    ResponseResult downOrUp(WmNewsDTO dto);

    /**
     * 查询文章列表
     * @param dto
     * @return
     */
    public ResponseResult findList(NewsAuthDTO dto);


    /**
     * 查询文章详情
     * @param id
     * @return
     */
    public ResponseResult findWmNewsVo(Integer id) ;



    /**
     *  自媒体文章人工审核
     * @param status  2  审核失败  4 审核成功
     * @param dto
     * @return
     */
    public ResponseResult updateStatus(Short status, NewsAuthDTO dto);
}