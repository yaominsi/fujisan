package com.fujisan.api;

import java.io.Serializable;

import com.fujisan.model.LightUpModel;
import com.fujisan.model.ScopeModel;
import com.fujisan.model.UserModel;

/**
 * ���Ϣ
 * 
 * @author siyaomin
 *
 */
public class LightUpDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	// ��Ļ�����Ϣ
	private LightUpModel lightUp;
	//������
	private UserModel fromUser;
	//��������
	private ScopeModel scope;
	
	public LightUpModel getLightUp() {
		return lightUp;
	}

	public void setLightUp(LightUpModel lightUp) {
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
