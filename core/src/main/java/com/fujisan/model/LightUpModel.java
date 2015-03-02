package com.fujisan.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fujisan.common.DurationUnitEnum;
import com.google.common.collect.Lists;

/**
 * ����ģ��
 * 
 * ָ��������Ŀ�꣬��path����area
 * 
 * �����ı�ǩ����Ϊ����ʲô
 * 
 * ʱ����Ϣ
 * 
 * ���������˽����Ϣ��Ϊ��ѯ��׼��
 * 
 * ���������������������б���򲻻�Ӱ��������
 * 
 * @author siyaomin
 *
 */
@Document(collection = "lightups")
public class LightUpModel extends BaseModel {
	public static final String SIGNUPS = "signUps";
	private static final long serialVersionUID = 1L;
	public static final String ACCEPTS = "accepts";
	private String scopeId;
	private String title;
	private String note;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT")
	private Date gmtStartOff;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT")
	private Date gmtTill;
	private Integer duration;
	private DurationUnitEnum durationUnit;
	private List<NodeModel> nodes;
	private String isLightUp;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT")
	private Date gmtLightUp;
	// ����������
	private Integer seeds;
	// ���뱨��������
	private Integer signUps;
	// ���ͨ��������
	private Integer accepts;
	private String pic;
	//���ͼƬ
	
	private List<String> pics;
	
	

	public LightUpModel(String id) {
		this.id = id;
	}

	public LightUpModel() {
	}

	/**
	 * ����
	 * 
	 * @param scopeId
	 * @param title
	 * @param gmtStartOff
	 * @param gmtTill
	 */
	public LightUpModel(String scopeId, String title, Date gmtStartOff, Date gmtTill) {
		this.scopeId = scopeId;
		this.title = title;
		this.gmtStartOff = gmtStartOff;
		this.gmtTill = gmtTill;
	}

	@Override
	public List<String> needFieldsForCreate() {
		// TODO Auto-generated method stub
		return Lists.newArrayList("creatorId", "scopeId", "title", "gmtStartOff", "duration", "durationUnit",
				"gmtTill", "nodes", "isLightUp","seeds","signUps","accepts");
	}

	public String getScopeId() {
		return scopeId;
	}

	public void setScopeId(String scopeId) {
		this.scopeId = scopeId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getGmtStartOff() {
		return gmtStartOff;
	}

	public void setGmtStartOff(Date gmtStartOff) {
		this.gmtStartOff = gmtStartOff;
	}

	public Date getGmtTill() {
		return gmtTill;
	}

	public void setGmtTill(Date gmtTill) {
		this.gmtTill = gmtTill;
	}

	public List<NodeModel> getNodes() {
		return nodes;
	}

	public void setNodes(List<NodeModel> nodes) {
		this.nodes = nodes;
	}

	public String getIsLightUp() {
		return isLightUp;
	}

	public void setIsLightUp(String isLightUp) {
		this.isLightUp = isLightUp;
	}

	public Date getGmtLightUp() {
		return gmtLightUp;
	}

	public void setGmtLightUp(Date gmtLightUp) {
		this.gmtLightUp = gmtLightUp;
	}

	public DurationUnitEnum getDurationUnit() {
		return durationUnit;
	}

	public void setDurationUnit(DurationUnitEnum durationUnit) {
		this.durationUnit = durationUnit;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getSeeds() {
		return seeds;
	}

	public void setSeeds(Integer seeds) {
		this.seeds = seeds;
	}

	public Integer getSignUps() {
		return signUps;
	}

	public void setSignUps(Integer signUps) {
		this.signUps = signUps;
	}

	public Integer getAccepts() {
		return accepts;
	}

	public void setAccepts(Integer accepts) {
		this.accepts = accepts;
	}

	public List<String> getPics() {
		return pics;
	}

	public void setPics(List<String> pics) {
		this.pics = pics;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}
