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

<title>My JSP 'user_edit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
		function checkname(name){
			$.post("CheckUserNameServlet",{"username":name},function(data){
					if(data=="yes"){
						document.getElementById("info1").style.color="green";
						document.getElementById("info1").innerHTML="用户名可用";
					}else{
						document.getElementById("info1").style.color="red";
						document.getElementById("info1").innerHTML="用户名存在";
					}
			});
		}
		function checkpwd(pwd){
			if(pwd==""){
				alert("密码不能为空！");
			}
		}
		function upuser(){
			if(confirm("确认修改用户信息？")){
				document.getElementById("form1").submit();
			}else{
				return;
			}
		}
</script>
</head>
<body>
	<div class="page_title">用户管理&gt;修改用户</div>
	<div class="button_bar">
		<button class="common_button" onclick="back();" type="button">返回</button>
		<button class="common_button" onclick="upuser()">保存</button>
	</div>
	<form action="EditUserServlet" method="post" id="form1">
	<input name="id" value="${user.userId }" style="display: none;"/>
		<table class="query_form_table">
			<tr>
				<th>用户名</th>
				<td><input type="text"
					value="${user.userName }"
					name="username" onblur="checkname(this.value)" id="c1" /><span
					id="info1" class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password"
					value="${user.passWord }" onblur="checkpwd(this.value)"
					name="password"  id="c2" /><span
					id="info2" class="red_star">*</span>
				</td>
			</tr>
			<tr>
				<th>所属角色</th>
				<td><select name="role">
					<c:forEach items="${rlist }" var="r">
						<option value="${r.roleId }" ${r.roleId==user.role.roleId ?"selected":""}>${r.roleName }</option>
					</c:forEach>
				</select></td>
			</tr>
		</table>
	</form>
</body>
</html>
