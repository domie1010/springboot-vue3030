package com.yjkj.framework.rbac.message.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.message.model.Message;
import com.yjkj.framework.rbac.message.service.inte.MessageService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService MessageService;
	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Message Message,HttpSession session) {
		try {
		UserInfo userInfo = (UserInfo) session.getAttribute("Admin");
		Message.setManager_id(userInfo.getId());
		pager = this.MessageService.informationLoad(pager,Message,session);
		model.addAttribute("messageList", pager);
		return "jsp/MessageTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadFore")
	public String informationLoadFore(Pager pager,Model model,Message Message,HttpSession session) {
		try {
		UserInfo userInfo = (UserInfo) session.getAttribute("User");
		Message.setUser_id(userInfo.getId());
		pager = this.MessageService.informationLoad(pager,Message,session);
		model.addAttribute("messageList", pager);
		return "jsp/foreground/MessageTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("mess", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Message Message,Model model) {
		
		try {
			Message = this.MessageService.informationLoadOne(Message);
			model.addAttribute("message", Message);
			return "jsp/Message";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationLoadOneFore")
	public String informationLoadOneFore(Message Message,Model model) {
		
		try {
			Message = this.MessageService.informationLoadOne(Message);
			model.addAttribute("message", Message);
			return "jsp/foreground/Message";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Message Message,Model model) {
		
		try {
			
			this.MessageService.informationAdd(Message);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	@RequestMapping("/informationAddFore")
	public String informationAddFore(Message Message,Model model) {
		
		try {
			
			this.MessageService.informationAdd(Message);
			return "redirect:informationLoadFore";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	@RequestMapping("/informationDelete")
	public String informationDelete(Message Message,Model model) {
		
		try {
			this.MessageService.informationDelete(Message);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Message Message,Model model) {
		
		try {
			this.MessageService.informationUpade(Message);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
