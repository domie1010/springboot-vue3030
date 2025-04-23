package com.yjkj.framework.rbac.housebase.service.impl;

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
import com.yjkj.framework.rbac.housebase.model.HouseBase;
import com.yjkj.framework.rbac.housebase.service.inte.HouseBaseService;

@Service
public class HouseBaseServiceImpl extends BaseService implements HouseBaseService {

	
	@Override
	public Pager informationLoad(Pager pager,HouseBase HouseBase,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("houseBase", HouseBase);
		List<HouseBase> list = this.houseBaseDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(HouseBase));
		return pager;
	}

	@Override
	public List<HouseBase> informationLoadAll(HouseBase HouseBase) throws Exception {
		List<HouseBase> list = this.houseBaseDao.informationLoadAll(HouseBase);
		return list;
	}
	

	@Override
	public Integer count(HouseBase HouseBase) throws Exception {
		Integer count = this.houseBaseDao.count(HouseBase);
		return count;
	}

	@Override
	public HouseBase informationLoadOne(HouseBase HouseBase) throws Exception {
			HouseBase = this.houseBaseDao.informationLoadOne(HouseBase);
		return HouseBase;
	}

	@Override
	public void informationDelete(HouseBase HouseBase) throws Exception {
			this.houseBaseDao.informationDelete(HouseBase);

	}

	
	@Override
	public void informationAdd(HouseBase HouseBase,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception {
			Map<String, String> map = OperaFile.uploadFile(multipartFiles, null, request);
			String url = map.get("name");
			HouseBase.setUrl(url);
			HouseBase.setId(Regular.createId());
			HouseBase.setCreatetime(CreatDate.getDate());
			this.houseBaseDao.informationAdd(HouseBase);

	}

	@Override
	public void informationUpade(HouseBase HouseBase,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception {
		if(!multipartFiles[0].isEmpty()) {
			Map<String, String> map = OperaFile.uploadFile(multipartFiles, null, request);
			String url = map.get("name");
			HouseBase.setUrl(url);
		}
			this.houseBaseDao.informationUpdate(HouseBase);

	}
	
	@Override
	public void videoAdd(HouseBase HouseBase,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception {
			Map<String, String> map = OperaFile.uploadFile(multipartFiles, null, request);
			String url = map.get("name");
			HouseBase.setVideo(url);
			this.houseBaseDao.informationUpdate(HouseBase);

	}

	

}
