package com.yjkj.framework.rbac.look.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.look.model.Look;

public interface LookDao {

	public List<Look> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Look> informationLoadAll(Look Look) throws Exception;
	
	public Integer count(Look Look) throws Exception;
	
	public Look informationLoadOne(Look Look) throws Exception;
	
	public void informationDelete(Look Look) throws Exception;
	
	public void informationAdd(Look Look) throws Exception;
	
	public void informationUpdate(Look Look) throws Exception;
	
}
