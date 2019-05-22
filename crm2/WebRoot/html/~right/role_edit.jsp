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

<title>My JSP 'role_edit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function checkall(ischecked) {
		var arr = document.getElementsByName("rightCode");
		for ( var i = 0; i < arr.length; i++) {
			arr[i].checked = ischecked;
		}
	}
	function uprights(){
		if(confirm("确认更改角色权限？")){
			document.getElementById("form1").submit();
		}else{
			return;
		}
	}
</script>
</head>
<body>
	<input id="roleright" value="<%=(String)request.getAttribute("right")%>" style="display: none;"/>
	<div class="page_title">角色授权管理&gt;修改角色权限</div>
	<div class="button_bar">
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="uprights();">保存</button>
	</div>
	<form action="EditRightServlet" method="post" id="form1">
		<table class="query_form_table">
			<tr>
				<th>编号</th>
				<td><input type="text" name="id"
					value="${r.roleId }"
					readonly="readonly" />
				</td>
				<th>角色名</th>
				<td><input type="text" name="roleName"
					value="${r.roleName }"
					readonly="readonly" id="c1" /><font id="info1"
					color="red"></font>
				</td>
			</tr>
			<tr>
				<th>授予权限</th>
				<td colspan="3"><br /> <input type="checkbox"
					onclick="checkall(this.checked)">[全部选择/取消全部 ]<br /> <br /> <input
					type="checkbox" name="rightCode" value="1">销售机会管理 <br /> <input
					type="checkbox" name="rightCode" value="2">客户开发计划<br /> <input
					type="checkbox" name="rightCode" value="3">客户信息管理<br /> <input
					type="checkbox" name="rightCode" value="4">客户流失管理<br /> <input
					type="checkbox" name="rightCode" value="5">服务创建<br /> <input
					type="checkbox" name="rightCode" value="6">服务分配<br /> <input
					type="checkbox" name="rightCode" value="7">服务处理<br /> <input
					type="checkbox" name="rightCode" value="8">服务反馈<br /> <input
					type="checkbox" name="rightCode" value="9">服务归档<br /> <input
					type="checkbox" name="rightCode" value="10">客户贡献分析<br /> <input
					type="checkbox" name="rightCode" value="11">客户构成分析<br /> <input
					type="checkbox" name="rightCode" value="12">客户服务分析<br /> <input
					type="checkbox" name="rightCode" value="13">客户流失分析<br /> <input
					type="checkbox" name="rightCode" value="14">数据字典管理<br /> <input
					type="checkbox" name="rightCode" value="15">查询产品信息<br /> <input
					type="checkbox" name="rightCode" value="16">查询库存<br /> <input
					type="checkbox" name="rightCode" value="17">用户管理<br /> <input
					type="checkbox" name="rightCode" value="18">角色授权管理<br /> <br />
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	var right=document.getElementById("roleright").value;
	var arr=right.split("-");
	var boxs=document.getElementsByName("rightCode");
	for(var i=0;i<arr.length-1;i++){
		if(arr[i]=="yes"){
			boxs[i].checked=true;
		}
	}
</script>
</html>
