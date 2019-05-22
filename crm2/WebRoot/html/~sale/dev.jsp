<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'dev.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>

</head>
<body>
	<form action="DevServlet" id="form1" method="post">
		<input name="action" value="some" style="display: none;" />
		<input name="name1" id=c1 value="${name }" style="display: none;" />
		<input name="title1" id="t1" value="${title }" style="display: none;" />
		<input name="contact1" id="c2" value="${contact }" style="display: none;" />
	<div class="page_title">客户开发计划</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('对客户进行有计划地开发');" type="button">帮助</button>
		<button class="common_button" type="submit">查询</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>客户名称</th>
			<td><input  name="name" /></td>
			<th>概要</th>
			<td><input name="title"/></td>
			<th>联系人</th>
			<td><input name="contact" size="20" />
			</td>
		</tr>
	</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>客户名称</th>
			<th>概要</th>
			<th>联系人</th>
			<th>联系人电话</th>
			<th>创建时间</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<% int i=((Integer)(request.getAttribute("page_index"))-1)*(Integer)(request.getAttribute("row_num")); %>
		<c:forEach items="${list }" var="l">
			<tr>
				<td class="list_data_number"><%=++i%></td>
				<td class="list_data_text">${l.name }</td>
				<td class="list_data_ltext">${l.title }</td>
				<td class="list_data_text">${l.contact}</td>
				<td class="list_data_text">${l.phone }</td>
				<td class="list_data_text">${l.createTime }</td>
				<c:choose>
					<c:when test="${l.status<=4 }">
						<td class="list_data_text">${l.status==1?'未指派':'已指派'}</td>
						<td class="list_data_op"><img
							onclick="makePlan('${l.id}','${l.status }')" title="制定计划"
							src="images/bt_plan.gif" class="op_button" /> <img
							onclick="executeplan('${l.id}','${l.status }')" title="执行计划"
							src="images/bt_feedback.gif" class="op_button" /> <img
							onclick="overplan('${l.id}','${l.status }');" title="开发成功"
							src="images/bt_yes.gif" class="op_button" />
						</td>
					</c:when>
					<c:when test="${l.status>4 }">
						<td class="list_data_text">已归档</td>
						<td class="list_data_op"><img
							onclick="to('DetailServlet?id=${l.id}');" title="查看"
							src="images/bt_detail.gif" class="op_button" /></td>
					</c:when>
				</c:choose>
			<tr>
		</c:forEach>
		<th colspan="10" class="pager">
			<div class="pager">
					共${total}条记录 每页<input value="${row_num }" size="2"
						onchange="changerownum(this.value)"/>条 第<input value="${page_index}" size="2" />页/共${page_num
					}页 <a href="javascript:firstpage('${action }')">第一页</a> <a
						href="javascript:changepage('${pre }','${action }')">上一页</a>
					<a href="javascript:changepage('${next }','${action }')">下一页</a>
					<a
						href="javascript:changepage('${page_num }','${action }')">最后一页</a>
					转到<input size="2" value="${page_index }" id="p1" />页
					<button width="20" onclick="gopage('${page_num}','${action }')">GO</button>
				</div>
		</th>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function changerownum(num){
		if(isNaN(num)){
			alert("请输入数字");
			return ;
		}
		if(confirm("确认更改显示行数？")){
			$.post("ChangeRowNumServlet",{"num":num},function(data){
				reload();
			});
		}else{
			return;
		}
	}
	function gopage(num) {
		var page = document.getElementById("p1").value;
		if (page > num || page < 1) {
			alert("页数不存在");
			return;
		} else {
			window.location.href = "DevServlet?page_index=" + page;
		}
	}
	function makePlan(id, status) {
		if (status == '1') {
			alert('该任务还没有指派！');
		} else {
			$.post("CheckExecuteServlet",{"id":id},function(data){
				if(data=="yes"){
					window.location.href = "MakePlanServlet?id=" + id;
				}else{
					alert("你不是该销售机会的处理人");
					return;
				}
			});
			
		}
	}
	function executeplan(id, status) {
		if (status == '1') {
			alert('该任务还没有指派！');
		} else if (status == '2') {
			alert('该任务还没有制定计划');
		} else {
			window.location.href = "DevExecuteServlet?id=" + id;
		}
	}
	function overplan(id, status) {
		if (status == '1') {
			alert('该任务还没有指派！');
		} else if (status == '2') {
			alert('该任务还没有制定计划！');
		} else if (status == '3') {
			alert('该任务的计划还没有被执行！');
		} else {
			window.location.href = "FinishSaleServlet?action=success&id=" + id;
		}
	}function firstpage(action){
		var c1=document.getElementById("c1").value;
		var t1=document.getElementById("t1").value;
		var c2=document.getElementById("c2").value;
		window.location.href="DevServlet?action="+action+"&name="+c1+"&title="+t1+"&contact="+c2;
	}
	function changepage(num,action){
		var c1=document.getElementById("c1").value;
		var t1=document.getElementById("t1").value;
		var c2=document.getElementById("c2").value;
		window.location.href="DevServlet?page_index="+num+"&action="+action+"&name="+c1+"&title="+t1+"&contact="+c2;
	}
	function gopage(num,action) {
		var page = document.getElementById("p1").value;
		if (page > num || page < 1) {
			alert("页数不存在");
			return;
		} else {
			window.location.href = "DevServlet?page_index=" + page+"&action="+action;
		}
	}
</script>
</html>
