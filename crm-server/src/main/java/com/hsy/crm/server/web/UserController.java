package com.hsy.crm.server.web;

import com.hsy.crm.server.bean.entity.TCrmUser;
import com.hsy.crm.server.bean.request.UserLoginRequestParam;
import com.hsy.crm.server.bean.request.UserRegRequestParam;
import com.hsy.crm.server.service.IUserService;
import com.hsy.crm.server.utils.ValidateUtil;
import com.hsy.java.bean.dto.ResponseBodyBean;
import com.hsy.java.bean.web.BaseController;
import com.hsy.java.util.validation.ParamValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author heshiyuan
 * @description <p></p>
 * @path springboot.demo/com.hsy.springboot.demo.springboot.jdbc
 * @date 2017/12/22 11:28
 * @github http://github.com/shiyuan2he
 * @email shiyuan4work@sina.com
 * Copyright (c) 2017 shiyuan4work@sina.com All rights reserved.
 * @price ¥5    微信：hewei1109
 */
@Api(value = "用户信息管理接口",description = "针对用户的增删改查操作提供的接口")
@RestController
@RequestMapping(value = "/api/rest/crm/user")
public class UserController extends BaseController{


    @Autowired private IUserService userService ;

    @ApiOperation(value = "用户注册",notes = "提供用户注册服务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名称",dataType = "String"),
            @ApiImplicitParam(name = "password",value = "登陆密码",dataType = "String"),
            @ApiImplicitParam(name = "sex",value = "性别,1:男 2:女",dataType = "Integer"),
            @ApiImplicitParam(name = "mobile",value = "手机号",required = true,dataType = "Long"),
            @ApiImplicitParam(name = "email",value = "邮箱",dataType = "String"),
            @ApiImplicitParam(name = "source",value = "用户来源",dataType = "String"),
            @ApiImplicitParam(name = "remark",value = "备注",dataType = "String")
    })
    @PostMapping(value = "/v1/reg")
    @ResponseBody
    public ResponseBodyBean<Boolean> reg(@Valid UserRegRequestParam regParam, BindingResult result){
        if(result.hasErrors()){
            return failure(ValidateUtil.validateRequestParam(result)) ;
        }

        if(userService.reg(regParam)){
            return success(true) ;
        }
        return failure() ;
    }

    @ApiOperation(value = "用户登陆",notes = "提供用户登陆服务")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName",value = "用户名称",dataType = "String"),
            @ApiImplicitParam(name = "password",value = "登陆密码",dataType = "String"),
            @ApiImplicitParam(name = "mobile",value = "手机号",dataType = "Long"),
    })
    @GetMapping(value = "/v1/login")
    public ResponseBodyBean<Boolean> login(@Valid UserLoginRequestParam loginParam, BindingResult result){
        if(result.hasErrors()){
            return failure(ValidateUtil.validateRequestParam(result)) ;
        }
        if(userService.login(loginParam)){
            return success(true) ;
        }
        return failure() ;
    }
}
