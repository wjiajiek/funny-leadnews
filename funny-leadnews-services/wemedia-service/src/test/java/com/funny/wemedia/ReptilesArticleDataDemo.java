package com.funny.wemedia;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReptilesArticleDataDemo {

    @Test
    public void parseContent()  {

        List<Map> contentMap = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect("https://m.163.com/touch/news/sub/history/?ver=c&clickfrom=index2018_header_main")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.35")
                    .get();
            Elements a = document.getElementsByTag("a");
            for(Element aa: a){
                String href = aa.attr("href");
                System.out.println(href);
            }


        } catch (Exception e) {
            e.printStackTrace();
            Map map = new HashMap();
            map.put("type","text");
            map.put("value","测试文章内容");
            contentMap.add(map);
        }

    }
}
