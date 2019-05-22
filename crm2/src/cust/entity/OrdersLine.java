package cust.entity;


public class OrdersLine {
	private int ID;     //订单明细编号
	private int count;	//数量
	private String unit;  //单位
	private int price;   //价格
	private String product;  //产品；
	private Orders orders;  //取订单编号
	
	public OrdersLine() {
		// TODO Auto-generated constructor stub
	}
	
	
	public OrdersLine(int iD, int count, String unit, int price, String product) {
		super();
		ID = iD;
		this.count = count;
		this.unit = unit;
		this.price = price;
		this.product = product;
	}


	public OrdersLine(int iD, int count, String unit, int price,
			String product, Orders orders) {
		super();
		ID = iD;
		this.count = count;
		this.unit = unit;
		this.price = price;
		this.product = product;
		this.orders = orders;
	}


	public OrdersLine(int count, String unit, int price, String product) {
		super();
		this.count = count;
		this.unit = unit;
		this.price = price;
		this.product = product;
	}


	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
}
