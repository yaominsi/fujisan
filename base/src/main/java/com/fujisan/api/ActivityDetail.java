package com.fujisan.api;

import java.io.Serializable;

import com.fujisan.model.ActivityModel;
import com.fujisan.model.ScopeModel;
import com.fujisan.model.UserModel;

/**
 * 活动信息
 * 
 * @author siyaomin
 *
 */
public class ActivityDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	// 活动的基础信息
	private ActivityModel lightUp;
	//发起人
	private UserModel fromUser;
	//发起区域
	private ScopeModel scope;
	
	public ActivityModel getLightUp() {
		return lightUp;
	}

	public void setLightUp(ActivityModel lightUp) {
		this.lightUp = lightUp;
	}

	public UserModel getFromUser() {
		return fromUser;
	}

	public void setFromUser(UserModel fromUser) {
		this.fromUser = fromUser;
	}

	public ScopeModel getScope() {
		return scope;
	}

	public void setScope(ScopeModel scope) {
		this.scope = scope;
	}
}
