package com.hsy.crm.server.dao;

import com.hsy.crm.server.bean.entity.TCrmUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Repository(value = "crmUserRepository")
public interface TCrmUserRepository extends JpaRepository<TCrmUser,Long>{

    @Query("select user from TCrmUser user where user.mobile =: mobile and user.isDel =: isDel")
    TCrmUser withMobileQuery(@Param("mobile") Long mobile,@Param("isDel") Byte isDel);

    @Query("select user from TCrmUser user where user.username =: username and user.password =: password and user.isDel =: isDel")
    TCrmUser withUsernameAndPasswordQuery(@Param("username") String username,
                             @Param("password") String password,
                             @Param("isDel") Byte isDel);
}
