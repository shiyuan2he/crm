package com.hsy.crm.server.web;

import com.hsy.crm.server.bean.request.UserQueryRequestParam;
import com.hsy.crm.server.bean.request.UserRegRequestParam;
import com.hsy.crm.server.service.IUserService;
import com.hsy.java.bean.dto.ResponseBodyBean;
import com.hsy.java.bean.vo.UserInfoBean;
import com.hsy.java.bean.web.BaseController;
import com.hsy.java.util.validation.ParamValidation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author heshiyuan
 * @description <p>用户模块，提供swagger2 restful接口文档</p>
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
            @ApiImplicitParam(name = "mobile",value = "手机号",dataType = "Long"),
            @ApiImplicitParam(name = "email",value = "邮箱",dataType = "String"),
            @ApiImplicitParam(name = "source",value = "用户来源",dataType = "String"),
            @ApiImplicitParam(name = "remark",value = "备注",dataType = "String"),
            @ApiImplicitParam(name = "age",value = "年龄",dataType = "Short"),
            @ApiImplicitParam(name = "picture",value = "图像",dataType = "String"),
            @ApiImplicitParam(name = "realName",value = "真实姓名",dataType = "String")
    })
    @PostMapping(value = "/v1/reg")
    @ResponseBody
    public ResponseBodyBean<Boolean> reg(@Valid UserRegRequestParam regParam, BindingResult result, HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST");
        if(result.hasErrors()){
            return failure(ParamValidation.validateRequestParam(result)) ;
        }

        if(userService.reg(regParam)){
            return success(true) ;
        }
        return failure() ;
    }

    @ApiOperation(value = "用户信息查询",notes = "提供用户信息查询服务：可以根据手机号或者用户名密码查询，提供三种查询方式：id;mobile;username,password")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id",dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "mobile",value = "手机号",dataType = "Long"),
            @ApiImplicitParam(name = "userName",value = "用户名称",dataType = "String"),
            @ApiImplicitParam(name = "password",value = "登陆密码",dataType = "String")
    })
    @GetMapping(value = {"/v1/query","/v1/{id}/query"})
    public ResponseBodyBean<UserInfoBean> query(@Valid UserQueryRequestParam queryParam, BindingResult result){
        if(result.hasErrors()){
            return failure(ParamValidation.validateRequestParam(result)) ;
        }
        UserInfoBean userInfoBean = userService.query(queryParam.getId(),queryParam.getMobile(),
                queryParam.getUserName(),queryParam.getPassword()) ;
        if(null != userInfoBean){
            return success(userInfoBean) ;
        }
        return failure() ;
    }
}
