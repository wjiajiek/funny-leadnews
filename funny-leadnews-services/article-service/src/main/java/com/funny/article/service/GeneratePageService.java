package com.funny.article.service;

import com.funny.model.article.pojos.ApArticle;

public interface GeneratePageService {
    /**
     * 生成文章静态页
     */
    void generateArticlePage(String content, ApArticle apArticle);
}