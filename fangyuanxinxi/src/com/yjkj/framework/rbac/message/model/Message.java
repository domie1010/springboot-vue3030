package com.yjkj.framework.rbac.message.model;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.house.model.House;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

public class Message extends BaseModel{
	
	private String user_id;
	private String manager_id;
	private String house_id;
	private String message;
	private String reply_message;
	private UserInfo userInfo;
	private House house;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getHouse_id() {
		return house_id;
	}
	public void setHouse_id(String house_id) {
		this.house_id = house_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReply_message() {
		return reply_message;
	}
	public void setReply_message(String reply_message) {
		this.reply_message = reply_message;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
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
