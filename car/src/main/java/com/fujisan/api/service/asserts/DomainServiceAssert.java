package com.fujisan.api.service.asserts;

import com.fujisan.api.RequestContext;
import com.fujisan.common.BusiTypeEnum;
/**
 * ����������
 * @author siyaomin
 *
 */
public interface DomainServiceAssert<T> {
	/**
	 * �Ƿ����
	 * @param id
	 */
	public abstract void exists(RequestContext requestContext,String id);
	/**
	 * �����Ƿ����
	 * @param requestContext
	 * @param id
	 * @param busiTypeEnum
	 */
	public abstract void enable(RequestContext requestContext,T model,BusiTypeEnum busiTypeEnum);
	/**
	 * ����У��
	 * @param requestContext
	 * @param obj
	 * @param busiTypeEnum
	 */
	public abstract void checkParams(RequestContext requestContext,T target,
			BusiTypeEnum busiTypeEnum);
}
