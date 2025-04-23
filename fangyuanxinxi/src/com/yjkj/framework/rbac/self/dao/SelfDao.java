package com.yjkj.framework.rbac.self.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.self.model.Self;

public interface SelfDao {

	public List<Self> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Self> informationLoadAll(Self Self) throws Exception;
	
	public Integer count(Self Self) throws Exception;
	
	public Self informationLoadOne(Self Self) throws Exception;
	
	public void informationDelete(Self Self) throws Exception;
	
	public void informationAdd(Self Self) throws Exception;
	
	public void informationUpdate(Self Self) throws Exception;
	
}
