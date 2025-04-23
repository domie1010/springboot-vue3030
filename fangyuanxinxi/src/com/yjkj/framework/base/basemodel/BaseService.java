package com.yjkj.framework.base.basemodel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjkj.framework.rbac.about.dao.AboutDao;
import com.yjkj.framework.rbac.area.dao.AreaDao;
import com.yjkj.framework.rbac.city.dao.CityDao;
import com.yjkj.framework.rbac.field.dao.FieldDao;
import com.yjkj.framework.rbac.house.dao.HouseDao;
import com.yjkj.framework.rbac.housebase.dao.HouseBaseDao;
import com.yjkj.framework.rbac.introduce.dao.IntroduceDao;
import com.yjkj.framework.rbac.look.dao.LookDao;
import com.yjkj.framework.rbac.message.dao.MessageDao;
import com.yjkj.framework.rbac.notice.dao.NoticeDao;
import com.yjkj.framework.rbac.self.dao.SelfDao;
@Service
public class BaseService {
	
	
	@Autowired
	public AboutDao aboutDao;
	
	@Autowired
	public NoticeDao noticeDao;
	
	@Autowired
	public IntroduceDao introduceDao;
	
	
	@Autowired
	public HouseDao houseDao;
	
	
	@Autowired
	public LookDao lookDao;
	
	@Autowired
	public CityDao cityDao;
	
	@Autowired
	public AreaDao areaDao;
	
	@Autowired
	public FieldDao fieldDao;
	
	@Autowired
	public SelfDao selfDao;
	
	@Autowired
	public MessageDao messageDao;
	
	@Autowired
	public HouseBaseDao houseBaseDao;
	
	
	
	

}
