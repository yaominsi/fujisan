package com.fujisan.api.service;

import java.util.List;

import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.model.TagModel;
import com.fujisan.model.UserModel;
/**
 * �û�����
 * @author siyaomin
 *
 */
public interface UserService {
	/**
	 * ע��
	 * @param requestContext
	 * @param userModel
	 * @return
	 */
	Response<UserModel> registry(RequestContext requestContext,UserModel userModel);
	/**
	 * ����
	 * @param requestContext
	 * @param userModel
	 * @return
	 */
	Response<Boolean> update(RequestContext requestContext,UserModel userModel);
	/**
	 * ���±�ǩ����ӻ��Ƴ�
	 * @param requestContext
	 * @param uesrId
	 * @param tags
	 * @return
	 */
	Response<Boolean> updateTages(RequestContext requestContext,String id,List<TagModel> tags);
	/**
	 * ��ȡ�û���Ϣ
	 * @param requestContext
	 * @param uesrId
	 * @return
	 */
	Response<UserModel> getUserByUserId(RequestContext requestContext,String id);
	/**
	 * ��ȡ�û���Ϣ
	 * @param requestContext//tartgetId,source
	 * @param uesrId
	 * @return
	 */
	Response<UserModel> getSingle(RequestContext requestContext,UserModel userModel);
}
