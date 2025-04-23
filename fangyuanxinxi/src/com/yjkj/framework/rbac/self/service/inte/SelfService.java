package com.yjkj.framework.rbac.self.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.self.model.Self;

public interface SelfService {

	public Pager informationLoad(Pager pager,Self Self,HttpSession session) throws Exception;
	
	public List<Self> informationLoadAll(Self Self) throws Exception;
	
	public Integer count(Self Self) throws Exception;
	
	public Self informationLoadOne(Self Self) throws Exception;
	
	public void informationDelete(Self Self) throws Exception;
	
	public void informationAdd(Self Self) throws Exception;
	
	public void informationUpade(Self Self) throws Exception;
	
}
