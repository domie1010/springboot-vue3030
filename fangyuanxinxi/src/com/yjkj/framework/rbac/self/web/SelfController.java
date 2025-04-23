package com.yjkj.framework.rbac.self.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.self.model.Self;
import com.yjkj.framework.rbac.self.service.impl.SelfServiceImpl;
import com.yjkj.framework.rbac.self.service.inte.SelfService;

@Controller
@RequestMapping("/self")
public class SelfController {
	
	@Autowired
	private SelfService selfService = new SelfServiceImpl();
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Self Self,HttpSession session) {
		try {
		pager = this.selfService.informationLoad(pager,Self,session);
		model.addAttribute("selfList", pager);
		return "jsp/SelfTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Self Self,Model model) {
		
		try {
			Self = this.selfService.informationLoadOne(Self);
			model.addAttribute("self", Self);
			return "jsp/Self";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	@RequestMapping("/informationAdd")
	public String informationAddIn(Self Self,Model model) {
		
		try {
			
			this.selfService.informationAdd(Self);
			return "jsp/Success";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Self Self,Model model) {
		
		try {
			this.selfService.informationDelete(Self);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Self Self,Model model) {
		
		try {
			this.selfService.informationUpade(Self);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
