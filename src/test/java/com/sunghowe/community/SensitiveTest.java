package com.sunghowe.community;

import com.sunghowe.community.util.SensitiveFilter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author SungHowe
 * @title SensitiveTest
 * @description
 * @create 2022-05-24 20:16
 */
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTest {
    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter() {
        String text = "他会赌&*$博而且吸&%*(毒，同时还开&%*(票，然后跑去嫖娼！！！";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }
}
