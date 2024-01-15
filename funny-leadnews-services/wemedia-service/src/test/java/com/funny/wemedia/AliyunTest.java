package com.funny.wemedia;

import com.funny.aliyun.GreenImageScan;
import com.funny.aliyun.GreenTextScan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AliyunTest {
    @Autowired
    private GreenTextScan greenTextScan;
    @Autowired
    private GreenImageScan greenImageScan;

    @Test
    public void testText() throws Exception{
        Map map = greenTextScan.greenTextScan("我是一个文本,冰毒买卖是违法的");
        System.out.println(map);
    }
    @Test
    public void testImage() throws Exception {
        List<String> images = new ArrayList<>();
        images.add("");
        Map map = greenImageScan.imageUrlScan(images);
        System.out.println(map);
    }
}