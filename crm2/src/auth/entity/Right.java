package auth.entity;

import java.util.HashSet;
import java.util.Set;

public class Right {
	private int rightId;         //权限编号
	private int ParentID;           //父菜单编号
	private String rightParent;   //权限父模块名称
	private String rightName;  //权限名称
	private String rightUrl;   //权限对应的访问地址
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
