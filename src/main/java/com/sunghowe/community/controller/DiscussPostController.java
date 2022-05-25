package com.sunghowe.community.controller;

import com.sunghowe.community.entity.DiscussPost;
import com.sunghowe.community.entity.User;
import com.sunghowe.community.service.DiscussPostService;
import com.sunghowe.community.util.CommunityUtil;
import com.sunghowe.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.spec.PSource;
import java.util.Date;

/**
 * @author SungHowe
 * @title DiscussPostController
 * @description
 * @create 2022-05-25 14:20
 */
@Controller
@RequestMapping("/discuss")
public class DiscussPostController {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addDiscussPost (String title, String content) {
        User user = hostHolder.getUser();
        if (user == null) {
            return CommunityUtil.getJSONString(403, "未登录账号！");
        }

        DiscussPost post = new DiscussPost();
        post.setUserId(user.getId());
        post.setTitle(title);
        post.setContent(content);
        post.setCreateTime(new Date());
        discussPostService.addDiscussPost(post);
        //  报错之后统一处理
        return CommunityUtil.getJSONString(0,"发布成功!");
    }
}
