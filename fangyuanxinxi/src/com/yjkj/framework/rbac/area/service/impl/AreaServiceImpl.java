package com.yjkj.framework.rbac.area.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.area.model.Area;
import com.yjkj.framework.rbac.area.service.inte.AreaService;
@Service
public class AreaServiceImpl extends BaseService implements AreaService {

	
	@Override
	public Pager informationLoad(Pager pager,Area Area,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("area", Area);
		List<Area> list = this.areaDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Area));
		return pager;
	}

	@Override
	public List<Area> informationLoadAll(Area Area) throws Exception {
		List<Area> list = this.areaDao.informationLoadAll(Area);
		return list;
	}
	

	@Override
	public Integer count(Area Area) throws Exception {
		Integer count = this.areaDao.count(Area);
		return count;
	}

	@Override
	public Area informationLoadOne(Area Area) throws Exception {
			Area = this.areaDao.informationLoadOne(Area);
		return Area;
	}

	@Override
	public void informationDelete(Area Area) throws Exception {
			this.areaDao.informationDelete(Area);

	}

	
	@Override
	public void informationAdd(Area Area) throws Exception {
		Area.setId(Regular.createId());
		Area.setCreatetime(CreatDate.getDate());
			this.areaDao.informationAdd(Area);

	}

	@Override
	public void informationUpade(Area Area) throws Exception {
			this.areaDao.informationUpdate(Area);

	}
	

}
