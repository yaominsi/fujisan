package com.fujisan.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.google.common.collect.Lists;

/**
 * ��������ĸ���Ƚϼҵ�λ�ã���һ��С�������ĸ��ţ���ô�ң����λ�þͻ����ĸ����
 * 
 * ��Ҹ���������·����ô�Ϳ����ڼ����λ������������
 * 
 * ������߳ɹ���
 * 
 * @author siyaomin
 *
 */
@Document(collection = "scopes")
public class ScopeModel extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private List<NodeModel> nodes; 
	public ScopeModel(String creatorId,String name,List<NodeModel> nodes){
		this.creatorId=creatorId;
		this.name=name;
		this.nodes=nodes;
	}
	public ScopeModel() {
	}
	@Override
	public List<String> needFieldsForCreate() {
		return Lists.newArrayList(
				"creatorId",
				"name",
				"nodes"
				);
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<NodeModel> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodeModel> nodes) {
		this.nodes = nodes;
	}

}
