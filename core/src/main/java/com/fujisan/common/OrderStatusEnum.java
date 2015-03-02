package com.fujisan.common;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * �˿�ԤԼ����״̬
 * @author siyaomin
 *
 */
public enum OrderStatusEnum {
	created, 	//����
	read, 		//�Ѷ�
	accept, 	//����
	rejected, 	//�ܾ�
	gotOn, 		//���ϳ�
	cancel, 	//ȡ��
	finish;		//�˿���Ტ���
	public static Map<OrderStatusEnum,String> getMap(){
		Map<OrderStatusEnum,String> map=new HashMap<OrderStatusEnum, String>();
		map.put(created, "����");
		map.put(read, "�Ѷ�");
		map.put(accept, "����");
		map.put(rejected, "�ܾ�");
		map.put(gotOn, "������..");
		map.put(cancel, "ȡ��");
		map.put(finish, "���");
		return Collections.unmodifiableMap(map);
	}
}
