package com.yjkj.framework.rbac.field.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.area.service.inte.AreaService;
import com.yjkj.framework.rbac.field.model.Field;
import com.yjkj.framework.rbac.field.service.impl.FieldServiceImpl;
import com.yjkj.framework.rbac.field.service.inte.FieldService;

@Controller
@RequestMapping("/field")
public class FieldController {
	
	@Autowired
	private AreaService areaService;
	@Autowired
	private FieldService fieldService = new FieldServiceImpl();
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Field Field,HttpSession session) {
		try {
		pager = this.fieldService.informationLoad(pager,Field,session);
		model.addAttribute("fieldList", pager);
		return "jsp/FieldTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Field Field,Model model) {
		
		try {
			Field = this.fieldService.informationLoadOne(Field);
			model.addAttribute("areaList", this.areaService.informationLoadAll(null));
			model.addAttribute("field", Field);
			return "jsp/Field";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	@RequestMapping("/informationAdd")
	public String informationAddIn(Field Field,Model model) {
		
		try {
			Field.setId(Regular.createId());
			Field.setCreatetime(CreatDate.getDate());
			this.fieldService.informationAdd(Field);
			return "jsp/Success";
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Field Field,Model model) {
		
		try {
			this.fieldService.informationDelete(Field);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Field Field,HttpSession session,Model model) {
		
		try {
			this.fieldService.informationUpade(Field);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
