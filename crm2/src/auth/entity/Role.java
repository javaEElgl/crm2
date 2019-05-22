package auth.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Role {
	private int roleId;
	private String roleName;
	private ArrayList<Role_Right>role_right;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Role(int roleId, String roleName, ArrayList<Role_Right> role_right) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.role_right = role_right;
	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public ArrayList<Role_Right> getRole_right() {
		return role_right;
	}
	public void setRole_right(ArrayList<Role_Right> role_right) {
		this.role_right = role_right;
	}
	
	
	
}
