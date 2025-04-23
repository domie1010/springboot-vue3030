package com.yjkj.framework.rbac.city.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.city.model.City;

public interface CityDao {

	public List<City> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<City> informationLoadAll(City City) throws Exception;
	
	public Integer count(City City) throws Exception;
	
	public City informationLoadOne(City City) throws Exception;
	
	public void informationDelete(City City) throws Exception;
	
	public void informationAdd(City City) throws Exception;
	
	public void informationUpdate(City City) throws Exception;
	
}
