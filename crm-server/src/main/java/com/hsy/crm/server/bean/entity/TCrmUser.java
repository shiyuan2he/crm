package com.hsy.crm.server.bean.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "t_crm_user")
public class TCrmUser implements Serializable{
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(name = "user_code",unique = true)
	private String userCode;
	@Column(name = "user_name",unique = true)
	private String userName;
	@Column
	private String password;
	@Column(name = "password_encryption_type")
	private String passwordEncryptionType;
	@Column
	private Byte sex ;
	@Column
	private Long mobile;
	@Column
	private String email ;
	@Column
	private Long creater;
	@Column(name = "create_time")
	private Date createTime;
	@Column
	private Long updater;
	@Column(name = "update_time")
	private Date updateTime;
	@Column
	private String source;
	@Column
	private String remark ;
	@Column(name = "is_del")
	private Byte isDel ;
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return id;
	}
	public void setUserCode(String userCode){
		this.userCode=userCode;
	}
	public String getUserCode(){
		return userCode;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserName(){
		return userName;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setPasswordEncryptionType(String passwordEncryptionType){
		this.passwordEncryptionType=passwordEncryptionType;
	}
	public String getPasswordEncryptionType(){
		return passwordEncryptionType;
	}
	public void setMobile(Long mobile){
		this.mobile=mobile;
	}
	public Long getMobile(){
		return mobile;
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
	public void setSource(String source){
		this.source=source;
	}
	public String getSource(){
		return source;
	}

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }
}

