package com.fujisan.api.service.asserts;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fujisan.api.RequestContext;
import com.fujisan.api.service.asserts.exception.AssertException;
import com.fujisan.common.BeanHelper;
import com.fujisan.common.BusiTypeEnum;
import com.fujisan.common.OperateTypeEnum;
import com.fujisan.model.BaseModel;
import com.fujisan.model.ScopeModel;
import com.fujisan.repository.ScopeRepository;
import com.google.common.collect.Lists;

/**
 * ˾������Ķ���
 * 
 * @author siyaomin
 *
 */
@Component("scopeAssert")
public class ScopeAssert implements DomainServiceAssert<ScopeModel> {
	@Autowired
	private ScopeRepository scopeRepository;
	private final BusiTypeEnum scene = BusiTypeEnum.scope;

	// #set
	@Override
	public void checkParams(RequestContext requestContext, ScopeModel model, BusiTypeEnum busiTypeEnum) {
		Assert.notNull(model);
		if (OperateTypeEnum.create.equals(busiTypeEnum)) {
			Assert.notEmpty(model.getNodes(),"���Ϊ��");
			String result = BeanHelper.checkFieldsNotEmpty(model, model.needFieldsForCreate());
			if (StringUtils.isNotBlank(result)) {
				throw new AssertException(scene, OperateTypeEnum.create, "�ֶ����п�ֵ", model);
			}
			return;
		}

	}

	@Override
	public void exists(RequestContext requestContext, String id) {
		ScopeModel res = scopeRepository.findOne(id,ScopeModel.class);
		if (res == null) {
			throw new AssertException(scene, OperateTypeEnum.find, "�Ҳ���ָ��������", id);
		}
	}

	@Override
	public void enable(RequestContext requestContext, ScopeModel model, BusiTypeEnum busiTypeEnum) {
		Assert.notNull(model);
		if (BusiTypeEnum.update.equals(busiTypeEnum)) {
			ScopeModel res = scopeRepository.findOne(model.getId(),ScopeModel.class);
			if (res == null) {
				throw new AssertException(scene, OperateTypeEnum.update, "�Ҳ���ָ��������", model.getId());
			}
			if (!res.getCreatorId().equals(requestContext.getUserModel().getId())) {
				throw new AssertException(scene, OperateTypeEnum.update, "��ǰ�����˲��Ǵ�����", res.getCreatorId());
			}
		}
		if (BusiTypeEnum.create.equals(busiTypeEnum)) {
			ScopeModel res = scopeRepository.findOne(model, Lists.newArrayList(BaseModel.final_creatorId,"name"),ScopeModel.class);
			if (res!=null){
				throw new AssertException(scene, OperateTypeEnum.update, "�Ѵ���ͬ��������", model.getId());
			}
		}
	}

}
