package com.fujisan.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.fujisan.model.BaseModel;

/**
 * �ϲ�dao��ͳһID����ΪString
 * 
 * @author siyaomin
 *
 * @param <T>
 */
public interface BaseRepository<T extends BaseModel> {
	/**
	 * ���������һ����¼
	 * 
	 * @param t
	 * @param properties
	 * @param direction
	 * @param sortProperties
	 * @return
	 */
	public T findLast(T t, List<String> properties, Direction direction, List<String> sortProperties);

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param t
	 * @param properties
	 * @param direction
	 * @param sortProperties
	 * @param pageable
	 * @param clazz
	 * @return
	 */
	public Page<T> findByPage(T t, List<String> properties, Direction direction, List<String> sortProperties,
			Pageable pageable, Class<T> clazz);

	/**
	 * �б��ѯ
	 * 
	 * @param t
	 * @param properties
	 * @param direction
	 * @param sortProperties
	 * @param clazz
	 * @return
	 */
	public List<T> findList(T t, List<String> properties, Direction direction, List<String> sortProperties,
			Class<T> clazz);
	/**
	 * ����
	 * @param entity
	 * @return
	 */
	public T save(T entity);
	/**
	 * ��ѯָ���ļ�¼
	 * @param id
	 * @param clazz
	 * @return
	 */
	public T findOne(String id, Class<? extends T> clazz);
	/**
	 * ��ѯָ����¼
	 * @param entity
	 * @param properties
	 * @param clazz
	 * @return
	 */
	public T findOne(T entity, List<String> properties, Class<T> clazz);
	/**
	 * �����ֶ�ֵ
	 * @param id
	 * @param key
	 * @param amount
	 * @param t
	 * @return
	 */
	public T findAndInc(String id, String key, int amount, Class<T> t);
	/**
	 * ͳ������
	 * @param t
	 * @param properties
	 * @return
	 */
	public long count(T t, List<String> properties);
}
