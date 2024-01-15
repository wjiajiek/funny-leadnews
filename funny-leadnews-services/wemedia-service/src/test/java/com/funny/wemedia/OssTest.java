package com.funny.wemedia;

import com.funny.file.service.FileStorageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
public class OssTest {

    @Autowired
    FileStorageService fileStorageService;

    @Value("${file.oss.prefix}")
    String prefix;
    @Value("${file.oss.web-site}")
    String website;
    @Test
    public void testOss() throws FileNotFoundException {

        //prefix,bucket的哪个文件夹
        //
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\ow.jpg");
        String store = fileStorageService.store(prefix, "ooww.jpg", fileInputStream);
        System.out.println("文件在oss中的路径:"+store);
        System.out.println("文件访问地址：" + website + store);

    }
}
