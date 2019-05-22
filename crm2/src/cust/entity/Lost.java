package cust.entity;

public class Lost {
	private int ID;   //�ͻ���ʧ��ID
	private String  customer;   //�ͻ�����
	private String manager;  //�ͻ�����
	private String orderdate;  //�ϴ��µ�ʱ��
	private String lostdate;  //ȷ����ʧʱ��
	private String delay;  //�ݻ���ʩ
	private String reason;  //��ʧԭ��
	private int status;		//��ʧ״̬  1 Ԥ�� 2 �ݻ���ʧ 3�Ѿ���ʧ
	
	
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
