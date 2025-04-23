package com.yjkj.framework.rbac.field.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.field.model.Field;

public interface FieldService {

	public Pager informationLoad(Pager pager,Field Field,HttpSession session) throws Exception;
	
	public List<Field> informationLoadAll(Field Field) throws Exception;
	
	public Integer count(Field Field) throws Exception;
	
	public Field informationLoadOne(Field Field) throws Exception;
	
	public void informationDelete(Field Field) throws Exception;
	
	public void informationAdd(Field Field) throws Exception;
	
	public void informationUpade(Field Field) throws Exception;
	
}
