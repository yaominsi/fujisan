package com.fujisan.repository;

import com.fujisan.model.UserModel;
/**
 * �û���Ϣ
 * @author siyaomin
 *
 */
public interface UserRepository  extends BaseRepository<UserModel>{

	UserModel findByTarget(String targetId, String source);

}
