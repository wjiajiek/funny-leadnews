package com.funny.feigns;

import com.funny.config.FunnyFeignAutoConfiguration;
import com.funny.feigns.fallback.WemediaFeignFallback;
import com.funny.model.common.dtos.ResponseResult;
import com.funny.model.wemedia.pojos.WmNews;
import com.funny.model.wemedia.pojos.WmUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
    	//微服务名称
        value = "leadnews-wemedia",  
    	//服务降级实现类
        fallbackFactory = WemediaFeignFallback.class,
    	//feign的配置 日志级别
        configuration = FunnyFeignAutoConfiguration.class
)
public interface WemediaFeign {
    @PostMapping("/api/v1/user/save")
    public ResponseResult<WmUser> save(@RequestBody WmUser wmUser);
    @GetMapping("/api/v1/user/findByName/{name}")
    public ResponseResult<WmUser> findByName(@PathVariable("name") String name);

    @GetMapping("/api/v1/news/one/{id}")
    public ResponseResult<WmNews> findWmNewsById(@PathVariable("id") Integer id);
    @PutMapping("/api/v1/news/update")
    ResponseResult updateWmNews(@RequestBody WmNews wmNews);
}