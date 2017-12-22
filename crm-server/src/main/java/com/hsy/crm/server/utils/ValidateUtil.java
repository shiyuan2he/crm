package com.hsy.crm.server.utils;

import org.springframework.validation.BindingResult;

import static java.util.stream.Collectors.toList;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path crm/com.hsy.crm.server.util
 * @date 2017/12/22 15:24
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public class ValidateUtil {

    public static String validateRequestParam(BindingResult result){
        return result.getAllErrors()
                .stream()
                .filter(errorObjuct -> null!=errorObjuct.getObjectName())
                .collect(toList())
                .get(0)
                .getObjectName()
                ;

    }
}
