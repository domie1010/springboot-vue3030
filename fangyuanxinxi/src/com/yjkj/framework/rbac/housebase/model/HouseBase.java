package com.yjkj.framework.rbac.housebase.model;

import com.yjkj.framework.base.basemodel.BaseModel;

public class HouseBase extends BaseModel{
	
	private String address;
	private String video;
	private String url;
	private String remark;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	

}
