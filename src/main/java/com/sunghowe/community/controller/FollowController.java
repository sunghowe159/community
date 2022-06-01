package com.sunghowe.community.controller;

import com.sunghowe.community.entity.User;
import com.sunghowe.community.service.FollowService;
import com.sunghowe.community.util.CommunityUtil;
import com.sunghowe.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author SungHowe
 * @title FollowController
 * @description
 * @create 2022-06-01 15:17
 */
@Controller
public class FollowController {

    @Autowired
    private FollowService followService;
    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = "/follow", method = RequestMethod.POST)
    @ResponseBody
    public String follow(int entityType, int entityId) {
        User user = hostHolder.getUser();
        followService.follow(user.getId(), entityType, entityId);
        return CommunityUtil.getJSONString(0,"已关注！");
    }

    @RequestMapping(path = "/unfollow", method = RequestMethod.POST)
    @ResponseBody
    public String unFollow(int entityType, int entityId) {
        User user = hostHolder.getUser();
        followService.unFollow(user.getId(), entityType, entityId);
        return CommunityUtil.getJSONString(0,"已取关！");
    }

}
