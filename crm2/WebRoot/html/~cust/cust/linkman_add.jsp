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

<title>My JSP 'linkman_add.jsp' starting page</title>

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
		if(name==""){
			alert("名字不能为空！");
			return;
		}
		$.post("CheckLinkNameServlet",{"name":name},function(data){
		if(data=="no"){
			if(confirm("您确定要非员工做为联系人吗？")){
				document.getElementById("position").value="临时工";
				return;
			}else{
				document.getElementById("linkname").value="";
			}
		}else{
			var arr=data.split("-");
			document.getElementById("position").value=arr[1];
		}		
		});
	}
	function savelink(){
		var name=document.getElementById("linkname").value;
		var position=document.getElementById("position").value;
		if(name==""){
			alert("联系人姓名不能为空！");
			return;
		}
		var tel=document.getElementById("tel").value;
		var phone=document.getElementById("phone").value;
		var re1=/^(13[0-9]{9})|(15[89][0-9]{8})$/;
		var re2=/^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
		if(!re2.test(tel)){
			alert("办公电话不合法！");
			return ;
		}
		if(!re1.test(phone)){
			alert("手机格式不合法！");
			return;
		}
		if(confirm("确认保存此联系人？")){
			document.getElementById("form1").submit();
		}else{
			return;
		}
	}
</script>
</head>
<body>
	
	<div class="page_title">客户信息管理 > 客户信息 > 联系人 > 新建联系人</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('创建客户联系人');" type="button">帮助</button>
		<button class="common_button" onclick="to('AllCustServlet');" type="button">返回</button>
		<button class="common_button" onclick="savelink()">保存</button>
	</div>
	<form action="AddLinkServlet" method="post" id="form1">
	<input name="id" id="id" value="${id }" style="display: none;"/>
	<table class="query_form_table">
		<tr>
			<th>姓名</th>
			<td><input name="linkname" id="linkname" onblur="checkname(this.value)"/><span class="red_star">*</span>
			</td>
			<th>性别</th>
			<td><input type="radio" name="sex" value="女" checked />男 <input
				type="radio" name="sex" value="男"/>女</td>
		</tr>
		<tr>
			<th>职位</th>
			<td><input name="position" id="position" readonly="readonly"/><span class="red_star">*</span>
			</td>
			<th>办公电话</th>
			<td><input name="tel" id="tel"/><span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>手机</th>
			<td><input name="phone" id="phone" size="20" />
			</td>
			<th>备注</th>
			<td><input name="memo" id="memo" size="20" />
			</td>
		</tr>
	</table>
	</form>
</body>
</html>