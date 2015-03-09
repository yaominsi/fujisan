package com.fujisan.api.service.asserts;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fujisan.api.RequestContext;
import com.fujisan.api.service.asserts.exception.AssertException;
import com.fujisan.common.BeanHelper;
import com.fujisan.common.BooleanAbout;
import com.fujisan.common.BusiTypeEnum;
import com.fujisan.common.OperateTypeEnum;
import com.fujisan.model.ActivityModel;
import com.fujisan.repository.ActivityRepository;
/**
 * ˾������Ķ���
 * @author siyaomin
 *
 */
@Component
public class ActivityAssert implements DomainServiceAssert<ActivityModel> {
	@Autowired
	private ActivityRepository activityRepository;
	private final BusiTypeEnum scene=BusiTypeEnum.lightup;
	// #set

	@Override
	public void checkParams(RequestContext requestContext, ActivityModel model, BusiTypeEnum busiTypeEnum) {
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
			ActivityModel res = activityRepository.findOne(id,ActivityModel.class);
			if (res==null) {
				throw new AssertException(scene,OperateTypeEnum.find, "�Ҳ���ָ���Ķ���", id);
			}
	}

	@Override
	public void enable(RequestContext requestContext, ActivityModel model, BusiTypeEnum busiTypeEnum) {
		Assert.notNull(model);
		ActivityModel res =null;
		if (model.getId()!=null) {
			res = activityRepository.findOne(model.getId(),ActivityModel.class);
			if (res==null) {
				throw new AssertException(scene,OperateTypeEnum.update, "�Ҳ���ָ���Ķ���", model.getId());
			}
			if (!res.getCreatorId().equals(requestContext.getUserModel().getId())) {
				throw new AssertException(scene,OperateTypeEnum.update, "��ǰ�����˲��Ǵ�����", res.getCreatorId());
			}
		}
		if (BusiTypeEnum.update.equals(busiTypeEnum)) {
			Assert.notNull(model.getId());
		}else if (BusiTypeEnum.lightoff.equals(busiTypeEnum)){
			Assert.notNull(model.getId());
			if (!BooleanAbout.isTrue(res.getIsLightUp())) {
				throw new AssertException(scene,OperateTypeEnum.update, "���ǹرյ�״̬", model.getId());
			}
		}else if (BusiTypeEnum.lightup.equals(busiTypeEnum)){
			Assert.notNull(model.getId());
			if (BooleanAbout.isTrue(res.getIsLightUp())) {
				throw new AssertException(scene,OperateTypeEnum.update, "���ǵ�����״̬", model.getId());
			}
		}
	}

//setter
}
