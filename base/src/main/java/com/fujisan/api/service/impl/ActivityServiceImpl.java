package com.fujisan.api.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fujisan.api.ActivityDetail;
import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.api.service.ActivityService;
import com.fujisan.api.service.asserts.Assert;
import com.fujisan.api.service.asserts.DomainServiceAssert;
import com.fujisan.api.service.asserts.exception.AssertException;
import com.fujisan.common.BooleanAbout;
import com.fujisan.common.BusiTypeEnum;
import com.fujisan.common.TimeUtil;
import com.fujisan.model.ActivityModel;
import com.fujisan.model.NodeModel;
import com.fujisan.model.ScopeModel;
import com.fujisan.model.UserModel;
import com.fujisan.repository.ActivityRepository;
import com.fujisan.repository.NodeRepository;
import com.fujisan.repository.ScopeRepository;
import com.fujisan.repository.UserRepository;
import com.google.common.collect.Lists;

/**
 * �������� �˿͵������� ˾������
 * 
 * @author siyaomin
 *
 */
@Service
public class ActivityServiceImpl implements ActivityService {
	private static final Logger log = Logger.getLogger(ActivityServiceImpl.class);
	@Autowired
	private ActivityRepository activityRepository;
	@Autowired
	private NodeRepository nodeRepository;
	@Autowired
	private ScopeRepository scopeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DomainServiceAssert<ActivityModel> lightUpAssert;

	@Override
	public Response<Boolean> save(RequestContext requestContext, ActivityModel lightupModel) {
		String seq = requestContext.getSeq();
		log.info("[light_up_save] start " + seq);
		// û��id�򴴽�ģ��
		Assert.notNull(lightupModel);
		Assert.notNull(lightupModel.getDuration());
		Assert.notNull(lightupModel.getDurationUnit());
		lightupModel.setGmtTill(TimeUtil.add(lightupModel.getGmtStartOff(), lightupModel.getDuration(), lightupModel.getDurationUnit()));
		lightupModel.setGmtModified(new Date());
		lightupModel.setModifier(requestContext.getUserModel().getName());
		lightupModel.setIsDeleted(BooleanAbout.n);
		if (lightupModel.getScopeId()!=null) {
			lightupModel.setNodes(nodeRepository.findList(new NodeModel(lightupModel.getScopeId()),Lists.newArrayList("scopeId") , Direction.ASC, Lists.newArrayList("order"), NodeModel.class));
		}
		if (lightupModel.getIsLightUp()==null) {
			lightupModel.setIsLightUp(BooleanAbout.n);
		}else if(BooleanAbout.isTrue(lightupModel.getIsLightUp())){
			lightupModel.setIsLightUp(BooleanAbout.y);
			lightupModel.setGmtLightUp(new Date());
			ScopeModel scopeModel = scopeRepository.findOne(lightupModel.getScopeId(), ScopeModel.class);
			Assert.notNull(scopeModel, "�Ҳ���ָ������");
			Assert.notEmpty(scopeModel.getNodes(), "ָ������û�н��");
		}else if(!BooleanAbout.isTrue(lightupModel.getIsLightUp())){
			lightupModel.setIsLightUp(BooleanAbout.n);
		}
		if (lightupModel.getId() == null) {
			lightupModel.setCreatorId(requestContext.getUserModel().getId());
			lightupModel.setCreator(requestContext.getUserModel().getName());
			lightupModel.setGmtCreate(new Date());
			lightupModel.setAccepts(0);
			lightupModel.setSignUps(0);
			lightUpAssert.checkParams(requestContext, lightupModel, BusiTypeEnum.create);
		}
		lightUpAssert.enable(requestContext, lightupModel, BusiTypeEnum.create);
<<<<<<< HEAD:base/src/main/java/com/fujisan/api/service/impl/LightUpServiceImpl.java
		lightUpRepository.saveModel(lightupModel);
=======
		activityRepository.save(lightupModel);
>>>>>>> new-page:base/src/main/java/com/fujisan/api/service/impl/ActivityServiceImpl.java
		log.info("[light_up_save] ok" + seq);
		return new Response<Boolean>(true, "����ɹ�");
	}

