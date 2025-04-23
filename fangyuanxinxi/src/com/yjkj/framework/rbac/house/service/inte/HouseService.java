package com.yjkj.framework.rbac.house.service.inte;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.house.model.House;

public interface HouseService {

	public Pager informationLoad(Pager pager,House House,HttpSession session) throws Exception;
	
	public List<House> informationLoadAll(House House) throws Exception;
	
	public Integer count(House House) throws Exception;
	
	public House informationLoadOne(House House) throws Exception;
	
	public void informationDelete(House House) throws Exception;
	
	public void informationAdd(House House,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception;
	
	public void informationUpade(House House,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception;
	
	public void informationUpadeStatus(House House,HttpSession session) throws Exception;
	
}
