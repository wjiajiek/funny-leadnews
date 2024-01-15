package com.funny.model.admin.pojos;

import com.funny.model.common.dtos.PageRequestDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChannelDTO extends PageRequestDTO {
    /**
     * 频道名称
     */
    @ApiModelProperty("频道名称")
    private String name;
    /**
     * 频道状态
     */
    private Integer status;
}