package com.fujisan.notify;

import com.fujisan.api.RequestContext;
import com.fujisan.model.BaseModel;

/**
 * ģ�ͱ������ӿ�
 * 
 * @author siyaomin
 *
 * @param <T>
 */
public interface ModelChangeDispose<T extends BaseModel> {
	/**
	 * ģ�ͱ���Ĵ���
	 * @param requestContext
	 * @param from
	 * @param to
	 */
	void dispose(RequestContext requestContext,Object[] args );
}
