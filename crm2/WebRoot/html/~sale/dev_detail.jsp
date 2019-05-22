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

<title>My JSP 'dev_detail.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

	<div class="page_title">客户开发计划 &gt; 查看</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('客户开发过程的详细信息');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td></td>
			<th>机会来源</th>
			<td>${s.source }</td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td>${s.name }</td>
			<th>成功机率（%）</th>
			<td>&nbsp;${s.rate}</td>
		</tr>
		<tr>
			<th>概要</th>
			<td>${s.title }</td>
			<th>状态</th>
			<c:choose>
				<c:when test="${s.status==5 }">
					<td style="color:red;">开发失败</td>
				</c:when>
				<c:when test="${s.status==6}">
					<td style="color:green;">开发成功</td>
				</c:when>
			</c:choose>
		</tr>
		<tr>
			<th>联系人</th>
			<td>${s.contact }</td>
			<th>联系人电话</th>
			<td>${s.phone }</td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3">${s.desc }</td>
		</tr>
		<tr>
			<th>创建人</th>
			<td>${s.createName }</td>
			<th>创建时间</th>
			<td>${s.createTime }</td>
		</tr>
		<tr>
			<th>指派给</th>
			<td>${s.dueName }</td>
			<th>指派时间</th>
			<td>${s.dueTime }</td>
		</tr>
	</table>
	<br />
	<table class="data_list_table" id="table1">
		<tr>
			<th>日期</th>
			<th>计划</th>
			<th>执行效果</th>
		</tr>
			<c:forEach items="${s.plan }" var="p">
				<tr>
				<td class="list_data_text">${p.date }</td>
				<td class="list_data_ltext">${p.todo }</td>
				<td class="list_data_ltext">${p.result }</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>