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

<title>My JSP 'detail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

	<div class="page_title">客户流失管理 &gt; 详情</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('客户流失详情');">帮助</button>

		<button class="common_button" onclick="back();">返回</button>

	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td>${l.ID }</td>
			<th>客户</th>
			<td>${l.customer }</td>
		</tr>
		<tr>
			<th>客户经理</th>
			<td>${l.manager }</td>
			<th>上次下单时间</th>
			<td>${l.orderdate }</td>
		</tr>
		<tr>
			<th>暂缓措施</th>
			<td colspan="3"><textarea rows="6" cols="50">${l.delay }</textarea></td>
		</tr>
		<tr>
			<th>流失原因</th>
			<td colspan="3">${l.reason }</td>
		</tr>
	</table>
	<br />
</body>
</html>