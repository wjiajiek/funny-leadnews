package com.funny.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.funny.article.mapper.ApArticleContentMapper;
import com.funny.article.service.ApArticleContentService;
import com.funny.model.article.pojos.ApArticleContent;
import org.springframework.stereotype.Service;

@Service
public class ApArticleContentServiceImpl extends ServiceImpl<ApArticleContentMapper,ApArticleContent> implements ApArticleContentService {

}