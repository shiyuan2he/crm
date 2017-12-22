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

    @Query("select u from TCrmUser u where u.userName=:userName and u.password=:password and u.isDel=:isDel")
    TCrmUser withUsernameAndPasswordQuery(@Param(value = "userName") String userName,
                             @Param(value = "password") String password,
                             @Param(value = "isDel") Byte isDel);
}
