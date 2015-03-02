package com.fujisan.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fujisan.common.NotifyStatusEnum;
import com.fujisan.common.NotifyTypeEnum;
import com.google.common.collect.Lists;

/**
 * ֪ͨ���� <br/>
 * ����һ��֪ͨ���ģ� <br/>
 * ���� ����֪ͨ һ����Ϣ֪ͨ �Ƽ�֪ͨ ����
 * 
 * @author siyaomin
 *
 */
@Document(collection = "notify")
public class NotifyModel extends BaseModel {
	private static final long serialVersionUID = 1L;
	private String fromUserId;// ֪ͨ������
	private String toUserId;// ֪ͨ������
	private String fromUserName;// ����
	private String toUserName;// ����
	private String targetId;// ֪ͨ�漰����
	private NotifyTypeEnum type;// ֪ͨ����
	private String level;// ֪ͨ��������
	private String content;// ����
	private NotifyStatusEnum status;// ״̬

	public NotifyModel() {
	}

	public NotifyModel(String content) {
		this.content = content;
	}

	@Override
	public List<String> needFieldsForCreate() {
		return Lists.newArrayList("fromUserId", "toUserId");
	}

	public String getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public NotifyTypeEnum getType() {
		return type;
	}

	public void setType(NotifyTypeEnum type) {
		this.type = type;
	}

	public NotifyStatusEnum getStatus() {
		return status;
	}

	public void setStatus(NotifyStatusEnum status) {
		this.status = status;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

}
