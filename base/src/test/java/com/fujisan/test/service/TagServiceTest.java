package com.fujisan.test.service;

import org.junit.Test;

import com.fujisan.api.RequestContext;
import com.fujisan.api.service.TagService;
import com.fujisan.common.TagTargetTypeEnum;
import com.fujisan.model.TagModel;
/**
 * 用户测试
 * @author siyaomin
 *
 */
public class TagServiceTest extends BaseTest{
	private TagService service;
	
	@Test
	public void testCreate() {
		service=context.getBean(TagService.class);
		RequestContext requestContext=getContext("54ce5c93a826aaf930e8297d", "yaomin.siym", new double[]{1d,1d});
		TagModel tag=new TagModel();
		tag.setContent("想去婺源");
		tag.setTargetId("54fc1ba1a826495e24ca2d71");
		tag.setTargetType(TagTargetTypeEnum.topic);
		service.save(requestContext, tag);
	}

}
