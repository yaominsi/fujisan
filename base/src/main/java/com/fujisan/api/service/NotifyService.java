package com.fujisan.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.fujisan.api.NotifyDetail;
import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.common.NotifyStatusEnum;
import com.fujisan.model.NotifyModel;

/**
 * ֪ͨ���ķ��������֪ͨ�ķ����봦��
 * 
 * @author siyaomin
 *
 */
public interface NotifyService {
	/**
	 * ����
	 * 
	 * @param notifyModel
	 * @return
	 */
	public abstract Response<Boolean> create(RequestContext requestContext, NotifyModel notifyModel);

	/**
	 * ���Ϊ�Ѵ���
	 * 
	 * @param notifyModel
	 * @return
	 */
	public abstract Response<Boolean> read(RequestContext requestContext, String id);

	/**
	 * ��ӵ�TODO
	 * 
	 * @param requestContext
	 * @param Id
	 * @return
	 */
	public abstract Response<Boolean> addToDo(RequestContext requestContext, String Id);
	/**
	 * ɾ��
	 * @param requestContext
	 * @param Id
	 * @return
	 */
	public abstract Response<Boolean> finish(RequestContext requestContext, String Id);
	/**
	 * ��ѯ
	 * @param requestContext
	 * @param model
	 * @param properties
	 * @param direction
	 * @param sortProperties
	 * @param pageable
	 * @return
	 */
	public Page<NotifyModel> find(RequestContext requestContext,NotifyModel model, List<String> properties, Direction direction, List<String> sortProperties,Pageable pageable);
	/**
	 * ��ϸ��Ϣ
	 * @param current
	 * @param id
	 * @return
	 */
	public abstract Response<NotifyDetail> detail(RequestContext current, String id);
	/**
	 * ����ͳ��
	 * @param current
	 * @param toUserId
	 * @param status
	 * @return
	 */
	public abstract Response<Map<NotifyStatusEnum, Long>> counts(RequestContext current, String toUserId,List<NotifyStatusEnum> status);
}
