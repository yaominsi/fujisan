package com.fujisan.api.service;

import java.util.List;

import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.model.TopicModel;

/**
 * �������
 * 
 * @author siyaomin
 *
 */
public interface TopicService {
	/**
	 * ��������
	 * 
	 * @param requestContext
	 * @param pathModel
	 * @return
	 */
	public Response<Boolean> save(RequestContext requestContext, TopicModel topicModel);
	/**
	 * ��ȡ�б�
	 * @param requestContext
	 * @return
	 */
	public Response<List<TopicModel>> list(RequestContext requestContext);
	
}
