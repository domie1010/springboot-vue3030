package com.yjkj.framework.rbac.house.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.house.model.House;

public interface HouseDao {

	public List<House> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<House> informationLoadAll(House House) throws Exception;
	
	public Integer count(House House) throws Exception;
	
	public Integer countCheckShow(House House) throws Exception;
	
	public Integer countCheckGood(House House) throws Exception;
	
	public House informationLoadOne(House House) throws Exception;
	
	public void informationDelete(House House) throws Exception;
	
	public void informationAdd(House House) throws Exception;
	
	public void informationUpdate(House House) throws Exception;
	
}
