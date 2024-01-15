package com.funny.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.funny.article.mapper.AuthorMapper;
import com.funny.article.service.AuthorService;
import com.funny.model.article.pojos.ApAuthor;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper,ApAuthor> implements AuthorService {

}
