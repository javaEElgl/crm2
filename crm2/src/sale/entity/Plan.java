//客户开发计划
package sale.entity;


public class Plan {
	private int id;   //计划编号
	private String date;  //日期
	private String todo;  //计划项目
	private String result;  //执行结果
	private Sale sale;  //销售机会
	
	
	public Plan() {
	}

	
	public Plan(int id, String date, String todo, String result, Sale sale) {
		this.id = id;
		this.date = date;
		this.todo = todo;
		this.result = result;
		this.sale = sale;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTodo() {
		return todo;
	}


	public void setTodo(String todo) {
		this.todo = todo;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public Sale getSale() {
		return sale;
	}


	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
}
