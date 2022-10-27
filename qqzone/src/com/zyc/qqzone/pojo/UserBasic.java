package com.zyc.qqzone.pojo;

import java.util.List;

/**
 * @Description
 * @Author zyc
 * @Date 2022/8/9 20:19
 */
public class UserBasic {
    private Integer id;
    private String loginID;
    private String nickName;
    private String pwd;
    private String headImg;
    private UserDetail selfInfo; // 自己的详细信息
    private List<Topic> topics;// 发表的日志
    private List<UserBasic> friends;// 自己的朋友

    public UserBasic() {
    }

    public UserBasic(Integer id, String loginID, String nickName, String pwd, String headImg) {
        this.id = id;
        this.loginID = loginID;
        this.nickName = nickName;
        this.pwd = pwd;
        this.headImg = headImg;
    }

    @Override
    public String toString() {
        return "UserBasic{" +
                "id=" + id +
                ", loginID='" + loginID + '\'' +
                ", nickName='" + nickName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", headImg='" + headImg + '\'' +
                ", selfInfo=" + selfInfo +
                ", topics=" + topics +
                ", friends=" + friends +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public UserDetail getSelfInfo() {
        return selfInfo;
    }

    public void setSelfInfo(UserDetail selfInfo) {
        this.selfInfo = selfInfo;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<UserBasic> getFriends() {
        return friends;
    }

    public void setFriends(List<UserBasic> friends) {
        this.friends = friends;
    }
}
