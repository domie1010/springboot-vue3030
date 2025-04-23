package com.yjkj.framework.rbac.housebase.web;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.housebase.model.HouseBase;
import com.yjkj.framework.rbac.housebase.service.impl.HouseBaseServiceImpl;
import com.yjkj.framework.rbac.housebase.service.inte.HouseBaseService;

@Controller
@RequestMapping("/houseBase")
public class HouseBaseController {
	
	@Autowired
	private HouseBaseService houseBaseService = new HouseBaseServiceImpl();
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,HouseBase HouseBase,HttpSession session) {
		try {
		pager = this.houseBaseService.informationLoad(pager,HouseBase,session);
		model.addAttribute("houseBaseList", pager);
		return "jsp/HouseBaseTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(HouseBase houseBase,Model model) {
		
		try {
			houseBase = this.houseBaseService.informationLoadOne(houseBase);
			model.addAttribute("houseBase", houseBase);
			return "jsp/HouseBase";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}

	
	@RequestMapping("/informationAdd")
	public String informationAddIn(HouseBase HouseBase,Model model,MultipartFile[] file,HttpSession session,HttpServletRequest request) {
		
		try {
			
			this.houseBaseService.informationAdd(HouseBase,file,session,request);
			return "jsp/Success";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	
	@RequestMapping("/informationDelete")
	public String informationDelete(HouseBase HouseBase,Model model) {
		
		try {
			this.houseBaseService.informationDelete(HouseBase);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(HouseBase HouseBase,Model model,MultipartFile[] file,HttpSession session,HttpServletRequest request) {
		
		try {
			
			this.houseBaseService.informationUpade(HouseBase,file,session,request);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/videoAdd")
	public String videoAdd(HouseBase HouseBase,Model model,MultipartFile[] file,HttpSession session,HttpServletRequest request) {
		
		try {
			
			this.houseBaseService.videoAdd(HouseBase,file,session,request);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
