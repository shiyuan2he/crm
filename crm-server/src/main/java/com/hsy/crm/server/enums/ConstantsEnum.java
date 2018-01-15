package com.hsy.crm.server.enums;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path crm/com.hsy.crm.server.enums
 * @date 2018/1/15 19:01
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
public enum ConstantsEnum {
    SECURE_TYPE_MD5_PREFIX("CRM","md5加密前缀"),
    ;
    private String code ;
    private String description ;

    ConstantsEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
