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

<title>My JSP 'linkman.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
</head>
<body>

	<div class="page_title">客户信息管理 > 客户信息 > 联系人</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('显示客户联系人');">帮助</button>
		<button class="common_button"
			onclick="to('AddLinkServlet?action=before&id=${c.ID}');">新建</button>
		<button class="common_button" onclick="to('AllCustServlet');" type="button">返回</button>
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
			<th>姓名</th>
			<th>性别</th>
			<th>职位</th>
			<th>办公电话</th>
			<th>手机</th>
			<th>备注</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list }" var="l">
			<tr>
				<td class="list_data_text">${l.name }</td>
				<td class="list_data_ltext">${l.sex }</td>
				<td class="list_data_text">${l.postion }</td>
				<td class="list_data_text">${l.tel }</td>
				<td class="list_data_text">${l.phone }</td>
				<td class="list_data_op">${l.memo }</td>
				<td class="list_data_op"><img
					onclick="to('EditLinkServlet?action=before&id=${l.ID}&cid=${c.ID }');"
					title="编辑" src="images/bt_edit.gif" class="op_button" /> <img
					onclick="warn('${l.name}','${l.ID }',${c.ID });" title="删除" src="images/bt_del.gif"
					class="op_button" />
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
<script type="text/javascript">
	function warn(name,id,cid){
		if(window.confirm("确定删除联系人"+name+"?")){
			window.location.href="DeleteLinkServlet?id="+id+"&cid="+cid;
		}else{
		return ;
		}
	}
</script>
</html>
