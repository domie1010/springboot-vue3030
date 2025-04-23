package com.yjkj.framework.rbac.area.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.area.model.Area;
import com.yjkj.framework.rbac.area.service.impl.AreaServiceImpl;
import com.yjkj.framework.rbac.area.service.inte.AreaService;
import com.yjkj.framework.rbac.city.service.inte.CityService;

@Controller
@RequestMapping("/area")
public class AreaController {
	
	@Autowired
	private CityService cityService;
	@Autowired
	private AreaService areaService = new AreaServiceImpl();
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Area Area,HttpSession session) {
		try {
		pager = this.areaService.informationLoad(pager,Area,session);
		model.addAttribute("areaList", pager);
		return "jsp/AreaTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Area Area,Model model) {
		
		try {
			Area = this.areaService.informationLoadOne(Area);
			model.addAttribute("cityList", this.cityService.informationLoadAll(null));
			model.addAttribute("area", Area);
			return "jsp/Area";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	@RequestMapping("/informationAdd")
	public String informationAddIn(Area Area,Model model) {
		
		try {
			
			this.areaService.informationAdd(Area);
			return "jsp/Success";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Area Area,Model model) {
		
		try {
			this.areaService.informationDelete(Area);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Area Area,Model model) {
		
		try {
			this.areaService.informationUpade(Area);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
