package com.yjkj.framework.rbac.self.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.self.model.Self;
import com.yjkj.framework.rbac.self.service.inte.SelfService;
@Service
public class SelfServiceImpl extends BaseService implements SelfService {

	
	@Override
	public Pager informationLoad(Pager pager,Self Self,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("self", Self);
		List<Self> list = this.selfDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Self));
		return pager;
	}

	@Override
	public List<Self> informationLoadAll(Self Self) throws Exception {
		List<Self> list = this.selfDao.informationLoadAll(Self);
		return list;
	}
	

	@Override
	public Integer count(Self Self) throws Exception {
		Integer count = this.selfDao.count(Self);
		return count;
	}

	@Override
	public Self informationLoadOne(Self Self) throws Exception {
			Self = this.selfDao.informationLoadOne(Self);
		return Self;
	}

	@Override
	public void informationDelete(Self Self) throws Exception {
			this.selfDao.informationDelete(Self);

	}

	
	@Override
	public void informationAdd(Self Self) throws Exception {
			Self.setId(Regular.createId());
			Self.setCreatetime(CreatDate.getDate());
			this.selfDao.informationAdd(Self);

	}

	@Override
	public void informationUpade(Self Self) throws Exception {
			this.selfDao.informationUpdate(Self);

	}
	

}
