<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>订单明细</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

<div class="page_title">客户信息管理 &gt;客户信息 &gt;历史订单 &gt;订单明细</div>
<div class="button_bar">
	<button class="common_button" onclick="back();">返回</button>  
</div>
<table class="query_form_table">
	<tr>
		<th>订单编号</th>
		<td>${session.editorders.ID}</td>
		<th>日期</th>
		<td>${session.editorders.date}</td>
	</tr>
	<tr>
		<th>送货地址</th>
		<td>${session.editorders.addr}</td>
		<th>状态</th>
		<s:if test="#session.editorders.status == 1">
			<td>未回款</td>
		</s:if>
		<s:elseif test="#session.editorders.status == 2">
			<td>已回款</td>
		</s:elseif>
	</tr>
</table>
<br />
<table class="data_list_table">
	<tr>
		<th>商品</th>
		<th>数量</th>
		<th>单位</th>
		<th>单价（元）</th>
	</tr>
	<s:iterator var="v" value="session.orderslinelist">
		<tr>
			<td class="list_data_text"><s:property value="#v.product"/></td>
			<td class="list_data_ltext"><s:property value="#v.count"/></td>
			<td class="list_data_text"><s:property value="#v.unit"/></td>
			<td class="list_data_text"><s:property value="#v.price"/></td>
		</tr>
	</s:iterator>
	</table>
</body>
</html>