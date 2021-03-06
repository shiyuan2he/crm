package com.hsy.crm.server.service.impl;

import com.hsy.crm.server.bean.entity.TCrmUser;
import com.hsy.crm.server.bean.request.UserRegRequestParam;
import com.hsy.crm.server.dao.TCrmUserRepository;
import com.hsy.crm.server.enums.ConstantsEnum;
import com.hsy.crm.server.service.IUserService;
import com.hsy.java.bean.vo.UserInfoBean;
import com.hsy.java.java.base.utils.RandomHelper;
import com.hsy.java.util.secure.MD5Helper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
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

        user.setUserCode(RandomHelper.generateValueByParam("","",8));
        user.setUserName(regParam.getUserName());
        user.setPassword(
                MD5Helper.stringToMD5ByIdentified(
                        ConstantsEnum.SECURE_TYPE_MD5_PREFIX.getCode(),
                        regParam.getPassword())
        );
        user.setEmail(regParam.getEmail());
        user.setMobile(regParam.getMobile());
        user.setSource(regParam.getSource());
        user.setSex(regParam.getSex());
        user.setCreater(0L);
        user.setCreateTime(nowTime);
        user.setIsDel((byte) 0);
        user.setRemark(regParam.getRemark());
        user.setAge(regParam.getAge());
        user.setPicture(regParam.getPicture());
        user.setRealName(regParam.getRealName());
        user = crmUserRepository.saveAndFlush(user) ;
        if(user.getId() > 0){
            return true ;
        }
        return false ;
    }
    @Override
    public UserInfoBean query(Long id,Long mobile, String username, String password){
        UserInfoBean userInfoBean = new UserInfoBean();
        /**
         * 第一顺位：id查询
         * 第二顺位：mobile查询
         * 第三顺位：username，password查询
         */
        TCrmUser user = null ;
        if(null != id){
            //
        }else if(null != mobile){

        }else if(StringUtils.isNotBlank(username)&&StringUtils.isNotBlank(password)){
            // 用户名密码登陆
            user = crmUserRepository.withUsernameAndPasswordQuery(
                    username,
                    MD5Helper.stringToMD5ByIdentified(
                            ConstantsEnum.SECURE_TYPE_MD5_PREFIX.getCode(),
                            password),
                    (byte)0) ;
        }else{
            // 手机号短信验证码登陆
        }
        if (null != user) {
            try {
                BeanUtils.copyProperties(userInfoBean,user);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return userInfoBean ;
    }
}
