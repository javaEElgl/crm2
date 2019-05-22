package cust.entity;

public class Servicer {
	private int ID;    //编号自增长
	private String type;   //服务类型
	private String title;   //概要
	private String custname;   //客户
	private int status;  //服务状态      1新创建 2已分配 
 	private String request;  //服务请求内容
	private String createBy;  //创建人
	private String createDate; //创建日期
	private String dueTo;   //分配给某人
	private String dueDate;  //分配时间
	private String deal;     //服务处理内容
	private String dealby;    //处理人
	private String dealDate;    //处理时间
	private String result;     //处理结果
	private int satisfy;      //满意度
	
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getDueTo() {
		return dueTo;
	}
	public void setDueTo(String dueTo) {
		this.dueTo = dueTo;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getDeal() {
		return deal;
	}
	public void setDeal(String deal) {
		this.deal = deal;
	}
	public String getDealby() {
		return dealby;
	}
	public void setDealby(String dealby) {
		this.dealby = dealby;
	}
	public String getDealDate() {
		return dealDate;
	}
	public void setDealDate(String dealDate) {
		this.dealDate = dealDate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getSatisfy() {
		return satisfy;
	}
	public void setSatisfy(int satisfy) {
		this.satisfy = satisfy;
	}
	
}
