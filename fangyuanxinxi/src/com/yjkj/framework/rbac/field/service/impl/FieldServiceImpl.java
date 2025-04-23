package com.yjkj.framework.rbac.field.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.field.model.Field;
import com.yjkj.framework.rbac.field.service.inte.FieldService;
@Service
public class FieldServiceImpl extends BaseService implements FieldService {

	
	@Override
	public Pager informationLoad(Pager pager,Field Field,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("field", Field);
		List<Field> list = this.fieldDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Field));
		return pager;
	}

	@Override
	public List<Field> informationLoadAll(Field Field) throws Exception {
		List<Field> list = this.fieldDao.informationLoadAll(Field);
		return list;
	}
	

	@Override
	public Integer count(Field Field) throws Exception {
		Integer count = this.fieldDao.count(Field);
		return count;
	}

	@Override
	public Field informationLoadOne(Field Field) throws Exception {
			
			Field = this.fieldDao.informationLoadOne(Field);
		return Field;
	}

	@Override
	public void informationDelete(Field Field) throws Exception {
			this.fieldDao.informationDelete(Field);

	}

	
	@Override
	public void informationAdd(Field Field) throws Exception {
			this.fieldDao.informationAdd(Field);

	}

	@Override
	public void informationUpade(Field Field) throws Exception {
		
			this.fieldDao.informationUpdate(Field);

	}
	

}
