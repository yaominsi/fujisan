package com.fujisan.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.stereotype.Repository;

import com.fujisan.model.TopicModel;
import com.fujisan.repository.TopicRepository;

/**
 * 服务提供者
 * 
 * @author siyaomin
 *
 */
@Repository("topicRepository")
public class TopicRepositoryImpl extends BaseRepositoryImpl<TopicModel> implements
		TopicRepository {
	@Autowired
    public TopicRepositoryImpl(MongoRepositoryFactory factory, MongoOperations mongoOperations) {
        this(factory.<TopicModel, String>getEntityInformation(TopicModel.class), mongoOperations);
    }

	public TopicRepositoryImpl(MongoEntityInformation<TopicModel, String> metadata,
			MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
	}
}