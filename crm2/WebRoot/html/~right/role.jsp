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

<title>My JSP 'role.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript"></script>
<script type="text/javascript">
	function warn(id){
		if(confirm('确实要删除该内容吗?')){
			location.href="DeleteRoleServlet?id="+id;
		}else{
			return;
		}
	}
	function show(){
		document.getElementById("form1").submit();
	}
</script>
</head>
<body>
	<div class="page_title">角色授权管理</div>
	<div class="button_bar">
		<button class="common_button" onclick="to('html/~right/role_add.jsp');">新建角色</button>
		<button class="common_button" onclick="show();">查询</button>
	</div>
	<form action="AllRoleServlet" method="post" id="form1">
	<input name="action" value="some" style="display: none;">
		<table class="query_form_table">
			<tr>
				<th>角色名</th>
				<td><input type="text" name="rolename" />
				</td>
				<th></th>
				<td></td>
			</tr>
		</table>
	</form>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>角色名</th>
			<th>操作</th>
		</tr>
		<% int i=((Integer)(request.getAttribute("page_index"))-1)*(Integer)(request.getAttribute("row_num")); %>
		<c:forEach items="${list }" var="r">
			<tr>
				<td class="list_data_number"><%=++i %></td>
				<td class="list_data_text">${r.roleName }
				</td>
				<td class="list_data_op"><img
					onclick="to('EditRightServlet?action=before&id=${r.roleId}');"
					title="编辑权限" src="images/bt_edit.gif" class="op_button" /> 
					<img onclick="warn(${r.roleId});"  title="删除角色"
						src="images/bt_del.gif" class="op_button" />
					</td>
			</tr>
		</c:forEach>
			
	</table>
	<form action="role_page" method="post">
		<table class="data_list_table">
				<tr>
					<th colspan="6" class="pager">
						<div class="pager">
					共${total}条记录 每页<input value="${row_num }" size="2"
						readonly="readonly" />条 第<input value="${page_index}" size="2" />页/共${page_num
					}页 <a href="AllRoleServlet">第一页</a> <a
						href="AllRoleServlet?page_index=${pre }">上一页</a> <a
						href="AllRoleServlet?page_index=${next }">下一页</a> <a
						href="AllRoleServlet?page_index=${page_num }">最后一页</a> 转到<input
						size="2" value="${page_index }" id="p1" />页
					<button width="20" onclick="gopage('${page_num}')">GO</button>
				</div></th>
				</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function gopage(num) {
		var page = document.getElementById("p1").value;
		if (page > num || page < 1) {
			alert("页数不存在");
			return;
		} else {
			window.location.href = "AllRoleServlet?page_index=" + page;
		}
	}
</script>
</html>
