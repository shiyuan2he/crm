package com.hsy.crm.server.service.impl;

import com.hsy.crm.server.bean.entity.TCrmUser;
import com.hsy.crm.server.bean.request.UserLoginRequestParam;
import com.hsy.crm.server.bean.request.UserRegRequestParam;
import com.hsy.crm.server.dao.TCrmUserRepository;
import com.hsy.crm.server.service.IUserService;
import com.hsy.java.enums.ConstantEnum;
import com.hsy.java.java.base.utils.RandomHelper;
import com.hsy.java.util.secure.AESHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

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
@Service(value = "userService")
public class UserServiceImpl implements IUserService{

    @Autowired private TCrmUserRepository crmUserRepository;
    @Override
    public boolean reg(UserRegRequestParam regParam) {
        TCrmUser user = new TCrmUser() ;
        Date nowTime = Calendar.getInstance().getTime() ;

        user.setUserCode(RandomHelper.generateStringByLength(8));
        user.setUserName(regParam.getUserName());
        user.setPassword(AESHelper.encode(user.getPassword()));
        user.setPasswordEncryptionType(ConstantEnum.ENCRYPTION_TYPE_AES.getCode());
        user.setEmail(regParam.getEmail());
        user.setMobile(regParam.getMobile());
        user.setSource(regParam.getSource());
        user.setSex(regParam.getSex());
        user.setCreateTime(nowTime);
        user.setIsDel((byte) 0);
        user.setRemark(regParam.getRemark());
        crmUserRepository.saveAndFlush(user) ;
        if(user.getId() > 0){
            return true ;
        }
        return false ;
    }
    @Override
    public boolean login(UserLoginRequestParam loginParam){
        TCrmUser user = null ;
        if(StringUtils.isNotBlank(loginParam.getUserName())&&StringUtils.isNotBlank(loginParam.getPassword())){
            // 用户名密码登陆
            user = crmUserRepository.withUsernameAndPasswordQuery(
                    loginParam.getUserName(),
                    AESHelper.encode(loginParam.getPassword()),
                    (byte)0) ;
        }else{
            // 手机号短信验证码登陆
        }
        if (null != user) return true ;
        return false ;
    }
}
