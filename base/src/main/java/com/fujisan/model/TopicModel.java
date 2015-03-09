package com.fujisan.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.collect.Lists;
/**
 * µ„¡¡¿‡–Õ
 * @author siyaomin
 *
 */
@Document(collection="topics")
public class TopicModel extends BaseModel{

	private static final long serialVersionUID = 1L;
	private String name;
	private String pic;
	public TopicModel(){}
	public TopicModel(String name,String pic){
		this.setName(name);
		this.setPic(pic);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public List<String> needFieldsForCreate() {
		return Lists.newArrayList(
				"name",
				"pic"
				);

	}
	
}