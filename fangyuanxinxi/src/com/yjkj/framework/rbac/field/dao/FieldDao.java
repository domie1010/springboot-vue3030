package com.yjkj.framework.rbac.field.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.field.model.Field;

public interface FieldDao {

	public List<Field> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Field> informationLoadAll(Field Field) throws Exception;
	
	public Integer count(Field Field) throws Exception;
	
	public Field informationLoadOne(Field Field) throws Exception;
	
	public void informationDelete(Field Field) throws Exception;
	
	public void informationAdd(Field Field) throws Exception;
	
	public void informationUpdate(Field Field) throws Exception;
	
}
