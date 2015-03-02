package com.fujisan.api.service.asserts;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.fujisan.api.RequestContext;
import com.fujisan.api.service.asserts.exception.AssertException;
import com.fujisan.common.BeanHelper;
import com.fujisan.common.BooleanAbout;
import com.fujisan.common.BusiTypeEnum;
import com.fujisan.common.NumberAbout;
import com.fujisan.common.OperateTypeEnum;
import com.fujisan.common.OrderStatusEnum;
import com.fujisan.common.TimeUtil;
import com.fujisan.model.BaseModel;
import com.fujisan.model.LightUpModel;
import com.fujisan.model.OrderModel;
import com.fujisan.model.UserModel;
import com.fujisan.repository.LightUpRepository;
import com.fujisan.repository.OrderRepository;
import com.fujisan.repository.UserRepository;
import com.google.common.collect.Lists;

/**
 * ����Ķ���
 * 
 * @author siyaomin
 *
 */
@Component("orderAssert")
public class OrderAssert implements DomainServiceAssert<OrderModel> {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private LightUpRepository lightUpRepository;
	private final BusiTypeEnum scene=BusiTypeEnum.order;
	/**
	 * ���� ��֤
	 */
	public void checkParams(RequestContext requestContext, OrderModel model, BusiTypeEnum busiTypeEnum) {
		Assert.notNull(model);
		if (BusiTypeEnum.create.equals(busiTypeEnum)) {
			String result = BeanHelper.checkFieldsNotEmpty(model, model.needFieldsForCreate());
			if (StringUtils.isNotBlank(result)) {
				throw new AssertException(scene,OperateTypeEnum.create, "�ֶ����п�ֵ", model);
			}
			return;
		}
	}

	@Override
	public void exists(RequestContext requestContext, String id) {
			OrderModel res = orderRepository.findOne(id,OrderModel.class);
			requestContext.setChangeFrom(res);
			if (res==null) {
				throw new AssertException(scene,OperateTypeEnum.find, "�Ҳ���ָ����ԤԼ��", id);
			}
	}
	
