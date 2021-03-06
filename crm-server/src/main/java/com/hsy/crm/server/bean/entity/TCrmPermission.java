package com.hsy.crm.server.bean.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class TCrmPermission implements Serializable{
	private Long id;
	private String authAddress;
	private String authDescription;
	private String authImg ;
	private String authStyle ;
	private Long parentId;
	private Long creater;
	private Date createTime;
	private Long updater;
	private Date updateTime;
	private List<TCrmPermission> children ;// 子节点


	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setAuthAddress(String authAddress){
		this.authAddress=authAddress;
	}
	public String getAuthAddress(){
		return authAddress;
	}
	public void setAuthDescription(String authDescription){
		this.authDescription=authDescription;
	}
	public String getAuthDescription(){
		return authDescription;
	}
	public void setParentId(Long parentId){
		this.parentId=parentId;
	}
	public Long getParentId(){
		return parentId;
	}
	public void setCreater(Long creater){
		this.creater=creater;
	}
	public Long getCreater(){
		return creater;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setUpdater(Long updater){
		this.updater=updater;
	}
	public Long getUpdater(){
		return updater;
	}
	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}
	public Date getUpdateTime(){
		return updateTime;
	}

    public List<TCrmPermission> getChildren() {
        return children;
    }

    public void setChildren(List<TCrmPermission> children) {
        this.children = children;
    }

    public String getAuthImg() {
        return authImg;
    }

    public void setAuthImg(String authImg) {
        this.authImg = authImg;
    }

    public String getAuthStyle() {
        return authStyle;
    }

    public void setAuthStyle(String authStyle) {
        this.authStyle = authStyle;
    }
}

