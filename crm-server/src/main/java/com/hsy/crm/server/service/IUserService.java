package com.hsy.crm.server.service;

import com.hsy.crm.server.bean.request.UserLoginRequestParam;
import com.hsy.crm.server.bean.request.UserRegRequestParam;

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
     * @description <p>用户登陆</p>
     * @param loginParam 登陆参数
     * @return 
     * @author heshiyuan
     * @date 2017/12/22 15:30
     */
    boolean login(UserLoginRequestParam loginParam) ;
}
