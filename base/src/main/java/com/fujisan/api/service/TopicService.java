package com.fujisan.api.service;

import java.util.List;

import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.model.TopicModel;

/**
 * 主题服务
 * 
 * @author siyaomin
 *
 */
public interface TopicService {
	/**
	 * 保存主题
	 * 
	 * @param requestContext
	 * @param pathModel
	 * @return
	 */
	public Response<Boolean> save(RequestContext requestContext, TopicModel topicModel);
	/**
	 * 获取列表
	 * @param requestContext
	 * @return
	 */
	public Response<List<TopicModel>> list(RequestContext requestContext);
	
}
