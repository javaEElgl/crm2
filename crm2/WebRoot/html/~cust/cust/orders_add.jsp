<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>新建订单</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">	
<script src="script/common.js"></script>
<script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function autoprice(name){
		$.post("AllProductServlet",{"name":name},function(data){
			var arr=data.split("-");
			var unit=arr[0];
			var price=arr[1];
			document.getElementById("unit").value=unit;
			document.getElementById("price").value=price;
		});
	}
	function total(count){
		var price=document.getElementById("price").value;
		if(price==""){
			alert("请先选择商品！");
			document.getElementById("count").value="";
			return;
		}else{
			var totalmoney=price*count;
			document.getElementById("money").value=totalmoney;
		}
	}
	function check(){
		var date=document.getElementById("date").value;
		var status=document.getElementById("status").value;
		var addr=document.getElementById("addr").value;
		var money=document.getElementById("money").value;
		var product=document.getElementById("product").value;
		var count=document.getElementById("count").value;
		var unit=document.getElementById("unit").value;
		var price=document.getElementById("price").value;
		if(addr==""){
			alert("请填写地址");
			return;
		}
		if(product==""){
			alert("请选择商品");
			return;
		}
		if(date==""||status==""||addr==""||money==""||product==""||count==""||unit==""||price==""){
			alert("信息不完整!");
			return ;
		}
		document.getElementById("form1").submit();
	}
</script>
</head>
<body>

<div class="page_title">客户信息管理 &gt;客户信息&gt;订单信息&gt;新建订单</div>
<div class="button_bar">
	<button class="common_button" onclick="to('AllCustServlet');" type="button">返回</button>
	<button class="common_button" onclick="check();">保存</button>  
</div>
<form action="AddOrderServlet" method="post" id="form1">
	<input name="id" value="${c.ID }" style="display: none;">
	<table class="query_form_table">
		<tr>
			<th>订单日期</th>
			<td>
				<input name="date" class="ooo" type="date" id="date"/><span id="info1" class="red_star">*</span>
			</td>
			<th>订单状态</th>
			<td>
				<select name="status" id="status">
					<option value="1">未回款</option>
					<option value="2">已回款</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>送货地址</th>
			<td><input name="addr" value="" id="addr"/></td>
			<th>总金额</th>
			<td><input name="money" readonly="readonly" id="money" /><span id="info2" class="red_star">*</span></td>
		</tr>	
		<tr>
			<th>商品</th>
			<td>
				<select name="product" onchange="autoprice(this.value)" id="product">
					<option value="0">请选择</option>
					<c:forEach items="${list }" var="l">
						<option value="${l.p_name }">${l.p_name }</option>
					</c:forEach>
				</select>
			</td>
			<th>数量</th>
			<td><input name="count"  id="count" onblur="total(this.value)" /><span id="info1" class="red_star">*</span></td>
		</tr>
		<tr>
			<th>单位</th>
			<td><input name="unit" value="" id="unit" readonly="readonly"/></td>
			<th>单价</th>
			<td><input name="price" value=""  id="price" readonly="readonly"/><span id="info2" class="red_star">*</span></td>
		</tr>
	</table>
</form>
</body>
</html>