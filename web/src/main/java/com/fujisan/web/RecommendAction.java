package com.fujisan.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujisan.api.ActivityDetail;
import com.fujisan.api.Response;
import com.fujisan.api.service.ActivityService;
import com.fujisan.api.service.asserts.exception.AssertException;
import com.fujisan.model.BaseModel;
import com.fujisan.model.ActivityModel;
import com.fujisan.web.login.NeedLogin;
import com.fujisan.web.login.RequestContextManager;
import com.google.common.collect.Lists;

/**
 * 推荐action
 * 
 * @author siyaomin
 *
 */
@Controller
public class RecommendAction {
	private static final Logger log = Logger.getLogger(RecommendAction.class);
	@Autowired
	private ActivityService lightUpService;
	
	@RequestMapping(value = "/recommend/list", method = RequestMethod.POST)
	@NeedLogin
	public @ResponseBody Response<Page<ActivityDetail>> list() {
		log.info("[scope] list :" + RequestContextManager.current().getUserModel().getName());
		Response<Page<ActivityDetail>> result = new Response<Page<ActivityDetail>>();
		try {
			Pageable pageable=new PageRequest(0, 100);
			
			ActivityModel model=new ActivityModel();
			model.setCreatorId(RequestContextManager.current().getUserModel().getId());
			Page<ActivityDetail> page = lightUpService.findWithDetail(RequestContextManager.current(),new ActivityModel(), null, Direction.DESC, Lists.newArrayList(BaseModel.final_gmtModified), pageable);
			result.setValue(page);
			result.setDesc("加载成功");
		} catch (AssertException e) {
			result.setSuccess(false);
			result.setDesc("加载失败," + e.getMessage() + "。");
			log.error(e.getMessage(), e);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setDesc("加载失败！");
			log.error(e.getMessage(), e);
		}
		
		return result;
	}
}
