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

<title>My JSP 'orders.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

	<div class="page_title">客户信息管理 > 客户信息 > 历史订单</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('查看历史订单');">帮助</button>
		<button class="common_button" onclick="to('AddOrderServlet?action=before&id=${c.ID}');">新建</button>
		<button class="common_button" onclick="to('AllCustServlet')">返回</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>客户编号</th>
			<td>${c.no }</td>
			<th>客户名称</th>
			<td>${c.name }</td>
		</tr>
	</table>
	<br />
	<table class="data_list_table">
		<tr>
			<th>订单编号</th>
			<th>日期</th>
			<th>送货地址</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="l">
			<tr>
			<td class="list_data_text">${l.ID }</td>
			<td class="list_data_text">${l.date }</td>
			<td class="list_data_text">${l.addr }</td>
			<td class="list_data_text">${l.status==1 ?"未回款":"已回款" }</td>
			<td class="list_data_op"><img
				onclick="to('OrderDetailServlet?id=${l.ID}');" title="查看明细"
				src="images/bt_detail.gif" class="op_button" />
			</td>
		</tr>
		</c:forEach>
		<tr>
			<th colspan="100" class="pager">
				<div class="pager">
					共${total}条记录 每页<input value="${row_num }" size="2"
						readonly="readonly" />条 第<input value="${page_index}" size="2" />页/共${page_num
					}页 <a href="AllOrdersServlet?id=${c.ID}">第一页</a> <a
						href="AllOrdersServlet?page_index=${pre }&id=${c.ID}">上一页</a> <a
						href="AllOrdersServlet?page_index=${next }&id=${c.ID}">下一页</a> <a
						href="AllOrdersServlet?page_index=${page_num }&id=${c.ID}">最后一页</a> 转到<input
						size="2" value="${page_index }" id="p1" />页
					<button width="20" onclick="gopage('${page_num}','${c.ID }')">GO</button>
				</div></th>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function gopage(num,id) {
		var page = document.getElementById("p1").value;
		if (page > num || page < 1) {
			alert("页数不存在");
			return;
		} else {
			window.location.href = "AllOrdersServlet?page_index=" + page+"&id=${c.ID}";
		}
	}
</script>
</html>