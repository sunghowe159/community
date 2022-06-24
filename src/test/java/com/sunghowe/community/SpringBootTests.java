package com.sunghowe.community;

import com.sunghowe.community.entity.DiscussPost;
import com.sunghowe.community.service.DiscussPostService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author SungHowe
 * @title SpringBootTests
 * @description
 * @create 2022-06-24 8:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SpringBootTests {

    @Autowired
    private DiscussPostService discussPostService;

    private static DiscussPost data;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Before
    public void before() {
        System.out.println("before");
        data = new DiscussPost();

    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }
}
