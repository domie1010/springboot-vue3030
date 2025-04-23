package com.yjkj.framework.rbac.housebase.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.housebase.model.HouseBase;

public interface HouseBaseDao {

	public List<HouseBase> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<HouseBase> informationLoadAll(HouseBase HouseBase) throws Exception;
	
	public Integer count(HouseBase HouseBase) throws Exception;
	
	public HouseBase informationLoadOne(HouseBase HouseBase) throws Exception;
	
	public void informationDelete(HouseBase HouseBase) throws Exception;
	
	public void informationAdd(HouseBase HouseBase) throws Exception;
	
	public void informationUpdate(HouseBase HouseBase) throws Exception;
	
}
