package com.fujisan.api.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
import com.fujisan.api.service.TagService;
import com.fujisan.api.service.asserts.DomainServiceAssert;
import com.fujisan.common.BooleanAbout;
import com.fujisan.common.BusiTypeEnum;
import com.fujisan.model.BaseModel;
import com.fujisan.model.TagModel;
import com.fujisan.model.TopicModel;
import com.fujisan.repository.TagRepository;
import com.google.common.collect.Lists;

/**
 * 主题服务的实现
 * 
 * @author siyaomin
 *
 */
@Service
public class TagServiceImpl implements TagService {
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private DomainServiceAssert<TagModel> tagAssert;

	@Override
	public Response<Boolean> save(RequestContext requestContext, TagModel tagModel) {
		tagAssert.checkParams(requestContext, tagModel, BusiTypeEnum.create);
		tagModel.setModifier(requestContext.getUserModel().getName());
		tagModel.setGmtModified(new Date());
		if (StringUtils.isBlank(tagModel.getId())) {
			tagModel.setCreator(requestContext.getUserModel().getName());
			tagModel.setCreatorId(requestContext.getUserModel().getId());
			tagModel.setGmtCreate(new Date());
			tagModel.setIsDeleted(BooleanAbout.n);
		}
		tagRepository.save(tagModel);
		Response<Boolean> result = new Response<Boolean>();
		result.setSuccess(true);
		return result;
	}
	@Override
	public Response<List<TagModel>> list(RequestContext requestContext,TagModel tagModel){
		
		List<TagModel> list = tagRepository.findList(null, null, Direction.DESC, Lists.newArrayList(BaseModel.final_gmtModified), TagModel.class);
		Response<List<TagModel>> result=new Response<List<TagModel>>();
		result.setSuccess(true);
		result.setValue(list);
		return result;
	}
}
