package com.sasu.entiy;

public class ParentReply {		//��ĸ�ظ���¼		̷��
	private int id;
	private String content;	//���͵�����ģ��
	private int leave_id;		//�������Ϣ�����
	private LeaveInfo leave;	//�����Ϣ����
	private String record_time;	//��¼��ֹʱ��
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}
	public LeaveInfo getLeave() {
		return leave;
	}
	public void setLeave(LeaveInfo leave) {
		this.leave = leave;
	}
	public String getRecord_time() {
		return record_time;
	}
	public void setRecord_time(String record_time) {
		this.record_time = record_time;
	}
	

}
