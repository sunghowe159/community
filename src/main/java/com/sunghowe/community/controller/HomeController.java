package com.sunghowe.community.controller;

import com.sunghowe.community.entity.DiscussPost;
import com.sunghowe.community.entity.Page;
import com.sunghowe.community.entity.User;
import com.sunghowe.community.service.DiscussPostService;
import com.sunghowe.community.service.LikeService;
import com.sunghowe.community.service.UserService;
import com.sunghowe.community.util.CommunityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SungHowe
 * @title HomeController
 * @description
 * @create 2022-05-17 19:53
 */
@Controller
public class HomeController implements CommunityConstant {
    @Autowired
    private DiscussPostService discussPostService;
    @Autowired
    private UserService userService;
    @Autowired
    private LikeService likeService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page,
                               @RequestParam(name = "orderMode", defaultValue = "0") int orderMode){
        //方法调用前，SpringMVC会自动实例化Model和Page，并将Page注入Model
        // 所以，在thymeleaf中可以直接访问Page对象中的数据
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index?orderMode=" + orderMode);
        //得到包含limit条帖子的集合list
        List<DiscussPost> list = discussPostService
                .findDiscussPosts(0, page.getOffset(), page.getLimit(), orderMode);
        //定义一个新的ArrayList，其中每个元素为map集合
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null){ //遍历帖子的集合list
            for (DiscussPost post : list){
                HashMap<String, Object> map = new HashMap<>();
                map.put("post", post); // 将帖子放入map
                User user = userService.findUserById(post.getUserId());
                map.put("user", user); // 将发帖的用户放入同一个map

                long likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_POST, post.getId());
                map.put("likeCount",likeCount);
                discussPosts.add(map); // map作为元素存入ArrayList
            }
        }
        model.addAttribute("discussPosts", discussPosts);
        model.addAttribute("orderMode", orderMode);
        return "/index";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getErrorPage(){
        return "/error/500";
    }

    // 拒绝访问时的提示页面
    @RequestMapping(path = "/denied", method = RequestMethod.GET)
    public String getDeniedPage() {
        return "/error/404";
    }
}
