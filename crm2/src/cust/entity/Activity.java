package cust.entity;

public class Activity {
	private int ID;				//交往记录编号
	private String date;		//交往记录时间	
	private String place;		//交往记录地点
	private String title;		//交往记录概要
	private String desc;		//详细信息
	private Customer customer;	//取客户信息编号
	
	public Activity() {
		// TODO Auto-generated constructor stub
	}
	

	public Activity(int ID,String date, String place, String title, String desc) {
		super();
		this.ID=ID;
		this.date = date;
		this.place = place;
		this.title = title;
		this.desc = desc;
	}


	public Activity(String date, String place, String title, String desc,
			Customer customer) {
		super();
		this.date = date;
		this.place = place;
		this.title = title;
		this.desc = desc;
		this.customer = customer;
	}

	public Activity(int iD, String date, String place, String title,
			String desc, Customer customer) {
		super();
		ID = iD;
		this.date = date;
		this.place = place;
		this.title = title;
		this.desc = desc;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
