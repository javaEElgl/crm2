<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改订单</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
function check(){
	if(ck_null('c1','info1')&&ck_number('c2','info2')){
		dosubmit('form1');
	}
}
</script>
</head>
<body>

<div class="page_title">客户信息管理 &gt;客户信息&gt;订单信息&gt;修改订单</div>
<div class="button_bar">
	<button class="common_button" onclick="back();">返回</button>
	<button class="common_button" onclick="check();">保存</button>  
</div>
<form action="orders_update" method="post" id="form1">
	<table class="query_form_table">
		<tr>
			<th>订单日期</th>
			<td>
				<input name="o.ID" value="${request.editorders.ID}" readonly style="display:none" />
				<input name="o.date" value="${request.editorders.date}" onblur="ck_null('c1','info1')" id="c1"/><span id="info1" class="red_star">*</span>
			</td>
			<th>订单状态</th>
			<td>
				<select name="o.status">
					<option value="1">未回款</option>
					<option value="2">已回款</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>送货地址</th>
			<td><input name="o.addr" value="${request.editorders.addr}" /></td>
			<th>总金额</th>
			<td><input name="o.money" value="${request.editorders.money}" onblur="ck_number('c2','info2')" id="c2"/><span id="info2" class="red_star">*</span></td>
		</tr>	
	</table>
</form>
</body>
</html>