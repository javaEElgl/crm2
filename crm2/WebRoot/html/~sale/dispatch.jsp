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

<title>My JSP 'dispatch.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function confdis(){
		var dueName=document.getElementById("dueName").value;
		if(dueName==0){
			alert("请选择指派人！");
			return;
		}
		if(confirm("确认指派？")){
			document.getElementById("form1").submit();
		}else{
			return;
		}
	}
</script>
</head>
<body>
	<div class="page_title">销售机会管理&nbsp; &gt; 指派销售机会</div>
	<div class="button_bar">
		<button class="common_button" onclick="help('');" type="button">帮助</button>
		<button class="common_button" onclick="back();" type="button">返回</button>
		<button class="common_button" type="button" onclick="confdis()">保存</button>
	</div>
	<form action="DispatchServlet" method="post" id="form1">
	<input name="action" value="dispatch" style="display: none;"/>
	<input name="sId" value="${s.id }" style="display: none;"/>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td></td>
			<th>机会来源</th>
			<td>${s.source }</td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td>${s.name }</td>
			<th>成功机率（%）</th>
			<td>&nbsp;${s.rate }</td>
		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3">${s.title }</td>
		</tr>
		<tr>
			<th>联系人</th>
			<td>${s.contact}</td>
			<th>联系人电话</th>
			<td>${s.phone }</td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3">${s.desc }</td>
		</tr>
		<tr>
			<th>创建人</th>
			<td>${s.createName }</td>
			<th>创建时间</th>
			<td>${s.createTime }</td>
		</tr>
	</table>
	<br />
	<table class="query_form_table" id="table1">
		<tr>
			<th>指派给</th>
			<td><select name="dueName" id="dueName"   onchange="zhipai(this.value)">
				<option value="0">请选择</option>
				<c:forEach items="${ulist }" var="u">
						<option value="${u.userName}"  ${u.userName eq s.dueName ? "selected" : ""}>${u.userName }</option>
				</c:forEach>
			</select><span class="red_star">*</span>
			</td>
			<th>指派时间</th>
			<td><input id="t2" name="dueTime" readonly size="20" /><span
				class="red_star">*</span>
			</td>
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript">
		var d=new Date();
		function zhipai(id){
			if(id==0){
					document.getElementById("t2").value="";
				}else{
				document.getElementById("t2").value=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+" "+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds();
				}
		}
</script>
</html>