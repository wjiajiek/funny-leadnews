package com.funny.model.behavior.dtos;





import lombok.Data;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class LikesBehaviorDTO {
    // 设备ID
    Integer equipmentId;
    // 文章、动态、评论等ID
    @NotNull
    Long articleId;
    /**
     * 喜欢内容类型
     * 0文章
     * 1动态
     * 2评论
     */
    Short type;
    /**
     * 喜欢操作方式
     * 0 点赞
     * 1 取消点赞
     */
    @Min(value = 0, message = "点赞方式必须为0或1")
    @Max(value = 1, message = "点赞方式必须为0或1")
    Short operation;
}