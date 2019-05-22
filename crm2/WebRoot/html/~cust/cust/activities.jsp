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

<title>My JSP 'activities.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function warn(id,cid){
		if(confirm("确认删除此交往记录？")){
			window.location.href="DeleteActServlet?id="+id+"&cid="+cid;
		}else{
			return;
		}
	}
</script>
</head>
<body>
	<div class="page_title">客户信息管理 &gt; 客户信息 &gt; 交往记录</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('客户相关的交往记录');">帮助</button>
		<button class="common_button"
			onclick="to('AddActivitiesServlet?action=before&id=${c.ID}');">新建</button>
		<button class="common_button" onclick="to('AllCustServlet')" type="button">返回</button>
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
			<th width="232">时间</th>
			<th>地点</th>
			<th>概要</th>
			<th>详细信息</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="l">
			<tr>
				<td class="list_data_text" width="230">${l.date }</td>
				<td class="list_data_text">${l.place }</td>
				<td class="list_data_ltext">${l.title }</td>
				<td class="list_data_ltext">${l.desc }</td>
				<td class="list_data_op"><img
					onclick="to('EditActServlet?action=before&id=${l.ID}&cid=${c.ID }');"
					title="编辑" src="images/bt_edit.gif" class="op_button" /> <img
					onclick="warn('${l.ID}','${c.ID }')" title="删除" src="images/bt_del.gif"
					class="op_button" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>