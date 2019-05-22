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

<title>My JSP 'confirm.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function conflost(name,id){
		if(confirm("确认流失客户"+name)){
			var reason=document.getElementById("reason").value;
			if(reason==""){
				alert("请填写流失原因");
				return;
			}
			var date=new Date();
			var lostdate=date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
			document.getElementById("lostdate").value=lostdate;
			document.getElementById("form1").submit();
		}else{
			return;
		}
	}
	function relay(id){
		window.location.href="RelayServlet1?action=after&id="+id;
	}
</script>
</head>
<body>

	<div class="page_title">客户流失管理 &gt; 确认流失</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('确认客户流失');">帮助</button>

		<button class="common_button" onclick="to('AllLostServlet1');">返回</button>
		<button class="common_button" onclick="relay('${l.ID}');" type="button">暂缓流失</button>
		<button class="common_button" onclick="conflost('${l.customer}','${l.ID }');">保存</button>
	</div>
	<form action="ConfirmLostServlet1" method="post" id="form1">
	<input  name="id"  value="${l.ID }" style="display: none;"/>
	<input  name="lostdate"  id="lostdate"  style="display: none;"/>
	<table class="query_form_table">
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
			<th>流失原因</th>
			<td colspan="3"><textarea rows="6" cols="50" id="reason" name="reason"></textarea><span
				class="red_star">*</span></td>
		</tr>
	</table>
	</form>
	<br />
</body>
</html>