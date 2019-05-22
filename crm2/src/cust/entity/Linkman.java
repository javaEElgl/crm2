package cust.entity;

public class Linkman {
	private int ID;              //��ϵ�˱��
	private String name;		//��ϵ������
	private String sex;			//��ϵ���Ա�
	private String postion;		//ְλ
	private String tel;			//�칫�绰
	private String phone;		//�ֻ�
	private String memo;		//��ע
	private Customer customer;    //ȡ�ͻ���Ϣ���
	
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