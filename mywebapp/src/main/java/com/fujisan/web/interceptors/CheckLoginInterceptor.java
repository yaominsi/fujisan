package com.fujisan.web.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fujisan.api.Response;
import com.fujisan.common.ResponseCodeEnum;
import com.fujisan.web.login.AjaxUtil;
import com.fujisan.web.login.CookieAbout;
import com.fujisan.web.login.NeedLogin;
import com.fujisan.web.login.RequestContextManager;
/**
 * ��֤�Ƿ��¼���߼�
 * @author siyaomin
 *
 */
@Component
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private CookieAbout cookieAbout;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//���������ĵ���Ϣ
		RequestContextManager.init(null);
		HandlerMethod hm = (HandlerMethod) handler;
		NeedLogin need = hm.getMethod().getAnnotation(NeedLogin.class);
		if(need==null){
			need= hm.getMethod().getDeclaringClass().getAnnotation(NeedLogin.class);
		}
		if (need==null) {
			return super.preHandle(request, response, handler);
		}
		
		Cookie[] cookies = request.getCookies();
		if (cookies!=null&&cookies.length>0) {
			//TODO ��֤cookie��Ч��
			boolean isLogin = cookieAbout.setupRequestContext(cookies, RequestContextManager.current());
			if(!isLogin){
				if (AjaxUtil.isAjax(request)) {
					AjaxUtil.flush(response, new Response<Boolean>(false,ResponseCodeEnum.not_login,"���ȵ�¼��"));
				}else{
					response.sendRedirect("/login.jsp");
				}
				return false;
			}else{
				request.setAttribute("userModel", RequestContextManager.current().getUserModel());
				//һֱ�з��ʾͱ���cookie����
				cookieAbout.flushCookies(response, RequestContextManager.current().getUserModel());
			}
		}else{
			//ת����¼ҳ��
		}
		//
		return super.preHandle(request, response, handler);
	}
}
