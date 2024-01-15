package com.funny.user;
import java.util.Date;

import com.funny.feigns.WemediaFeign;
import com.funny.model.common.dtos.ResponseResult;
import com.funny.model.wemedia.pojos.WmUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FeignTest {

    @Autowired
    WemediaFeign wemediaFeign;

    @Test
    public void testFindByName(){
        ResponseResult<WmUser> zhangsan = wemediaFeign.findByName("zhangsan");
        System.out.println(zhangsan);
    }

    @Test
    public void testSave(){
        WmUser user = new WmUser();
        user.setApUserId(3);
        user.setName("asd");
        user.setPassword("asd");
        user.setSalt("asd");
        user.setNickname("asd");
        user.setImage("asd");
        user.setLocation("asd");
        user.setPhone("asd");
        user.setStatus(0);
        user.setEmail("asd");
        user.setType(0);
        user.setScore(0);
        user.setLoginTime(new Date());
        user.setCreatedTime(new Date());
        ResponseResult<WmUser> save = wemediaFeign.save(user);
        System.out.println(save);

    }
}
