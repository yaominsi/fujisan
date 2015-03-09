package com.fujisan.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.fujisan.api.ActivityDetail;
import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.model.ActivityModel;

/**
 * 点亮服务
 * 
 * @author siyaomin
 *
 */
public interface ActivityService {
	/**
	 * 点亮线路
	 * 
	 * @param requestContext
	 * @param pathModel
	 * @return
	 */
	public Response<Boolean> save(RequestContext requestContext, ActivityModel lightupModel);

	/**
	 * 关闭线路
	 * 
	 * @param requestContext
	 * @param pathModel
	 * @return
	 */
	public Response<Boolean> lightOff(RequestContext requestContext, String lightupId);


	/**
	 * 列表
	 * 
	 * @param requestContext
	 * @param model
	 * @param properties
	 * @param direction
	 * @param sortProperties
	 * @param pageable
	 * @return
	 */
	public Page<ActivityModel> find(RequestContext requestContext, ActivityModel model, List<String> properties,
			Direction direction, List<String> sortProperties, Pageable pageable);
	/**
	 * 点亮
	 * @param requestContext
	 * @param id
	 * @return
	 */
	public Response<Boolean> lightUp(RequestContext requestContext, String id);

	/**
	 * 活动明细
	 * @param requestContext
	 * @param id
	 * @return
	 */
	public Response<ActivityDetail> detail(RequestContext requestContext, String id);
	public Page<ActivityDetail> findWithDetail(RequestContext current, ActivityModel lightUpModel, List<String> properties,
			Direction direction, List<String> sortProperties, Pageable pageable);
}
