package com.fujisan.api.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fujisan.api.NotifyDetail;
import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.api.service.NotifyService;
import com.fujisan.api.service.asserts.Assert;
import com.fujisan.common.BooleanAbout;
import com.fujisan.common.NotifyStatusEnum;
import com.fujisan.common.NotifyTypeEnum;
import com.fujisan.model.BaseModel;
import com.fujisan.model.ActivityModel;
import com.fujisan.model.NotifyModel;
import com.fujisan.model.OrderModel;
import com.fujisan.model.UserModel;
import com.fujisan.repository.ActivityRepository;
import com.fujisan.repository.NotifyRepository;
import com.fujisan.repository.OrderRepository;
import com.fujisan.repository.UserRepository;
import com.google.common.collect.Lists;

/**
 * ֪ͨ�����ʵ��
 * 
 * @author siyaomin
 *
 */
@Service
public class NotifyServiceImpl implements NotifyService {
	@Autowired
	private NotifyRepository notifyRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ActivityRepository activityRepository;
	private static final Logger log=Logger.getLogger(NotifyServiceImpl.class);
	@Override
	public Response<Boolean> create(RequestContext requestContext, NotifyModel notifyModel) {
		log.info("[notify create] start"+requestContext.getSeq());
		notifyModel.setCreator(requestContext.getUserModel().getName());
		notifyModel.setCreatorId(requestContext.getUserModel().getId());
		notifyModel.setGmtCreate(new Date());
		notifyModel.setModifier(requestContext.getUserModel().getName());
		notifyModel.setGmtModified(new Date());
		notifyModel.setIsDeleted(BooleanAbout.n);
		
		UserModel fromUser = userRepository.findOne(notifyModel.getFromUserId(), UserModel.class);
		Assert.notNull(fromUser,"�Ҳ������ն���");
		notifyModel.setFromUserName(fromUser.getName());
		UserModel toUser =userRepository.findOne(notifyModel.getToUserId(), UserModel.class);
		Assert.notNull(fromUser,"�Ҳ������Ͷ���");
		notifyModel.setToUserName(toUser.getName());
		//
		notifyModel.setStatus(NotifyStatusEnum.created);
		notifyRepository.saveModel(notifyModel);
		log.info("[notify create] ok"+requestContext.getSeq());
		return new Response<Boolean>(true, "֪ͨ�����ɹ�");
	}

	@Override
	public Response<Boolean> read(RequestContext requestContext, String id) {
		log.info("[notify read] start"+requestContext.getSeq());
		NotifyModel notifyModel=new NotifyModel();
		notifyModel.setModifier(requestContext.getUserModel().getName());
		notifyModel.setGmtModified(new Date());
		//
		notifyModel.setId(id);
		notifyModel.setStatus(NotifyStatusEnum.read);
		notifyRepository.saveModel(notifyModel);
		log.info("[notify read] ok"+requestContext.getSeq());
		return new Response<Boolean>(true, "���Ϊ�Ѷ�");
	}

	@Override
	public Response<Boolean> addToDo(RequestContext requestContext, String id) {
		log.info("[notify read] start"+requestContext.getSeq());
		NotifyModel notifyModel=new NotifyModel();
		notifyModel.setModifier(requestContext.getUserModel().getName());
		notifyModel.setGmtModified(new Date());
		//
		notifyModel.setId(id);
		notifyModel.setStatus(NotifyStatusEnum.todo);
		notifyRepository.saveModel(notifyModel);
		log.info("[notify read] ok"+requestContext.getSeq());
		return new Response<Boolean>(true, "�ѱ��Ϊtodo");
	}

	@Override
	public Response<Boolean> finish(RequestContext requestContext, String id) {
		log.info("[notify read] start"+requestContext.getSeq());
		NotifyModel notifyModel=new NotifyModel();
		notifyModel.setModifier(requestContext.getUserModel().getName());
		notifyModel.setGmtModified(new Date());
		//
		notifyModel.setId(id);
		notifyModel.setStatus(NotifyStatusEnum.finish);
		notifyRepository.saveModel(notifyModel);
		log.info("[notify read] ok"+requestContext.getSeq());
		return new Response<Boolean>(true, "�ѱ��Ϊtodo");
	}

	@Override
	public Page<NotifyModel> find(RequestContext requestContext, NotifyModel model, List<String> properties,
			Direction direction, List<String> sortProperties, Pageable pageable) {
		return notifyRepository.findByPage(model, properties, direction, sortProperties, pageable,NotifyModel.class);
	}

	@Override
	public Response<NotifyDetail> detail(RequestContext current, String id) {
		Response<NotifyDetail> result=new Response<NotifyDetail>();
		
		NotifyModel notify = notifyRepository.findOne(id, NotifyModel.class);
		if (notify!=null) {
			NotifyDetail value=new NotifyDetail();
			value.setNotify(notify);
			value.setFromUser(userRepository.findOne(notify.getFromUserId(), UserModel.class));
			if (NotifyTypeEnum.order.equals(notify.getType())) {
				OrderModel order = orderRepository.findOne(notify.getTargetId(), OrderModel.class);
				value.setOrder(order);
				value.setLightUp(activityRepository.findOne(order.getLightUpId(), ActivityModel.class));
			}
			result.setValue(value);
			
			//
			if(NotifyStatusEnum.created.equals(notify.getStatus())){
				notify.setGmtModified(new Date());
				notify.setStatus(NotifyStatusEnum.read);
				notifyRepository.saveModel(notify);
			}
		}
		return result;
	}

	@Override
	public Response<Map<NotifyStatusEnum,Long>> counts(RequestContext current, String toUserId, List<NotifyStatusEnum> status) {
		Assert.notBlank(toUserId,"str����Ϊ��");
		Response<Map<NotifyStatusEnum, Long>> result=new Response<Map<NotifyStatusEnum,Long>>();
		if (CollectionUtils.isNotEmpty(status)) {
			Map<NotifyStatusEnum, Long> map=new HashMap<NotifyStatusEnum, Long>();
			result.setValue(map);
			NotifyModel notify=new NotifyModel();
			notify.setToUserId(toUserId);
			for(NotifyStatusEnum s:status){
				notify.setStatus(s);
				map.put(s, notifyRepository.count(notify,Lists.newArrayList(BaseModel.final_status,BaseModel.final_toUserId)));
			}
		}
		return result;
	}

}
