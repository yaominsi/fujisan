package com.fujisan.api.service;

import java.util.List;

import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.model.TagModel;

/**
 * 主题服务
 * 
 * @author siyaomin
 *
 */
public interface TagService {
	/**
	 * 保存主题
	 * 
	 * @param requestContext
	 * @param pathModel
	 * @return
	 */
	public Response<Boolean> save(RequestContext requestContext, TagModel tagModel);
	/**
	 * 获取列表
	 * @param requestContext
	 * @return
	 */
	public Response<List<TagModel>> list(RequestContext requestContext,TagModel tagModel);
	
}
