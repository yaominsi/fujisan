package com.fujisan.api;

import java.io.Serializable;

import com.fujisan.model.LightUpModel;
import com.fujisan.model.OrderModel;
import com.fujisan.model.ScopeModel;
import com.fujisan.model.UserModel;
/**
 * ������ϸ
 * @author siyaomin
 *
 */
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	//����Ԫ����
	private OrderModel order;
	//������
	private UserModel fromUser;
	//������
	private UserModel toUser;
	//������Ӧ�Ļ��Ϣ
	private LightUpModel lightUp;
	//��������
	private ScopeModel scope;
	public OrderModel getOrder() {
		return order;
	}
	public void setOrder(OrderModel order) {
		this.order = order;
	}
	public UserModel getFromUser() {
		return fromUser;
	}
	public void setFromUser(UserModel fromUser) {
		this.fromUser = fromUser;
	}
	public UserModel getToUser() {
		return toUser;
	}
	public void setToUser(UserModel toUser) {
		this.toUser = toUser;
	}
	public LightUpModel getLightUp() {
		return lightUp;
	}
	public void setLightUp(LightUpModel lightUp) {
		this.lightUp = lightUp;
	}
	public ScopeModel getScope() {
		return scope;
	}
	public void setScope(ScopeModel scope) {
		this.scope = scope;
	}
	
	
}
