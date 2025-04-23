package com.yjkj.framework.rbac.housebase.service.inte;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.housebase.model.HouseBase;

public interface HouseBaseService {

	public Pager informationLoad(Pager pager,HouseBase HouseBase,HttpSession session) throws Exception;
	
	public List<HouseBase> informationLoadAll(HouseBase HouseBase) throws Exception;
	
	public Integer count(HouseBase HouseBase) throws Exception;
	
	public HouseBase informationLoadOne(HouseBase HouseBase) throws Exception;
	
	public void informationDelete(HouseBase HouseBase) throws Exception;
	
	public void informationAdd(HouseBase HouseBase,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception;
	
	public void informationUpade(HouseBase HouseBase,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception;
	
	public void videoAdd(HouseBase HouseBase,MultipartFile[] multipartFiles,HttpSession session,HttpServletRequest request) throws Exception;
	
	
}
