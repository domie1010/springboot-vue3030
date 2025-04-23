package com.yjkj.framework.rbac.city.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.city.model.City;
import com.yjkj.framework.rbac.city.service.impl.CityServiceImpl;
import com.yjkj.framework.rbac.city.service.inte.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	private CityService cityService = new CityServiceImpl();
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,City City,HttpSession session) {
		try {
		pager = this.cityService.informationLoad(pager,City,session);
		model.addAttribute("cityList", pager);
		return "jsp/CityTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(City City,Model model) {
		
		try {
			City = this.cityService.informationLoadOne(City);
			model.addAttribute("city", City);
			return "jsp/City";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	@RequestMapping("/informationAdd")
	public String informationAddIn(City City,Model model) {
		
		try {
			
			this.cityService.informationAdd(City);
			return "jsp/Success";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	
	@RequestMapping("/informationDelete")
	public String informationDelete(City City,Model model) {
		
		try {
			this.cityService.informationDelete(City);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(City City,Model model) {
		
		try {
			this.cityService.informationUpade(City);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
