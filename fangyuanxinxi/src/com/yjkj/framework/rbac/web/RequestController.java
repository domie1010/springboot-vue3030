package com.yjkj.framework.rbac.web;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.rbac.about.model.About;
import com.yjkj.framework.rbac.about.service.inte.AboutService;
import com.yjkj.framework.rbac.area.service.inte.AreaService;
import com.yjkj.framework.rbac.city.service.inte.CityService;
import com.yjkj.framework.rbac.functionInfo.service.impl.FunctionServiceImpl;
import com.yjkj.framework.rbac.functionInfo.service.inte.FunctionService;
import com.yjkj.framework.rbac.house.service.inte.HouseService;
import com.yjkj.framework.rbac.housebase.service.inte.HouseBaseService;
import com.yjkj.framework.rbac.introduce.model.Introduce;
import com.yjkj.framework.rbac.introduce.service.inte.IntroduceService;
import com.yjkj.framework.rbac.notice.model.Notice;
import com.yjkj.framework.rbac.notice.service.inte.NoticeService;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.impl.RoleInfoServiceImpl;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;
import com.yjkj.framework.rbac.self.service.inte.SelfService;
import com.yjkj.framework.rbac.userInfo.service.impl.UserInfoServiceImpl;
import com.yjkj.framework.rbac.userInfo.service.inte.UserInfoService;


@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private RoleInfoService ris = new RoleInfoServiceImpl();

	@Autowired
	private FunctionService fs = new FunctionServiceImpl();
	
	
	@Autowired
	private AboutService aboutService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private IntroduceService introduceService;
	
	@Autowired
	private UserInfoService userInfoService = new UserInfoServiceImpl();
	
	@Autowired
	private HouseService houseService;

	@Autowired
	private CityService cityService;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private SelfService selfService;
	
	@Autowired
	private HouseBaseService houseBaseService;
	

	
	@RequestMapping("/login")
	public String login(HttpSession session) throws IOException {
		return "jsp/Login";
		
	}
	@RequestMapping("/welcome")
	public String welcome(Model model) throws IOException {
		try {
			Introduce introduce = new Introduce();
			Notice notice = new Notice();
			About about = new About();
			introduce.setId("1");
			notice.setId("1");
			about.setId("1");
			model.addAttribute("introduce", this.introduceService.informationLoadOne(introduce));
			model.addAttribute("about", this.aboutService.informationLoadOne(about));
			model.addAttribute("notice", this.noticeService.informationLoadOne(notice));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/foreground/Welcome";
		
	}
	@RequestMapping("/index")
	public String main() {
		return "jsp/iframemain";
	}
	
	@RequestMapping("/passUpdate")
	public String passUpdate(String id,Model model) {
		model.addAttribute("id", id);
		return "jsp/PassUpdate";
	}
	
	@RequestMapping("/password")
	public String password(String id,Model model) {
		return "jsp/foreground/Password";
	}
	@RequestMapping("/right")
	public String index() {
		return "jsp/index";
	}
	
	@RequestMapping("/top")
	public String top() {
		return "jsp/top";
	}
	
	
	
	@RequestMapping("/userAdd")
	public String userAdd(Model model){
		try{
		List<RoleInfo> list = this.ris.query();
		model.addAttribute("role", list);
		model.addAttribute("selfList", this.selfService.informationLoadAll(null));
		}catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/UserAdd";
	}
	
	@RequestMapping("/functionAdd")
	public String functionAdd(){
		return "jsp/FunctionAdd";
	}
	@RequestMapping("/roleAdd")
	public String roleAdd(Model model){
		model.addAttribute("function", this.fs.query());
		return "jsp/RoleAdd";
	}
	
	@RequestMapping("/sign")
	public String sign(Model model){
		return "jsp/foreground/sign";
	}
	
	@RequestMapping("/houseRentAdd")
	public String houseRentAdd(Model model){
		try {
			model.addAttribute("houseBaseList", this.houseBaseService.informationLoadAll(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/RentHouseAdd";
	}
	
	@RequestMapping("/houseBuyAdd")
	public String houseBuyAdd(Model model){
		try {
			model.addAttribute("houseBaseList", this.houseBaseService.informationLoadAll(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/BuyHouseAdd";
	}
	
	@RequestMapping("/cityAdd")
	public String cityAdd(){
		return "jsp/CityAdd";
	}
	
	@RequestMapping("/selfAdd")
	public String selfAdd(){
		return "jsp/SelfAdd";
	}
	
	@RequestMapping("/houseBaseAdd")
	public String houseBaseAdd(){
		return "jsp/HouseBaseAdd";
	}
	
	@RequestMapping("/messageAddFore")
	public String messageAdd(String house_id,Model model){
		model.addAttribute("house_id", house_id);
		return "jsp/foreground/MessageAdd";
	}
	
	@RequestMapping("/videoAdd")
	public String videoAdd(String id,Model model){
		model.addAttribute("id", id);
		return "jsp/VideoAdd";
	}
	
	@RequestMapping("/areaAdd")
	public String areaAdd(Model model){
		try {
			model.addAttribute("cityList", this.cityService.informationLoadAll(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/AreaAdd";
	}
	
	@RequestMapping("/fieldAdd")
	public String fieldAdd(Model model){
		try {
			model.addAttribute("areaList", this.areaService.informationLoadAll(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/FieldAdd";
	}
	
	@RequestMapping("/lookAdd")
	public String lookAdd(Model model){
		try {
		model.addAttribute("userList", this.userInfoService.queryAll());
			model.addAttribute("houseList", this.houseService.informationLoadAll(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/LookAdd";
	}
	
	@RequestMapping("/bargainAdd")
	public String bargainAdd(Model model){
		try {
		model.addAttribute("userList", this.userInfoService.queryAll());
			model.addAttribute("houseList", this.houseService.informationLoadAll(null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/BargainAdd";
	}
	
	
	
	
	
}
