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

<title>My JSP 'activities_add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function saveactivity(){
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
		if(confirm("确定保存吗？")){
			document.getElementById("form1").submit();
		}else{
			return;
		}
	}
</script>
</head>
<body>
	<div class="page_title">客户信息管理 > 客户信息 > 交往记录 > 新建交往记录</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');" type="button">帮助</button>
		<button class="common_button" onclick="back();" type="button">返回</button>
		<button class="common_button" onclick="saveactivity()">保存</button>
	</div>
	<form action="AddActivitiesServlet" id="form1" method="post">
	<input name="id" value="${c.ID }" style="display: none;"/>
	<table class="query_form_table">
		<tr>
			<th>时间</th>
			<td><input type="date" name="date" id="date"><span class="red_star">*</span>
			</td>
			<th>地点</th>
			<td><input name="place" size="20" id="place"/><span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>概要</th>
			<td><input name="title" id="title"/><span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>详细信息</th>
			<td colspan="3"><textarea cols="50" rows="6" name="desc" id="desc"></textarea></td>
		</tr>
	</table>
	</form>
</body>
</html>