package com.fujisan.api.service;

import java.util.List;

import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.model.TagModel;

/**
 * �������
 * 
 * @author siyaomin
 *
 */
public interface TagService {
	/**
	 * ��������
	 * 
	 * @param requestContext
	 * @param pathModel
	 * @return
	 */
	public Response<Boolean> save(RequestContext requestContext, TagModel tagModel);
	/**
	 * ��ȡ�б�
	 * @param requestContext
	 * @return
	 */
	public Response<List<TagModel>> list(RequestContext requestContext,TagModel tagModel);
	
}
