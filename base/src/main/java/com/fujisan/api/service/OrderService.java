package com.fujisan.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.fujisan.api.OrderDetail;
import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.model.OrderModel;

/**
 * �˿�ԤԼ
 * ˾�����ܶ�������
 * @author siyaomin
 *
 */
public interface OrderService {
	/**
	 * ������ԤԼ
	 * @param requestContext
	 * @param rideOrderModel
	 * @return
	 */
	public Response<Boolean> create(RequestContext requestContext,OrderModel orderModel);
	/**
	 * ����ԤԼ
	 * @param requestContext
	 * @param rideOrderModel
	 * @return
	 */
	public Response<Boolean> accept(RequestContext requestContext,String id,String note);
	//�ϳ����finish
	/**
	 * ���ԤԼ���ϳ������ԤԼ
	 * @param requestContext
	 * @param rideOrderModel
	 * @return
	 */
	public Response<Boolean> finish(RequestContext requestContext,OrderModel orderModel);
	/**
	 * ˾���ܾ��ͻ���ԤԼ����
	 * @param requestContext
	 * @param rideOrderModel
	 * @return
	 */
	public Response<Boolean> reject(RequestContext requestContext,String is,String note);
	/**
	 * ȡ��
	 * @param requestContext
	 * @param orderModel
	 */
	public Response<Boolean> cancel(RequestContext requestContext,String id,String note);
	/**
	 * ��ҳ��ѯ
	 * @param requestContext
	 * @param model
	 * @param properties
	 * @param direction
	 * @param sortProperties
	 * @param pageable
	 * @return
	 */
	public Page<OrderModel> find(RequestContext requestContext,OrderModel model, List<String> properties, Direction direction, List<String> sortProperties,Pageable pageable);
	/**
	 * ������ϸ
	 * @param requestContext
	 * @param id
	 * @return
	 */
	public Response<OrderDetail> detail(RequestContext requestContext, String id);
	
}
