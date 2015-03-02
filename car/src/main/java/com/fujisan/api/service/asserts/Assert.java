package com.fujisan.api.service.asserts;

import java.io.Serializable;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.fujisan.api.service.asserts.exception.AssertException;
/**
 * ��������
 * @author siyaomin
 *
 */
public class Assert {
	/**
	 * ��Ϊ��
	 * @param id
	 */
	public static void notNull(Object target){
		if(target==null){
			throw new AssertException("����Ϊ��",StringUtils.EMPTY);
		}
	}
	/**
	 * ��Ϊ��
	 * @param id
	 */
	public static void notNull(Serializable target,String msg){
		if(target==null){
			throw new AssertException( msg,StringUtils.EMPTY);
		}
	}
	/**
	 * ��Ϊ������Ԫ��
	 * @param coll
	 */
	public static void notEmpty(Collection<?> coll){
		if(CollectionUtils.isEmpty(coll)){
			throw new AssertException("����Ϊ��",StringUtils.EMPTY);
		}
	}
	/**
	 * ��Ϊ������Ԫ��
	 * @param coll
	 */
	public static void notEmpty(Collection<?> coll,String msg){
		if(CollectionUtils.isEmpty(coll)){
			throw new AssertException("�б�Ϊ��",StringUtils.EMPTY);
		}
	}
	public static void exists(String msg){
		throw new AssertException( msg,StringUtils.EMPTY);
	}
	public static void notBlank(String str, String msg) {
		if (StringUtils.isBlank(str)) {
			throw new AssertException( msg,msg);
		}
	}
}
