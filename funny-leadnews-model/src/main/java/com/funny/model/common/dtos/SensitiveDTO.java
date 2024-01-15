package com.funny.model.common.dtos;

import lombok.Data;

@Data
public class SensitiveDTO extends PageRequestDTO {
    /**
     * 敏感词名称
     */
    private String name;
}