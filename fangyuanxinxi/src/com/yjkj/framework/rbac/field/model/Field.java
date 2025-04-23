package com.yjkj.framework.rbac.field.model;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.area.model.Area;

public class Field extends BaseModel{
	
	
	private String area_id;
	private Area area;
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	
	

}
