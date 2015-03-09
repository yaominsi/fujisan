package com.fujisan.api.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.api.service.TopicService;
import com.fujisan.api.service.asserts.DomainServiceAssert;
import com.fujisan.common.BooleanAbout;
import com.fujisan.common.BusiTypeEnum;
import com.fujisan.model.BaseModel;
import com.fujisan.model.TagModel;
import com.fujisan.model.TopicModel;
import com.fujisan.repository.TagRepository;
import com.fujisan.repository.TopicRepository;
import com.google.common.collect.Lists;

/**
 * 主题服务的实现
 * 
 * @author siyaomin
 *
 */
@Service
public class TopicServiceImpl implements TopicService {
	@Autowired
	private TopicRepository topicRepository;
	@Autowired
	private DomainServiceAssert<TopicModel> topicAssert;

	@Override
	public Response<Boolean> save(RequestContext requestContext, TopicModel topicModel) {
		topicAssert.checkParams(requestContext, topicModel, BusiTypeEnum.create);
		topicModel.setModifier(requestContext.getUserModel().getName());
		topicModel.setGmtModified(new Date());
		if (StringUtils.isBlank(topicModel.getId())) {
			topicModel.setCreator(requestContext.getUserModel().getName());
			topicModel.setCreatorId(requestContext.getUserModel().getId());
			topicModel.setGmtCreate(new Date());
			topicModel.setIsDeleted(BooleanAbout.n);
		}
		topicRepository.saveModel(topicModel);
		Response<Boolean> result = new Response<Boolean>();
		result.setSuccess(true);
		return result;
	}
	@Override
	public Response<List<TopicModel>> list(RequestContext requestContext){
		
		List<TopicModel> list = topicRepository.findList(null, null, Direction.DESC, Lists.newArrayList(BaseModel.final_gmtModified), TopicModel.class);
		Response<List<TopicModel>> result=new Response<List<TopicModel>>();
		result.setSuccess(true);
		result.setValue(list);
		return result;
	}
}
