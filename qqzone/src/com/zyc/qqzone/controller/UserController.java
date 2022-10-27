package com.zyc.qqzone.controller;

import com.zyc.qqzone.pojo.Topic;
import com.zyc.qqzone.pojo.UserBasic;
import com.zyc.qqzone.service.TopicService;
import com.zyc.qqzone.service.UserBasicService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 22:58
 */
public class UserController {
    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId, String password, HttpSession session) {
        UserBasic userBasic = userBasicService.login(loginId, password);
        if (userBasic != null) {//验证成功
            //获取好友信息
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            //获取日志信息
            List<Topic> topicList = topicService.getTopicList(userBasic);
            userBasic.setFriends(friendList);
            userBasic.setTopics(topicList);
            session.setAttribute("userBasic", userBasic);
            session.setAttribute("friend", userBasic);
            return "index";
        }
        return "login";
    }

    public String friend(Integer id, HttpSession session) {
        //1.根据id获取指定的用户信息
        UserBasic currFriend = userBasicService.getUserBasicById(id);

        List<Topic> topicList = topicService.getTopicList(currFriend);

        currFriend.setTopics(topicList);

        session.setAttribute("friend", currFriend);

        return "index";
    }

}
