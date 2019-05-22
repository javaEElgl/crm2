package auth.entity;

public class User {
	private int userId;
	private String userName;
	private String passWord;
	private Role role;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String userName, String passWord, Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}

	public User(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
