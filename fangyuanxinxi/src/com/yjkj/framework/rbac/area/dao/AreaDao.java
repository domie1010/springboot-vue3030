package com.yjkj.framework.rbac.area.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.area.model.Area;

public interface AreaDao {

	public List<Area> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Area> informationLoadAll(Area Area) throws Exception;
	
	public Integer count(Area Area) throws Exception;
	
	public Area informationLoadOne(Area Area) throws Exception;
	
	public void informationDelete(Area Area) throws Exception;
	
	public void informationAdd(Area Area) throws Exception;
	
	public void informationUpdate(Area Area) throws Exception;
	
}
