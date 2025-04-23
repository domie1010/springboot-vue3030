package com.yjkj.framework.rbac.look.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.house.service.inte.HouseService;
import com.yjkj.framework.rbac.look.model.Look;
import com.yjkj.framework.rbac.look.service.impl.LookServiceImpl;
import com.yjkj.framework.rbac.look.service.inte.LookService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;
import com.yjkj.framework.rbac.userInfo.service.impl.UserInfoServiceImpl;
import com.yjkj.framework.rbac.userInfo.service.inte.UserInfoService;

@Controller
@RequestMapping("/look")
public class LookController {
	
	@Autowired
	private LookService lookService = new LookServiceImpl();
	
	@Autowired
	private UserInfoService userInfoService = new UserInfoServiceImpl();
	
	@Autowired
	private HouseService houseService;
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Look Look,HttpSession session) {
		try {
		pager = this.lookService.informationLoad(pager,Look,session);
		model.addAttribute("lookList", pager);
		return "jsp/LookTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadMy")
	public String informationLoadMy(Pager pager,Model model,Look Look,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("Admin");
			Look.setManager_id(userInfo.getId());
		pager = this.lookService.informationLoad(pager,Look,session);
		model.addAttribute("lookList", pager);
		return "jsp/LookTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadFore")
	public String informationLoadFore(Pager pager,Model model,Look Look,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			Look.setUser_id(userInfo.getId());
		pager = this.lookService.informationLoad(pager,Look,session);
		model.addAttribute("lookList", pager);
		return "jsp/foreground/LookTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Look Look,Model model) {
		
		try {
			model.addAttribute("userList", this.userInfoService.queryAll());
			model.addAttribute("houseList", this.houseService.informationLoadAll(null));
			Look = this.lookService.informationLoadOne(Look);
			model.addAttribute("look", Look);
			return "jsp/Look";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAddIn(Look Look,Model model) {
		
		try {
			
			this.lookService.informationAdd(Look);
			return "jsp/Success";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAddFore")
	public String informationAddFore(Look Look,Model model) {
		
		try {
			
			this.lookService.informationAdd(Look);
			return "redirect:informationLoadFore";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Look Look,Model model) {
		
		try {
			this.lookService.informationDelete(Look);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Look Look,Model model) {
		
		try {
			this.lookService.informationUpade(Look);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
