package com.hsy.crm.server.web;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @author heshiyuan
 * @description <p></p>
 * @date 2017/12/22 14:37
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class UserControllerTest extends SpringbootJunitBase {
    MultiValueMap<String,Object> paramsMap = new LinkedMultiValueMap<>();
    @Test
    public void reg() throws Exception {
        paramsMap.clear();
        paramsMap.add("mobile", "15910868535");
        this.postRequest("/api/rest/crm/user/v1/reg",paramsMap);
    }
}