package com.funny.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.funny.article.mapper.ApArticleConfigMapper;
import com.funny.article.service.ApArticleConfigService;
import com.funny.model.article.pojos.ApArticleConfig;
import org.springframework.stereotype.Service;

@Service
public class ApArticleConfigServiceImpl extends ServiceImpl<ApArticleConfigMapper, ApArticleConfig> implements ApArticleConfigService {
}