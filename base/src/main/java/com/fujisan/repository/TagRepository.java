package com.fujisan.repository;

import java.util.List;

import com.fujisan.model.TagModel;
/**
 * ��ǩ��Ϣ
 * @author siyaomin
 *
 */
public interface TagRepository extends BaseRepository<TagModel>{

	List<TagModel> getTagsByUserId(String id);

}
