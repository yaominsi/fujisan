package com.fujisan.api;

import java.io.Serializable;
import java.util.List;

import com.fujisan.model.TagModel;
import com.fujisan.model.TopicModel;
import com.fujisan.model.UserModel;
/**
 * 用户主题明细
 * @author siyaomin
 *
 */
public class UserTopicDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	private UserModel user;
	private TopicModel topic;
	private List<TagModel> tags;
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public TopicModel getTopic() {
		return topic;
	}
	public void setTopic(TopicModel topic) {
		this.topic = topic;
	}
	public List<TagModel> getTags() {
		return tags;
	}
	public void setTags(List<TagModel> tags) {
		this.tags = tags;
	}
	
}
