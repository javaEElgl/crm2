<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'cons.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<form action="LevelBySelectServlet">
	<div class="page_title">客户构成分析</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('客户构成分析')">帮助</button>
		<button class="common_button">查询</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>报表方式</th>
			<td><select name="level">
					<option value="1">按等级</option>
					<option value="2">按信用度</option>
					<option value="3">按满意度</option>
			</select></td>
			<th>&nbsp;</th>
			<td>&nbsp;</td>
		</tr>
	</table>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>等级</th>
			<th>客户数量</th>
		</tr>
		<%int i=1;%>
		<c:forEach items="${level}" var="l">
		<tr>
			<td class="list_data_number"><%=i++%></td>
			<td class="list_data_text">${l.cst_level}</td>
			<td class="list_data_number">${l.cst_name}</td>
		</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>
