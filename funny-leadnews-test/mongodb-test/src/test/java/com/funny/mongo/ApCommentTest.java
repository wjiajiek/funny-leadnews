package com.funny.mongo;

import com.funny.mongo.pojo.ApComment;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class ApCommentTest {
    @Autowired
    MongoTemplate mongoTemplate;
    @Test
    public void testAdd() throws Exception{
        for (int i = 0; i < 10; i++) {
            ApComment apComment = new ApComment();
            //        apComment.setId("2222");
            apComment.setAddress("上海");
            apComment.setContent("上海是一个好地方222"+i);
            apComment.setLikes(2+i);
            // 60c2fe86c5a9e6651633a54a  ObjectId
            //        ApComment comment = mongoTemplate.insert(apComment);
            ApComment comment = mongoTemplate.save(apComment);
            System.out.println(comment);
        }
    }
    @Test
    public void testUpdate() throws Exception {
        Query query = Query.query(Criteria.where("address").is("上海"));
        Update update = new Update();
        update.set("address", "北京").set("createdTime", new Date());   // set修改器：只会对你指定列修改
        //        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, ApComment.class);
        //        System.out.println(updateResult);
        UpdateResult updateResult = mongoTemplate.updateMulti(query, update, ApComment.class);
        System.out.println(updateResult);
    }
    @Test
    public void testDelete() throws Exception {
        Query query = Query.query(Criteria.where("_id").is("60c2ffe79722b513119702b3"));
        DeleteResult deleteResult = mongoTemplate.remove(query, ApComment.class);
        System.out.println(deleteResult);
    }
    // 查询一个
    @Test
    public void testFindOne() throws Exception {
        //        ApComment comment = mongoTemplate.findById("60c2fe86c5a9e6651633a54a", ApComment.class);
        Query query = Query.query(Criteria.where("address").is("北京"));
        ApComment comment = mongoTemplate.findOne(query, ApComment.class);
        System.out.println(comment);
    }
    // 查询所有
    @Test
    public void testFindAll() throws Exception {
        List<ApComment> commentList = mongoTemplate.findAll(ApComment.class);
        for (ApComment apComment : commentList) {
            System.out.println(apComment);
        }
        System.out.println(commentList.toString());
    }
    // 按照条件查询
    @Test
    public void testFindByQuery() throws Exception{
        Query query = Query.query(Criteria
                .where("address").is("北京")
                .and("_id").in("60c301de64ffe574631f0c44","60c301de64ffe574631f0c47")
        );

        List<ApComment> apComments = mongoTemplate.find(query, ApComment.class);
        System.out.println(apComments);
    }
    // 分页查询
    @Test
    public void testFindPage() throws Exception {

        Query query = Query.query(Criteria
                .where("address").is("北京")
        );
        // 分页
        int page = 0;
        int size = 5;
        //        int limit = (page - 1) * size;
        //        query.limit(5);  // size

        Pageable pageable = PageRequest.of(1, 5);  // page=0 第一页
        query.with(pageable); // 分页

        Sort sort = Sort.by(Sort.Direction.DESC,"likes");
        query.with(sort);// 排序

        List<ApComment> commentList = mongoTemplate.find(query, ApComment.class);
        System.out.println(commentList);
    }

}
