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

<title>My JSP 'user_add.jsp' starting page</title>

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
						document.getElementById("btn1").disabled=false;
					}else{
						document.getElementById("info1").style.color="red";
						document.getElementById("info1").innerHTML="用户名存在";
						document.getElementById("btn1").disabled=true;
					}
			});
		}
		function checkpwd(pwd){
			if(pwd==""){
				alert("密码不能为空！");
			}
		}
		function check(){
			var username=document.getElementById("username").value;
			if(username==""){
				alert("用户名不能为空！");
				return ;
			}
			var password=document.getElementById("password").value;
			if(password==""){
				alert("密码不能为空！");
				return ;
			}
			var role=document.getElementById("role").value;
			if(role==0){
				alert("请选择用户角色！");
				return ;
			}
			if(confirm("确认新建此用户？")){
		 		document.getElementById("form1").submit();				
			}else{
				return;
			}
		}
</script>
</head>
<body>

	<div class="page_title">用户管理&gt;新建用户</div>
	<div class="button_bar">
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="check();" id="btn1">保存</button>
	</div>
	<form action="AddUserServlet" method="post" id="form1">
		<table class="query_form_table">
			<tr>
				<th>用户名</th>
				<td><input type="text" name="username" id="username"
					onblur="checkname(this.value)" id="c1" /><span id="info1"
					class="red_star">*</span></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password"  name="password" id="password"
					onblur="checkpwd(this.value)" id="c2" /></td>
			</tr>
			<tr>
				<th>所属角色</th>
				<td><select name="role" id="role">
					<option value="0">请选择</option>
						<c:forEach items="${list }" var="l">
							<option value="${l.roleId }">${l.roleName }</option>
						</c:forEach>
				</select>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
