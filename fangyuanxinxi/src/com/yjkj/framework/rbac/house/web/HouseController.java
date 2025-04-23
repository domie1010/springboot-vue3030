package com.yjkj.framework.rbac.house.web;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.house.model.House;
import com.yjkj.framework.rbac.house.service.impl.HouseServiceImpl;
import com.yjkj.framework.rbac.house.service.inte.HouseService;
import com.yjkj.framework.rbac.housebase.service.inte.HouseBaseService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

@Controller
@RequestMapping("/house")
public class HouseController {
	
	@Autowired
	private HouseService houseService = new HouseServiceImpl();
	@Autowired
	private HouseBaseService houseBaseService;
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,House House,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("Admin");
			House.setUser_id(userInfo.getId());
		pager = this.houseService.informationLoad(pager,House,session);
		model.addAttribute("houseList", pager);
		return "jsp/HouseTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadBuy")
	public String informationLoadBuy(Pager pager,Model model,House House,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("Admin");
			House.setUser_id(userInfo.getId());
			House.setTypee("1");
		pager = this.houseService.informationLoad(pager,House,session);
		model.addAttribute("houseList", pager);
		return "jsp/BuyHouseTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	@RequestMapping("/informationLoadRent")
	public String informationLoadRent(Pager pager,Model model,House House,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("Admin");
			House.setUser_id(userInfo.getId());
			House.setTypee("2");
		pager = this.houseService.informationLoad(pager,House,session);
		model.addAttribute("houseList", pager);
		return "jsp/RentHouseTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadForeRent")
	public String informationLoadForeRent(Pager pager,Model model,House House,HttpSession session) {
		try {
			House.setTypee("2");
			House.setShoww("1");
		pager = this.houseService.informationLoad(pager,House,session);
		model.addAttribute("houseList", pager);
		return "jsp/foreground/RentHouseTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadForeGood")
	public String informationLoadForeGood(Pager pager,Model model,House House,HttpSession session) {
		try {
			House.setGood("1");
		pager = this.houseService.informationLoad(pager,House,session);
		model.addAttribute("houseList", pager);
		return "jsp/foreground/GoodHouseTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadForeBuy")
	public String informationLoadFore(Pager pager,Model model,House House,HttpSession session) {
		try {
			House.setTypee("1");
			House.setShoww("1");
		pager = this.houseService.informationLoad(pager,House,session);
		model.addAttribute("houseList", pager);
		return "jsp/foreground/BuyHouseTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(House House,Model model) {
		
		try {
			House = this.houseService.informationLoadOne(House);
			model.addAttribute("house", House);
			return "jsp/House";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneRent")
	public String informationLoadOneRent(House House,Model model) {
		
		try {
			House = this.houseService.informationLoadOne(House);
			model.addAttribute("houseBaseList", this.houseBaseService.informationLoadAll(null));
			model.addAttribute("house", House);
			return "jsp/RentHouse";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneForeRent")
	public String informationLoadOneForeRent(House House,Model model) {
		
		try {
			House = this.houseService.informationLoadOne(House);
			model.addAttribute("house", House);
			return "jsp/foreground/RentHouse";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneBuy")
	public String informationLoadOneBuy(House House,Model model) {
		
		try {
			House = this.houseService.informationLoadOne(House);
			model.addAttribute("houseBaseList", this.houseBaseService.informationLoadAll(null));
			model.addAttribute("house", House);
			return "jsp/BuyHouse";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneForeBuy")
	public String informationLoadOneForeBuy(House House,Model model) {
		
		try {
			House = this.houseService.informationLoadOne(House);
			model.addAttribute("house", House);
			return "jsp/foreground/BuyHouse";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAddIn(House House,Model model,MultipartFile[] file,HttpSession session,HttpServletRequest request) {
		
		try {
			
			this.houseService.informationAdd(House,file,session,request);
			return "jsp/Success";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	
	@RequestMapping("/informationDelete")
	public String informationDelete(House House,Model model) {
		
		try {
			this.houseService.informationDelete(House);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(House House,Model model,MultipartFile[] file,HttpSession session,HttpServletRequest request) {
		
		try {
			
			this.houseService.informationUpade(House,file,session,request);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdateStatus")
	public String informationUpdateStatus(House House,Model model,HttpSession session) {
		
		try {
			
			this.houseService.informationUpadeStatus(House,session);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
		
	}
	
}
