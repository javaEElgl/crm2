package auth.entity;

import java.util.HashSet;
import java.util.Set;

public class Right {
	private int rightId;         //Ȩ�ޱ��
	private int ParentID;           //���˵����
	private String rightParent;   //Ȩ�޸�ģ������
	private String rightName;  //Ȩ������
	private String rightUrl;   //Ȩ�޶�Ӧ�ķ��ʵ�ַ
	private Set<Role> roles = new HashSet<Role>();
	
	
	public int getRightId() {
		return rightId;
	}
	public void setRightId(int rightId) {
		this.rightId = rightId;
	}
	public int getParentID() {
		return ParentID;
	}
	public void setParentID(int parentID) {
		ParentID = parentID;
	}
	public String getRightParent() {
		return rightParent;
	}
	public void setRightParent(String rightParent) {
		this.rightParent = rightParent;
	}
	public String getRightName() {
		return rightName;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public String getRightUrl() {
		return rightUrl;
	}
	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
