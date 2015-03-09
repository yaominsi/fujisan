package com.fujisan.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fujisan.common.TagTargetTypeEnum;
import com.google.common.collect.Lists;
/**
 * ±Í«©±Ì
 * @author siyaomin
 *
 */
@Document(collection="tags")
public class TagModel extends BaseModel {

	private static final long serialVersionUID = 1L;
	private String targetId;
	private TagTargetTypeEnum targetType;//user,topic
	private String ownerUserId;
	private String content;
	public TagModel(){}
	public TagModel(String targetId,TagTargetTypeEnum targetType,String content){
		this.targetId=targetId;
		this.targetType=targetType;
		this.content=content;
	}
	@Override
	public
	List<String> needFieldsForCreate() {
		return Lists.newArrayList(
				"targetId",
				"targetType",
				"content"
				);
	}
	public String getTargetId() {
		return targetId;
	}
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	public TagTargetTypeEnum getTargetType() {
		return targetType;
	}
	public void setTargetType(TagTargetTypeEnum targetType) {
		this.targetType = targetType;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOwnerUserId() {
		return ownerUserId;
	}
	public void setOwnerUserId(String ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

}
