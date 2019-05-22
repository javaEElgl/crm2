<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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

<title>My JSP 'relay.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function conf(id){
		window.location.href="ConfirmLostServlet1?action=before&id="+id;
	}
	function delay(){
		var delay=document.getElementById("delay").value;
		if(delay==""){
			alert("暂缓措施不能为空！");
			return;
		}
		if(confirm("确认保存？")){
			document.getElementById("form1").submit();
		}else{
			return;
		}
	}
</script>
</head>
<body>

	<div class="page_title">客户流失管理 &gt; 暂缓流失</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:暂缓客户流失;">帮助</button>

		<button class="common_button" onclick="to('AllLostServlet1');" type="button">返回</button>
		<button class="common_button" onclick="conf('${l.ID}')">确认流失</button>
		<button class="common_button" onclick="delay()">保存</button>
	</div>
	<form action="SaveRelayServlet" id="form1" method="post">
	<table class="query_form_table">
	<input  name="id"  value="${l.ID }" style="display: none;"/>
		<tr>
			<th>编号</th>
			<td>${l.ID }</td>
			<th>客户</th>
			<td>${l.customer }</td>
		</tr>
		<tr>
			<th>客户经理</th>
			<td>${l.manager }</td>
			<th>上次下单时间</th>
			<td>${l.orderdate }</td>
		</tr>
		<tr>
			<th>暂缓措施</th>
			<td colspan="3"><textarea rows="6" cols="50" readonly="readonly">${l.delay }</textarea></td>
		</tr>
		<tr>
			<th>追加暂缓措施</th>
			<td colspan="3"><textarea rows="6" cols="50"  id="delay" name="delay"></textarea><span
				class="red_star">*</span>
			</td>
		</tr>
	</table>
	</form>
	<br />
</body>
</html>