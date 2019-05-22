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

<title>My JSP 'role_add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function check() {
		var rolename=document.getElementById("rolename").value;
		if(rolename==""){
			alert("角色名不能为空！");
			return ;
		}
		var rights=document.getElementsByName("rightCode");
		var falg=false;
		for(var i=0;i<rights.length;i++){
			if(rights[i].checked){
				falg=true;
				break;
			}
		}
		if(falg==false){
			alert("请选择角色权限！");
			return;
		}
		if(confirm("确认创建此角色？")){
			document.getElementById("form1").submit();		
		}else{
			return ;
		}
	
	}
	function checkall(ischecked) {
		var arr = document.getElementsByName("rightCode");
		for ( var i = 0; i < arr.length; i++) {
			arr[i].checked = ischecked;
		}
	}
	function checkname(name){
		if(name==""){
			alert("角色名不能为空！");
			return ;
		}
		$.post("CheckRoleNameServlet",{"rolename":name},function(data){
			if(data=="true"){
				document.getElementById("info1").color="green";
				document.getElementById("info1").innerHTML="角色名可用";
				document.getElementById("btn").disabled=false;
			}else{
				document.getElementById("info1").color="red";
				document.getElementById("info1").innerHTML="角色名存在";
				document.getElementById("btn").disabled=true;
			}
		});
	}
</script>
</head>
<body>

	<div class="page_title">角色授权管理&gt;新建角色</div>
	<div class="button_bar">
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="check();" id="btn" >保存</button>
	</div>
	<form action="AddRoleServlet" method="post" id="form1">
		<table class="query_form_table">
			<tr>
				<th>角色名</th>
				<td><input type="text" name="rolename" id="rolename"
					onblur="checkname(this.value)" id="c1" /><font id="info1"
					color="red"> *</font></td>
				<th></th>
				<td></td>
			</tr>
			<tr>
				<th>授予权限</th>
				<td colspan="3"><br /> <input type="checkbox"
					onclick="checkall(this.checked)">[全部选择/取消全部 ]<br /> <br />
					<input type="checkbox" name="rightCode" value="1">销售机会管理 <br />
					<input type="checkbox" name="rightCode" value="2">客户开发计划<br />
					<input type="checkbox" name="rightCode" value="3">客户信息管理<br />
					<input type="checkbox" name="rightCode" value="4">客户流失管理<br />
					<input type="checkbox" name="rightCode" value="5">服务创建<br />
					<input type="checkbox" name="rightCode" value="6">服务分配<br />
					<input type="checkbox" name="rightCode" value="7">服务处理<br />
					<input type="checkbox" name="rightCode" value="8">服务反馈<br />
					<input type="checkbox" name="rightCode" value="9">服务归档<br />
					<input type="checkbox" name="rightCode" value="10">客户贡献分析<br />
					<input type="checkbox" name="rightCode" value="11">客户构成分析<br />
					<input type="checkbox" name="rightCode" value="12">客户服务分析<br />
					<input type="checkbox" name="rightCode" value="13">客户流失分析<br />
					<input type="checkbox" name="rightCode" value="14">数据字典管理<br />
					<input type="checkbox" name="rightCode" value="15">查询产品信息<br />
					<input type="checkbox" name="rightCode" value="16">查询库存<br />
					<input type="checkbox" name="rightCode" value="17">用户管理<br />
					<input type="checkbox" name="rightCode" value="18">角色授权管理<br />
					<br /></td>
			</tr>
		</table>
	</form>
</body>
</html>
