<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'dict_edit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>
<form action="DictUpdateServlet">
	<div class="page_title">数据字典管理 > 编辑数据字典条目</div>
	<div class="button_bar">
		<button type="button" class="common_button" onclick="help('');">帮助</button>
		<button type="button" class="common_button" onclick="back();">返回</button>
		<button class="common_button">保存</button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td><input name="id" value="<%=request.getParameter("id")%>" readonly></td>
			<th>类别</th>
			<td><input name="type" value="<%=request.getParameter("type")%>"/><span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>条目</th>
			<td><input name="item" value="<%=request.getParameter("item")%>"/><span class="red_star">*</span>
			</td>
			<th>值</th>
			<td><input name="value" value="<%=request.getParameter("value")%>"/><span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>是否可编辑</th>
			<td><input type="checkbox" name="isedit" checked/>
			
			</td>
			<th>&nbsp;</th>
			<td>&nbsp;</td>
		</tr>
	</table>
</form>
</body>
</html>