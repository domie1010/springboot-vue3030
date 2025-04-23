package com.yjkj.framework.rbac.house.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.base.regular.file.OperaFile;
import com.yjkj.framework.rbac.house.model.House;
import com.yjkj.framework.rbac.house.service.inte.HouseService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

@Service
public class HouseServiceImpl extends BaseService implements HouseService {

	
	@Override
	public Pager informationLoad(Pager pager,House House,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("house", House);
		List<House> list = this.houseDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(House));
		return pager;
	}

	@Override
	public List<House> informationLoadAll(House House) throws Exception {
		List<House> list = this.houseDao.informationLoadAll(House);
		return list;
	}
	

	@Override
	public Integer count(House House) throws Exception {
		Integer count = this.houseDao.count(House);
		return count;
	}

	@Override
	public House informationLoadOne(House House) throws Exception {
			House = this.houseDao.informationLoadOne(House);
		return House;
	}

	@Override
	public void informationDelete(House House) throws Exception {
			this.houseDao.informationDelete(House);

	}

	
	@Override
	public void informationAdd(House House,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception {
			Map<String, String> map = OperaFile.uploadFile(multipartFiles, null, request);
			UserInfo userInfo = (UserInfo) session.getAttribute("Admin");
			House.setUser_id(userInfo.getId());
			Integer num = this.houseDao.count(House);
			if(userInfo.getSelf().getHouse_num()<=num) {
				throw new RuntimeException("您当前房源库存数已超过所在星级限制");
			}
			String url = map.get("name");
			House.setUrl(url);
			House.setId(Regular.createId());
			House.setCreatetime(CreatDate.getDate());
			this.houseDao.informationAdd(House);

	}

	@Override
	public void informationUpade(House House,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception {
		if(!multipartFiles[0].isEmpty()) {
			Map<String, String> map = OperaFile.uploadFile(multipartFiles, null, request);
			String url = map.get("name");
			House.setUrl(url);
		}
			this.houseDao.informationUpdate(House);

	}

	@Override
	public void informationUpadeStatus(House House,HttpSession session) throws Exception {
		UserInfo userInfo = (UserInfo) session.getAttribute("Admin");
		House.setUser_id(userInfo.getId());
		Integer showNum = this.houseDao.countCheckShow(House);
		Integer goodNum = this.houseDao.countCheckGood(House);
		if(House.getShoww()!=null) {
			if(userInfo.getSelf().getShow_num()<=showNum&&House.getShoww().equals("1")) {
				throw new RuntimeException("您当前展示房源数已超过所在星级限制");
			}
		}
		if(House.getGood()!=null) {
			if(userInfo.getSelf().getGood_house_num()<=goodNum&&House.getGood().equals("1")) {
				throw new RuntimeException("您当前精品房源数已超过所在星级限制");
			}
		}
		this.houseDao.informationUpdate(House);
		
	}
	

}
