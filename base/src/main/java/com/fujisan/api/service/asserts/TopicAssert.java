package com.fujisan.api.service.asserts;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fujisan.api.RequestContext;
import com.fujisan.api.service.asserts.exception.AssertException;
import com.fujisan.common.BeanHelper;
import com.fujisan.common.BusiTypeEnum;
import com.fujisan.common.OperateTypeEnum;
import com.fujisan.model.TopicModel;
import com.fujisan.repository.TopicRepository;

/**
 * ˾������Ķ���
 * 
 * @author siyaomin
 *
 */
@Component
public class TopicAssert implements DomainServiceAssert<TopicModel> {
	@Autowired
	private TopicRepository topicRepository;
	private final BusiTypeEnum scene = BusiTypeEnum.tag;

	// #set
	@Override
	public void checkParams(RequestContext requestContext, TopicModel model, BusiTypeEnum busiTypeEnum) {
		Assert.notNull(model);
		if (OperateTypeEnum.create.equals(busiTypeEnum)) {
			String result = BeanHelper.checkFieldsNotEmpty(model, model.needFieldsForCreate());
			if (StringUtils.isNotBlank(result)) {
				throw new AssertException(scene, OperateTypeEnum.create, "�ֶ����п�ֵ", model);
			}
			return;
		}

	}

	@Override
	public void exists(RequestContext requestContext, String id) {
		TopicModel res = topicRepository.findOne(id,TopicModel.class);
		if (res == null) {
			throw new AssertException(scene, OperateTypeEnum.find, "�Ҳ���ָ���ı�ǩ", id);
		}
	}

	@Override
	public void enable(RequestContext requestContext, TopicModel model, BusiTypeEnum busiTypeEnum) {
	}

}
