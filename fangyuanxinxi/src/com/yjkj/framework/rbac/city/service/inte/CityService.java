package com.yjkj.framework.rbac.city.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;


import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.city.model.City;

public interface CityService {

	public Pager informationLoad(Pager pager,City City,HttpSession session) throws Exception;
	
	public List<City> informationLoadAll(City City) throws Exception;
	
	public Integer count(City City) throws Exception;
	
	public City informationLoadOne(City City) throws Exception;
	
	public void informationDelete(City City) throws Exception;
	
	public void informationAdd(City City) throws Exception;
	
	public void informationUpade(City City) throws Exception;
	
}
