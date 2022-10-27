package com.zyc.ss.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @project: ssm_sms
 * @description: 用户登录表单信息
 */
@Data
@Accessors(chain = true)
public class LoginForm {

    private String username;
    private String password;
    private String verifiCode;
    private Integer userType;

}
