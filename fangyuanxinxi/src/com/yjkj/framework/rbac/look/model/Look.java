package com.yjkj.framework.rbac.look.model;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.house.model.House;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

public class Look extends BaseModel{
	
	private String user_id;
	private String house_id;
	private String look_time;
	private String result;
	private String manager_id;
	private UserInfo userInfo;
	private House house;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getHouse_id() {
		return house_id;
	}
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	public String getLook_time() {
		return look_time;
	}
	public void setLook_time(String look_time) {
		this.look_time = look_time;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	
	
	

}
