package auth.entity;

public class Role_Right {
	private int id;
	private int roleId;
	private int rightId;
	
	
	public Role_Right(int id, int roleId, int rightId) {
		super();
		this.id = id;
		this.roleId = roleId;
		this.rightId = rightId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRightId() {
		return rightId;
	}

	public void setRightId(int rightId) {
		this.rightId = rightId;
	}

}
