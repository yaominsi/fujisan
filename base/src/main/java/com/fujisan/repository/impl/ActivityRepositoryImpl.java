package com.fujisan.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.stereotype.Repository;

import com.fujisan.model.ActivityModel;
import com.fujisan.repository.ActivityRepository;

/**
 * 服务提供者
 * 
 * @author siyaomin
 *
 */
@Repository("activityRepository")
public class ActivityRepositoryImpl extends BaseRepositoryImpl<ActivityModel> implements
		ActivityRepository {
	@Autowired
    public ActivityRepositoryImpl(MongoRepositoryFactory factory, MongoOperations mongoOperations) {
        this(factory.<ActivityModel, String>getEntityInformation(ActivityModel.class), mongoOperations);
    }

	public ActivityRepositoryImpl(MongoEntityInformation<ActivityModel, String> metadata,
			MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
	}

	@Autowired
	private MongoTemplate mongoTemplate;
}
