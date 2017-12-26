package com.hsy.crm.server.service;

import com.hsy.crm.server.bean.request.UserRegRequestParam;
import com.hsy.java.bean.vo.UserInfoBean;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc
 * @date 2017/12/22 10:33
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public interface IUserService {
    /**
     * @param user 用户对象
     * @description <p>用户注册功能</p>
     * @author heshiyuan
     * @date 2017/12/22 10:39
     */
    boolean reg(UserRegRequestParam user) ;
    /**
     * @description <p>用户信息查询</p>
     * @param mobile 用户手机号
     * @param id 用户id
     * @param username 用户名称
     * @param password 用户登录密码
     * @return 用户信息dto
     * @author heshiyuan
     * @date 2017/12/22 15:30
     */
    UserInfoBean query(Long id,Long mobile,String username,String password) ;
}
