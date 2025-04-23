package com.yjkj.framework.rbac.look.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.look.model.Look;

public interface LookService {

	public Pager informationLoad(Pager pager,Look Look,HttpSession session) throws Exception;
	
	public List<Look> informationLoadAll(Look Look) throws Exception;
	
	public Integer count(Look Look) throws Exception;
	
	public Look informationLoadOne(Look Look) throws Exception;
	
	public void informationDelete(Look Look) throws Exception;
	
	public void informationAdd(Look Look) throws Exception;
	
	public void informationUpade(Look Look) throws Exception;
	
}
