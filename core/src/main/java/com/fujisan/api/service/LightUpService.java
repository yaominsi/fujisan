package com.fujisan.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.fujisan.api.LightUpDetail;
import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.model.LightUpModel;

/**
 * ��������
 * 
 * @author siyaomin
 *
 */
public interface LightUpService {
	/**
	 * ������·
	 * 
	 * @param requestContext
	 * @param pathModel
	 * @return
	 */
	public Response<Boolean> save(RequestContext requestContext, LightUpModel lightupModel);

	/**
	 * �ر���·
	 * 
	 * @param requestContext
	 * @param pathModel
	 * @return
	 */
	public Response<Boolean> lightOff(RequestContext requestContext, String lightupId);


	/**
	 * �б�
	 * 
	 * @param requestContext
	 * @param model
	 * @param properties
	 * @param direction
	 * @param sortProperties
	 * @param pageable
	 * @return
	 */
	public Page<LightUpModel> find(RequestContext requestContext, LightUpModel model, List<String> properties,
			Direction direction, List<String> sortProperties, Pageable pageable);
	/**
	 * ����
	 * @param requestContext
	 * @param id
	 * @return
	 */
	public Response<Boolean> lightUp(RequestContext requestContext, String id);

	/**
	 * ���ϸ
	 * @param requestContext
	 * @param id
	 * @return
	 */
	public Response<LightUpDetail> detail(RequestContext requestContext, String id);
	public Page<LightUpDetail> findWithDetail(RequestContext current, LightUpModel lightUpModel, List<String> properties,
			Direction direction, List<String> sortProperties, Pageable pageable);
}