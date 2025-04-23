package com.yjkj.framework.rbac.house.model;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.housebase.model.HouseBase;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

public class House extends BaseModel{
	
	private String user_id;
	private String base_id;
	private String address;
	private Integer price;
	private String url;
	private String size;
	private String owner;
	private String typee;
	private String showw;
	private String good;
	private String remark;
	private UserInfo userInfo;
	private HouseBase houseBase;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public String getTypee() {
		return typee;
	}
	public void setTypee(String typee) {
		this.typee = typee;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getShoww() {
		return showw;
	}
	public void setShoww(String showw) {
		this.showw = showw;
	}
	public String getGood() {
		return good;
	}
	public void setGood(String good) {
		this.good = good;
	}
	public String getBase_id() {
		return base_id;
	}
	public void setBase_id(String base_id) {
		this.base_id = base_id;
	}
	public HouseBase getHouseBase() {
		return houseBase;
	}
	public void setHouseBase(HouseBase houseBase) {
		this.houseBase = houseBase;
	}
	
	
	

}
