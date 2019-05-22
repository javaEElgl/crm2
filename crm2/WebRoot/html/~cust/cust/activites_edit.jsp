<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>My JSP 'activites_edit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function updateact(){
		var date=document.getElementById("date").value;
		var place=document.getElementById("place").value;
		var title=document.getElementById("title").value;
		var desc=document.getElementById("desc").value;
		if(date==""){
			alert("时间不能为空！");
			return ;
		}
		if(place==""){
			alert("地点不能为空！");
			return ;
		}
		if(title==""){
			alert("概要不能为空！");
			return ;
		}
		if(desc==""){
			alert("详情不能为空！");
			return ;
		}
		if(confirm("确认更改？")){
			document.getElementById("form1").submit();
		}else{
			return;
		}
	}
</script>
</head>
<body>
	<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录 &gt; 编辑交往记录</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');">帮助</button>
		<button class="common_button" onclick="back();" type="button">返回</button>
		<button class="common_button" onclick="updateact();">保存</button>
	</div>
	<form action="EditActServlet" method="post" id="form1">
	<input name="id" value="${a.ID }" style="display: none;">
	<input name="cid" value="${c.ID }" style="display: none;">
	<table class="query_form_table" id="table1">
		<tr>
			<th>时间</th>
			<td><input name="date" id="date" value="${a.date }" size="20" type="date" /><span
				class="red_star">*</span>
			</td>
			<th>地点</th>
			<td><input name="place" id="place" value="${a.place }" size="20" /><span
				class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>概要</th>
			<td><input name="title" id="title" value="${a.title }" size="20" /><span
				class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>详细信息</th>
			<td colspan="3"><textarea cols="50" rows="6" name="desc" id="desc">${a.desc }</textarea>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
