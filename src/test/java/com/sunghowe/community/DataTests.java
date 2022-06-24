package com.sunghowe.community;

import com.sunghowe.community.entity.DiscussPost;
import com.sunghowe.community.service.DiscussPostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author SungHowe
 * @title DataTests
 * @description
 * @create 2022-06-23 15:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class DataTests {
    @Autowired
    private DiscussPostService discussPostService;
    @Test
    public void init(){
        for (int i = 0; i < 300000; i++) {
            DiscussPost post = new DiscussPost();
            post.setUserId(111);
            post.setTitle("压力测试贴");
            post.setContent("这是一个网站压力测试贴！需要插入大量数据！");
            post.setCreateTime(new Date());
            post.setScore(Math.random() * 2000);
            discussPostService.addDiscussPost(post);
        }
    }
}