	@Override
	public void enable(RequestContext requestContext, OrderModel model, BusiTypeEnum busiTypeEnum) {
		Assert.notNull(requestContext.getUserModel().getId(),"��ǰ������Ϊ��");
		//����
		if(BusiTypeEnum.create.equals(busiTypeEnum)){
			//���������Ƿ�򿪿���
			UserModel userModel = userRepository.findOne(model.getToUserId(),UserModel.class);
			if (userModel==null) {
				throw new AssertException(scene,OperateTypeEnum.create, "�Ҳ���ָ���ķ�����", model.getToUserId());
			}
			if(!BooleanAbout.isTrue(userModel.getAllowInvited())){
				throw new AssertException(scene,OperateTypeEnum.create, "��ͬѧ������ԤԼ��Ϣ", model.getToUserId());
			}
			//����Ƿ����
			LightUpModel lightUpModel=lightUpRepository.findOne(model.getLightUpId(),LightUpModel.class);
			if(lightUpModel==null){
				throw new AssertException(scene,OperateTypeEnum.create, "�Ҳ���������Ϣ", model.getLightUpId());
			}
			if(!BooleanAbout.isTrue(lightUpModel.getIsLightUp())){
				throw new AssertException(scene,OperateTypeEnum.create, "δ����", model.getLightUpId());
			}
			if(lightUpModel.getGmtTill()!=null&&
					System.currentTimeMillis()>lightUpModel.getGmtTill().getTime()
					){
				throw new AssertException(scene,OperateTypeEnum.create, "��Ϣ�ѹ���", lightUpModel.getGmtTill());
			}
			//ʱ�����ƣ���ɧ��
			List<String> qfileds = Lists.newArrayList("fromUserId","toUserId");
			OrderModel last=orderRepository.findLast(model,qfileds,Direction.DESC,Lists.newArrayList(BaseModel.final_gmtCreate));
			if (last!=null&&TimeUtil.isInMins(last.getGmtCreate(), NumberAbout.INVITE_SAME_PERSON_INTERVEL_MINITUS)) {
				throw new AssertException(scene,OperateTypeEnum.create, "�μ�ͬһ������ټ��"+NumberAbout.INVITE_SAME_PERSON_INTERVEL_MINITUS+"����", last.getGmtCreate());
			}
		}else if(BusiTypeEnum.reject.equals(busiTypeEnum)){
			//��û�б�����
			OrderModel res = orderRepository.findOne(model.getId(),OrderModel.class);
			Assert.notNull(requestContext.getUserModel().getId());
			if(requestContext.getUserModel().getId()!=null&&!requestContext.getUserModel().getId().equals(res.getToUserId())){
				throw new AssertException(scene,OperateTypeEnum.update, "��ԤԼ�˲��ǵ�ǰ������", model.getToUserId());
			}
			//�������Ѷ����Ծܾ�
			if(!OrderStatusEnum.created.equals(res.getStatus())
					&&!OrderStatusEnum.read.equals(res.getStatus())){
				throw new AssertException(scene,OperateTypeEnum.update, "��ǰ״̬�����ܾܾ���", res.getStatus());
			}
		}else if(BusiTypeEnum.accept.equals(busiTypeEnum)){
			//��û�б�����
			OrderModel res = orderRepository.findOne(model.getId(),OrderModel.class);
			Assert.notNull(res, "�Ҳ���ԤԼ��");
			if(requestContext.getUserModel().getId()!=null&&!requestContext.getUserModel().getId().equals(res.getToUserId())){
				throw new AssertException(scene,OperateTypeEnum.update, "��ǰ�����˲��ǻ������", model.getToUserId());
			}
			//�������Ѷ����Ծܾ�
			if(!OrderStatusEnum.created.equals(res.getStatus())
					&&!OrderStatusEnum.read.equals(res.getStatus())){
				throw new AssertException(scene,OperateTypeEnum.update, "��ǰ״̬�����ܽ��ܡ�", res.getStatus());
			}
		}else if(BusiTypeEnum.start.equals(busiTypeEnum)){
			//��û�б�����
			OrderModel res = orderRepository.findOne(model.getId(),OrderModel.class);
			if(requestContext.getUserModel().getId()!=null&&!requestContext.getUserModel().getId().equals(res.getToUserId())){
				throw new AssertException(scene,OperateTypeEnum.update, "��ǰ�����˲��ǻ������", model.getToUserId());
			}
			//�������Ѷ����Ծܾ�
			if(!OrderStatusEnum.accept.equals(res.getStatus())){
				throw new AssertException(scene,OperateTypeEnum.update, "���Ƚ���ԤԼ��", res.getStatus());
			}
		}else if(BusiTypeEnum.cancel.equals(busiTypeEnum)){
			//��û�б�����
			OrderModel res = orderRepository.findOne(model.getId(),OrderModel.class);
			
			if(!requestContext.getUserModel().getId().equals(res.getFromUserId())&&!requestContext.getUserModel().getId().equals(res.getToUserId())){
				throw new AssertException(scene,OperateTypeEnum.update, "��ǰ�����˲���ԤԼ����,Ҳ���ǻ�����ˣ�������ȡ������",res);
			}
			//�ϳ�����ȡ��
			if(OrderStatusEnum.gotOn.equals(res.getStatus())
					||OrderStatusEnum.finish.equals(res.getStatus())){
				throw new AssertException(scene,OperateTypeEnum.update, "�ѿ�ʼ����ȡ����", res.getStatus());
			}
			if(OrderStatusEnum.cancel.equals(res.getStatus())){
				throw new AssertException(scene,OperateTypeEnum.update, "�Ѿ�ȡ�����ˡ�", res.getStatus());
			}
		}else if(BusiTypeEnum.finish.equals(busiTypeEnum)){
			//��û�б�����
			OrderModel res = orderRepository.findOne(model.getId(),OrderModel.class);
			if(!requestContext.getUserModel().getId().equals(res.getToUserId())){
				throw new AssertException(scene,OperateTypeEnum.update, "��ǰ�����˲���ԤԼ�ˣ���������ɲ���", res.getToUserId());
			}
			//�ϳ�����ȡ��
			if(!OrderStatusEnum.gotOn.equals(res.getStatus())
			 &&!OrderStatusEnum.accept.equals(res.getStatus())
					){
				throw new AssertException(scene,OperateTypeEnum.update, "��ǰ״̬�������ԤԼ����", res.getStatus());
			}
		}
	}
	
	// #
}
