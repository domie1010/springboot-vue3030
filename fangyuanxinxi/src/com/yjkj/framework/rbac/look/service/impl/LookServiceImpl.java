package com.yjkj.framework.rbac.look.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.look.model.Look;
import com.yjkj.framework.rbac.look.service.inte.LookService;
@Service
public class LookServiceImpl extends BaseService implements LookService {

	
	@Override
	public Pager informationLoad(Pager pager,Look Look,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("look", Look);
		List<Look> list = this.lookDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Look));
		return pager;
	}

	@Override
	public List<Look> informationLoadAll(Look Look) throws Exception {
		List<Look> list = this.lookDao.informationLoadAll(Look);
		return list;
	}
	

	@Override
	public Integer count(Look Look) throws Exception {
		Integer count = this.lookDao.count(Look);
		return count;
	}

	@Override
	public Look informationLoadOne(Look Look) throws Exception {
			Look = this.lookDao.informationLoadOne(Look);
		return Look;
	}

	@Override
	public void informationDelete(Look Look) throws Exception {
			this.lookDao.informationDelete(Look);

	}

	
	@Override
	public void informationAdd(Look Look) throws Exception {
			Look.setId(Regular.createId());
			Look.setCreatetime(CreatDate.getDate());
			this.lookDao.informationAdd(Look);

	}

	@Override
	public void informationUpade(Look Look) throws Exception {
			this.lookDao.informationUpdate(Look);

	}
	

}
