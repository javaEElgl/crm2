//销售机会
package sale.entity;

import java.util.ArrayList;
import java.util.List;





public class Sale {
	private int id;     //编号
	private String source;  //机会来源
	private String name;   //客户名称
	private String contact;  //联系人
	private String phone;      //联系电话
	private String title;   //概要
	private String rate;    //成功率
	private String desc;    //机会描述
	private String createName;   //机会创建人编号     
	private String createTime;  //创建时间
	private String dueName;     //被指派人编号
	private String dueTime;  //指派时间
	private int status;      //状态
	private List<Plan> plan = new ArrayList<Plan>();
	
	
	public Sale() {
	}

	
	public Sale(int id, String source, String name, String contact,
			String phone, String title, String rate, String desc,
			String createName, String createTime, String dueName,
			String dueTime, int status) {
		super();
		this.id = id;
		this.source = source;
		this.name = name;
		this.contact = contact;
		this.phone = phone;
		this.title = title;
		this.rate = rate;
		this.desc = desc;
		this.createName = createName;
		this.createTime = createTime;
		this.dueName = dueName;
		this.dueTime = dueTime;
		this.status = status;
	}


	public Sale(int id, String source, String name, String contact,
			String phone, String title, String rate, String desc,
			String createName, String createTime, String dueName,
			String dueTime) {
		super();
		this.id = id;
		this.source = source;
		this.name = name;
		this.contact = contact;
		this.phone = phone;
		this.title = title;
		this.rate = rate;
		this.desc = desc;
		this.createName = createName;
		this.createTime = createTime;
		this.dueName = dueName;
		this.dueTime = dueTime;
	}



	
	

	public Sale(int id,String source, String name, String contact, String phone,
			String title, String rate, String desc) {
		super();
		this.id=id;
		this.source = source;
		this.name = name;
		this.contact = contact;
		this.phone = phone;
		this.title = title;
		this.rate = rate;
		this.desc = desc;
	}


	public Sale(int id, String source, String name, String contact,
			String phone, String title, String rate, String desc,
			String createName, String createTime) {
		super();
		this.id = id;
		this.source = source;
		this.name = name;
		this.contact = contact;
		this.phone = phone;
		this.title = title;
		this.rate = rate;
		this.desc = desc;
		this.createName = createName;
		this.createTime = createTime;
	}


	public Sale(String name, String contact, String title) {
		super();
		this.name = name;
		this.contact = contact;
		this.title = title;
	}


	public Sale(String source, String name, String contact, String phone,
			String title, String rate, String desc, String createName,
			String createTime) {
		super();
		this.source = source;
		this.name = name;
		this.contact = contact;
		this.phone = phone;
		this.title = title;
		this.rate = rate;
		this.desc = desc;
		this.createName = createName;
		this.createTime = createTime;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getRate() {
		return rate;
	}


	public void setRate(String rate) {
		this.rate = rate;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public String getCreateName() {
		return createName;
	}


	public void setCreateName(String createName) {
		this.createName = createName;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public String getDueName() {
		return dueName;
	}


	public void setDueName(String dueName) {
		this.dueName = dueName;
	}


	public String getDueTime() {
		return dueTime;
	}


	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public List<Plan> getPlan() {
		return plan;
	}


	public void setPlan(List<Plan> plan) {
		this.plan = plan;
	}

	

}