	@Override
	public Response<Boolean> lightOff(RequestContext requestContext, String id) {
		String seq = requestContext.getSeq();
		log.info("start light_off " + seq);
		lightUpAssert.exists(requestContext, id);
		Assert.notNull(id);
		ActivityModel lightupModel = new ActivityModel(id);
		lightupModel.setIsLightUp(BooleanAbout.n);
		lightupModel.setGmtModified(new Date());
		lightupModel.setModifier(requestContext.getUserModel().getName());
		lightupModel.setGmtLightUp(new Date());
		//
		lightUpAssert.enable(requestContext, lightupModel, BusiTypeEnum.lightoff);
<<<<<<< HEAD:base/src/main/java/com/fujisan/api/service/impl/LightUpServiceImpl.java
		lightUpRepository.saveModel(lightupModel);
=======
		activityRepository.save(lightupModel);
>>>>>>> new-page:base/src/main/java/com/fujisan/api/service/impl/ActivityServiceImpl.java
		log.info("[light_up] ok " + seq);
		return new Response<Boolean>(true, "�ѹر�");
	}
	@Override
	public Response<Boolean> lightUp(RequestContext requestContext, String id) {
		String seq = requestContext.getSeq();
		log.info("start light_up " + seq);
		lightUpAssert.exists(requestContext, id);
		Assert.notNull(id);
		ActivityModel lightupModel = new ActivityModel(id);
		lightupModel.setIsLightUp(BooleanAbout.y);
		lightupModel.setGmtModified(new Date());
		lightupModel.setModifier(requestContext.getUserModel().getName());
		lightupModel.setGmtLightUp(new Date());
		lightUpAssert.enable(requestContext, lightupModel, BusiTypeEnum.lightup);
<<<<<<< HEAD:base/src/main/java/com/fujisan/api/service/impl/LightUpServiceImpl.java
		lightUpRepository.saveModel(lightupModel);
=======
		activityRepository.save(lightupModel);
>>>>>>> new-page:base/src/main/java/com/fujisan/api/service/impl/ActivityServiceImpl.java
		log.info("[light_up] ok " + seq);
		return new Response<Boolean>(true, "�ѵ���");
	}

	@Override
	public Page<ActivityModel> find(RequestContext requestContext, ActivityModel model, List<String> properties,
			Direction direction, List<String> sortProperties, Pageable pageable) {
		return activityRepository.findByPage(model, properties, direction, sortProperties, pageable,ActivityModel.class);
	}
	/**
	 * ���ϸ��Ϣ
	 */
	@Override
	public Response<ActivityDetail> detail(RequestContext requestContext, String id) {
		String seq = requestContext.getSeq();
		log.info("start query detail light_up for id="+id+",seq:" + seq);
		Response<ActivityDetail> result=new Response<ActivityDetail>();
		try {
			ActivityModel lightUp = activityRepository.findOne(id, ActivityModel.class);
			ActivityDetail detail=new ActivityDetail();
			detail.setLightUp(lightUp);
			if (lightUp!=null) {
				if(StringUtils.isNotBlank(lightUp.getCreatorId()))
					detail.setFromUser(userRepository.findOne(lightUp.getCreatorId(),UserModel.class));
				if(StringUtils.isNotBlank(lightUp.getScopeId()));
					detail.setScope(scopeRepository.findOne(lightUp.getScopeId(), ScopeModel.class));
			}
			result.setValue(detail);
			log.info("end query detail light_up for id="+id+",seq:" + seq);
		} catch (AssertException e) {
			result.setDesc(e.getMessage());
			result.setSuccess(false);
			log.error(e.getMessage(),e);
		} catch (Exception e) {
			result.setSuccess(false);
			result.setDesc("��ȡʧ��");
			log.error(e.getMessage()+",seq:"+seq,e);
		}
		return result;
	}

	@Override
	public Page<ActivityDetail> findWithDetail(RequestContext current, ActivityModel lightUpModel, List<String> properties,
			Direction direction, List<String> sortProperties, Pageable pageable) {
		 Page<ActivityModel> page = activityRepository.findByPage(lightUpModel, properties, direction, sortProperties, pageable,ActivityModel.class);
		 
		List<ActivityDetail> list=Collections.emptyList();
		if (page.getTotalElements()>0) {
			list=new ArrayList<ActivityDetail>();
			for(ActivityModel lightUp:page.getContent()){
				ActivityDetail detail=new ActivityDetail();
				detail.setLightUp(lightUp);
				if (lightUp!=null) {
					if(StringUtils.isNotBlank(lightUp.getCreatorId()))
						detail.setFromUser(userRepository.findOne(lightUp.getCreatorId(),UserModel.class));
					if(StringUtils.isNotBlank(lightUp.getScopeId()));
						detail.setScope(scopeRepository.findOne(lightUp.getScopeId(), ScopeModel.class));
				}
				list.add(detail);
			}
		}
		return new PageImpl<ActivityDetail>(list, pageable, page.getTotalElements());
	}
}