package com.fujisan.test.service;

import org.junit.Test;

import com.fujisan.api.RequestContext;
import com.fujisan.api.service.TopicService;
import com.fujisan.model.TopicModel;
/**
 * �û�����
 * @author siyaomin
 *
 */
public class TopicServiceTest extends BaseTest{
	private TopicService service;
	
	@Test
	public void testCreate() {
		service=context.getBean(TopicService.class);
		RequestContext requestContext=getContext("54ce5b47a82626475ab91584", "userName", new double[]{1d,1d});
		TopicModel topic=new TopicModel();
		topic.setName("������");
		service.save(requestContext, topic);
	}

}
