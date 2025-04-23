package com.yjkj.framework.rbac.area.model;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.city.model.City;

public class Area extends BaseModel{
	
	
	private String city_id;
	private City city;
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	

}
