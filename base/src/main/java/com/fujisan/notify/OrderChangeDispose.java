package com.fujisan.notify;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fujisan.api.RequestContext;
import com.fujisan.api.service.NotifyService;
import com.fujisan.api.service.asserts.Assert;
import com.fujisan.common.NotifyTypeEnum;
import com.fujisan.common.OrderStatusEnum;
import com.fujisan.model.NotifyModel;
import com.fujisan.model.OrderModel;
import com.fujisan.model.UserModel;
import com.fujisan.repository.UserRepository;

/**
 * ģ�ͱ������ӿ�
 * 
 * @author siyaomin
 *
 * @param <T>
 */
@Component
public class OrderChangeDispose implements ModelChangeDispose<OrderModel> {
	private static final Logger log = Logger.getLogger(OrderChangeDispose.class);
	@Autowired
	private NotifyService notifyService;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void dispose(RequestContext requestContext, Object[] args) {
		notify(requestContext, (OrderModel) requestContext.getChangeFrom(), (OrderModel) requestContext.getChangeTo());
	}

	private void notify(RequestContext requestContext,OrderModel from, OrderModel to){
		Assert.notNull(to,"order change but not set changeTo property of requestContext");
		NotifyModel notify=new NotifyModel();
		if (from!=null&&to.getStatus().equals(from.getStatus())) {
			log.info("״̬û�б��"+requestContext.getSeq());
			return ;
		}
		notify.setTargetId(to.getId());
		notify.setType(NotifyTypeEnum.order);
		notify.setFromUserId(to.getOperatorId());
		UserModel optUser = userRepository.findOne(to.getOperatorId(), UserModel.class);
		//�´���,֪ͨ��ԤԼ
		if(OrderStatusEnum.created.equals(to.getStatus())){
			notify.setToUserId(to.getToUserId());
			notify.setContent("�յ�һ������"+optUser.getName()+"��ԤԼ");
			notifyService.create(requestContext,notify);
			log.info(notify.getToUserId()+"�յ�һ������"+notify.getFromUserId()+"��ԤԼ,seq:"+requestContext.getSeq());
			//����ԤԼҪ֪ͨ�������
		}else if(to.getStatus().equals(OrderStatusEnum.accept)){
			notify.setToUserId(to.getFromUserId());
			notify.setContent(optUser.getName()+"���������ԤԼ");
			notifyService.create(requestContext,notify);
			log.info(optUser.getName()+"������"+notify.getFromUserId()+"��ԤԼ,seq:"+requestContext.getSeq());
			//����ԤԼҪ֪ͨ�������
		}else if(to.getStatus().equals(OrderStatusEnum.cancel)){
			notify.setToUserId(to.getFromUserId());
			notify.setContent(optUser.getName()+"ȡ����ԤԼ");
			notifyService.create(requestContext,notify);
			log.info(optUser.getName()+"ȡ����ԤԼ,seq:"+requestContext.getSeq());
			//����ԤԼҪ֪ͨ�������
		}else if(to.getStatus().equals(OrderStatusEnum.finish)){
			//TODO ����յ��޾͸��߶Է�
			notify.setToUserId(to.getFromUserId());
			notify.setContent(to.getOperatorId()+"�����һ��ԤԼ");
			notifyService.create(requestContext,notify);
			log.info(optUser.getName()+"�����һ��ԤԼseq:"+requestContext.getSeq());
			//�ܾ�
		}else if(to.getStatus().equals(OrderStatusEnum.rejected)){
			notify.setToUserId(to.getFromUserId());
			notify.setContent(optUser.getName()+"�ܾ������ԤԼ");
			notifyService.create(requestContext,notify);
			log.info(optUser.getName()+"�ܾ������ԤԼ,seq:"+requestContext.getSeq());
		}
	}
}
