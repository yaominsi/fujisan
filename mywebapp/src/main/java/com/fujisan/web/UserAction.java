package com.fujisan.web;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.api.service.UserService;
import com.fujisan.api.service.asserts.exception.AssertException;
import com.fujisan.model.UserModel;
import com.fujisan.web.login.CookieAbout;
import com.fujisan.web.login.NeedLogin;
import com.fujisan.web.login.RequestContextManager;

/**
 * �û�action����¼ע��
 * 
 * @author siyaomin
 *
 */
@Controller
public class UserAction {
	private static final Logger log = Logger.getLogger(UserAction.class);
	@Autowired
	private UserService userService;
	@Autowired
	private CookieAbout cookieAbout;

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public @ResponseBody Response<UserModel> login(@RequestBody UserModel userModel,
			HttpServletResponse response) {
		Response<UserModel> result = new Response<UserModel>();
		try {
			userModel.setSource("alibaba");
			Response<UserModel> user = userService.getSingle(RequestContextManager.current(), userModel);
			if (user.getValue() == null) {
				//TODO δ���û����Զ�ע�ᣬĬ������Ϊ123
//				result.setSuccess(false);
//				result.setDesc("δ�ҵ��û���Ϣ");
				//ע��
				userModel.setTargetId(userModel.getTargetId());
				userModel.setSource("alibaba");
				userModel.setName(userModel.getTargetId());
				userModel.setNickName(userModel.getTargetId());
				userModel.setPlateNo("��A68959");
				userModel.setSignature("���г�");
				userModel.setAllowInvited("y");
				RequestContext cur = RequestContextManager.current();
				cur.getUserModel().setName(userModel.getTargetId());
				Response<UserModel> resp = userService.registry(RequestContextManager.current(), userModel);
				cookieAbout.flushCookies(response, resp.getValue());
				result.setValue(resp.getValue());
				result.setDesc("�Զ�ע��ɹ�");
				result.setSuccess(true);
			} else if (userModel.getPasswd().equals(user.getValue().getPasswd())) {
				// setupwith cookie
				cookieAbout.flushCookies(response, user.getValue());
				return user;
			} else {
				result.setSuccess(false);
				result.setDesc("���벻��ȷ��");
			}
		} catch (AssertException e) {
			log.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setDesc(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			result.setSuccess(false);
			result.setDesc("��¼ʧ�ܣ�");
		}
		return result;
	}

	/**
	 * ע��
	 * 
	 * @param userModel
	 * @param response
	 * @return
	 */
	
	@RequestMapping(value = "/user/reg", method = RequestMethod.POST)
	public @ResponseBody Response<UserModel> reg(@ModelAttribute("form") UserModel userModel,
			HttpServletResponse response) {
		
		Response<UserModel> result = new Response<UserModel>();
		Response<UserModel> user = userService.registry(RequestContextManager.current(), userModel);
		if (user.isSuccess()) {
			cookieAbout.flushCookies(response, userModel);
			return user;
		} else {
			result.setDesc(user.getDesc());
			result.setSuccess(false);
			return result;
		}
	}
	/**
	 * load
	 * 
	 * @param userModel
	 * @param response
	 * @return
	 */
	@NeedLogin
	@RequestMapping(value = "/user/load", method = RequestMethod.POST)
	public @ResponseBody Response<UserModel> load(@RequestBody UserModel userModel,
			HttpServletResponse response) {

		Response<UserModel> result = new Response<UserModel>();
		result.setValue(RequestContextManager.current().getUserModel());
		return result;
	}

}
