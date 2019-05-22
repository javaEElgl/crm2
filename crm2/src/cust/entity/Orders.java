package cust.entity;

public class Orders {
	private int ID;   //订单编号
	private String date;   //订单日期
	private String addr;  //送货地址
	private int status;   //订单状态
	private int money;  //总金额
	private Customer customer;   //取客户信息编号
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
	public Orders(String date, String addr, int status, int money,
			Customer customer) {
		super();
		this.date = date;
		this.addr = addr;
		this.status = status;
		this.money = money;
		this.customer = customer;
	}

	public Orders(int iD, String date, String addr, int status, int money,
			Customer customer) {
		super();
		ID = iD;
		this.date = date;
		this.addr = addr;
		this.status = status;
		this.money = money;
		this.customer = customer;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
