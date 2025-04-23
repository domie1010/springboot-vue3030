package com.yjkj.framework.rbac.city.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.city.model.City;
import com.yjkj.framework.rbac.city.service.inte.CityService;
@Service
public class CityServiceImpl extends BaseService implements CityService {

	
	@Override
	public Pager informationLoad(Pager pager,City City,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("city", City);
		List<City> list = this.cityDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(City));
		return pager;
	}

	@Override
	public List<City> informationLoadAll(City City) throws Exception {
		List<City> list = this.cityDao.informationLoadAll(City);
		return list;
	}
	

	@Override
	public Integer count(City City) throws Exception {
		Integer count = this.cityDao.count(City);
		return count;
	}

	@Override
	public City informationLoadOne(City City) throws Exception {
			City = this.cityDao.informationLoadOne(City);
		return City;
	}

	@Override
	public void informationDelete(City City) throws Exception {
			this.cityDao.informationDelete(City);

	}

	
	@Override
	public void informationAdd(City City) throws Exception {
			City.setId(Regular.createId());
			City.setCreatetime(CreatDate.getDate());
			this.cityDao.informationAdd(City);

	}

	@Override
	public void informationUpade(City City) throws Exception {
			this.cityDao.informationUpdate(City);

	}
	

}
