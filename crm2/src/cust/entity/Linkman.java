package cust.entity;

public class Linkman {
	private int ID;              //联系人编号
	private String name;		//联系人姓名
	private String sex;			//联系人性别
	private String postion;		//职位
	private String tel;			//办公电话
	private String phone;		//手机
	private String memo;		//备注
	private Customer customer;    //取客户信息编号
	
	public Linkman() {
		// TODO Auto-generated constructor stub
	}
	
	public Linkman(String name, String sex, String postion, String tel,
			String phone, String memo) {
		super();
		this.name = name;
		this.sex = sex;
		this.postion = postion;
		this.tel = tel;
		this.phone = phone;
		this.memo = memo;
	}
	
	public Linkman(String name, String sex, String postion, String tel,
			String phone, String memo, Customer customer) {
		super();
		this.name = name;
		this.sex = sex;
		this.postion = postion;
		this.tel = tel;
		this.phone = phone;
		this.memo = memo;
		this.customer = customer;
	}

	public Linkman(int iD, String name, String sex, String postion, String tel,
			String phone, String memo, Customer customer) {
		super();
		ID = iD;
		this.name = name;
		this.sex = sex;
		this.postion = postion;
		this.tel = tel;
		this.phone = phone;
		this.memo = memo;
		this.customer = customer;
	}
	
	public Linkman(int iD, String name, String sex, String postion, String tel,
			String phone, String memo) {
		super();
		ID = iD;
		this.name = name;
		this.sex = sex;
		this.postion = postion;
		this.tel = tel;
		this.phone = phone;
		this.memo = memo;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPostion() {
		return postion;
	}
	public void setPostion(String postion) {
		this.postion = postion;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
