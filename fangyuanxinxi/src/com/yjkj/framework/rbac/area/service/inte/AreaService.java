package com.yjkj.framework.rbac.area.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.area.model.Area;

public interface AreaService {

	public Pager informationLoad(Pager pager,Area Area,HttpSession session) throws Exception;
	
	public List<Area> informationLoadAll(Area Area) throws Exception;
	
	public Integer count(Area Area) throws Exception;
	
	public Area informationLoadOne(Area Area) throws Exception;
	
	public void informationDelete(Area Area) throws Exception;
	
	public void informationAdd(Area Area) throws Exception;
	
	public void informationUpade(Area Area) throws Exception;
	
}
