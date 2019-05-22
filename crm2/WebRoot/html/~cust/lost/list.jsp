<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>My JSP 'list.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>
<script src="script/common.js"></script>
<script type="text/javascript">
		function query(){
			document.getElementById("form1").submit();
		} 
</script>
</head>
<body>

	<div class="page_title">客户流失管理</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('所有流失客户信息');">帮助</button>
		<button class="common_button" onclick="query();">查询</button>
	</div>
	<form action="AllLostServlet1" method="post" id="form1">
	<input type="hidden" value="some" name="action"/>
	<table class="query_form_table">
		<tr>
			<th>客户</th>
			<td><input id="custname" name="custname"/>
			</td>
			<th>客户经理</th>
			<td><input id="manager" name="manager"/>
			</td>
			<th>状态</th>
			<td><select id="status" name="status">
					<option value="all">全部</option>
					<option value="1">预警</option>
					<option value="2">暂缓流失</option>
					<option value="3">确认流失</option>
			</select></td>
		</tr>
	</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>客户</th>
			<th>客户经理</th>
			<th>上次下单时间</th>
			<th>确认流失时间</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<% int i=((Integer)(request.getAttribute("page_index"))-1)*(Integer)(request.getAttribute("row_num")); %>
		<c:forEach items="${list }" var="l">
			<tr>
			<td class="list_data_number"><%=++i%></td>
			<td class="list_data_text">${l.customer }</td>
			<td class="list_data_ltext">${l.manager }</td>
			<td class="list_data_text">${l.orderdate }</td>
			<td class="list_data_text">${l.lostdate }</td>
			<c:choose>
				<c:when test="${l.status==1 }">
				<td class="list_data_text">预警</td>
				<td class="list_data_op"><img onclick="to('ConfirmLostServlet1?action=before&id=${l.ID}')"
				title="确认流失" src="images/bt_confirm.gif" class="op_button" />
				<img onclick="to('RelayServlet1?action=after&id=${l.ID}');" title="暂缓流失"
				src="images/bt_relay.gif" class="op_button" />  <img
				onclick="to('LostDetailServlet?id=${l.ID}');" title="详情"
				src="images/bt_detail.gif" class="op_button" /></td>
				</c:when>
				<c:when test="${l.status==2 }">
				<td class="list_data_text">暂缓流失</td>
				<td class="list_data_op"><img onclick="to('ConfirmLostServlet1?action=before&id=${l.ID}')"
				title="确认流失" src="images/bt_confirm.gif" class="op_button" />
				<img onclick="to('RelayServlet1?action=after&id=${l.ID}');" title="暂缓流失"
				src="images/bt_relay.gif" class="op_button" /> <img
				onclick="to('LostDetailServlet?id=${l.ID}');" title="详情"
				src="images/bt_detail.gif" class="op_button" /></td>
				</c:when>
				<c:when test="${l.status==3 }">
				<td class="list_data_text">已经流失</td>
				<td class="list_data_op"> <img
				onclick="to('LostDetailServlet?id=${l.ID}');" title="详情"
				src="images/bt_detail.gif" class="op_button" /></td>
				</c:when>
			</c:choose>
		</tr>
		</c:forEach>
		<tr>
			<th colspan="7" class="pager">
				<div class="pager">
					共${total}条记录 每页<input value="${row_num }" size="2"
						readonly="readonly" />条 第<input value="${page_index}" size="2" />页/共${page_num
					}页 <a href="AllLostServlet1">第一页</a> <a
						href="AllLostServlet1?page_index=${pre }">上一页</a> <a
						href="AllLostServlet1?page_index=${next }">下一页</a> <a
						href="AllLostServlet1?page_index=${page_num }">最后一页</a> 转到<input
						size="2" value="${page_index }" id="p1" />页
					<button width="20" onclick="gopage('${page_num}')">GO</button>
				</div></th>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function gopage(num) {
		var page = document.getElementById("p1").value;
		if (page > num || page < 1) {
			alert("页数不存在");
			return;
		} else {
			window.location.href = "AllLostServlet1?page_index=" + page;
		}
	}
</script>
</html>
