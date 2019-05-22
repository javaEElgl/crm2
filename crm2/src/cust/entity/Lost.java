package cust.entity;

public class Lost {
	private int ID;   //客户流失表ID
	private String  customer;   //客户名称
	private String manager;  //客户经理
	private String orderdate;  //上次下单时间
	private String lostdate;  //确认流失时间
	private String delay;  //暂缓措施
	private String reason;  //流失原因
	private int status;		//流失状态  1 预警 2 暂缓流失 3已经流失
	
	
	public Lost() {
		// TODO Auto-generated constructor stub
	}
	
	public Lost(int iD, String customer, String manager, String orderdate,
			String lostdate, String delay, String reason, int status) {
		super();
		ID = iD;
		this.customer = customer;
		this.manager = manager;
		this.orderdate = orderdate;
		this.lostdate = lostdate;
		this.delay = delay;
		this.reason = reason;
		this.status = status;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public String getLostdate() {
		return lostdate;
	}
	public void setLostdate(String lostdate) {
		this.lostdate = lostdate;
	}
	public String getDelay() {
		return delay;
	}
	public void setDelay(String delay) {
		this.delay = delay;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
