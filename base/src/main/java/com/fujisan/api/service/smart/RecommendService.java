  package com.fujisan.api.service.smart;

import com.fujisan.api.RequestContext;
import com.fujisan.api.Response;
/**
 * �Ƽ�����
 * @author siyaomin
 *
 */
public interface RecommendService {
	/**
	 * ��ȡ�Ƽ�������
	 * @param requestContext
	 * @return
	 */
	Response<Boolean> getRecommendScopes(RequestContext requestContext);
	
}
