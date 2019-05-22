<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>新增订单明细</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
</script>
</head>
<body>

<div class="page_title">客户信息管理 &gt;客户信息 &gt;历史订单 &gt;新增订单明细</div>
<div class="button_bar">
	<button class="common_button" onclick="back();">返回</button>  
	<button class="common_button" onclick="check();">保存</button>  
</div>
<form action="ordersline_add" method="post" id="form1">
	<table class="query_form_table">
		<tr>
			<th>商品</th>
			<td>
				<select name="ol.product">
					<option value="<s:property value='#v.name'/>"></option>
				</select>
			</td>
			<th>数量</th>
			<td><input name="count"  id="c1"/><span id="info1" class="red_star">*</span></td>
		</tr>
		<tr>
			<th>单位</th>
			<td><input name="unit" value="" /></td>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<th>单价</th>
			<td><input name="price" value="" id="c2"/><span id="info2" class="red_star">*</span></td>
			<th></th>
			<td></td>
		</tr>
	</table>
</form>
</body>
<script type="text/javascript">
	function totlemoney(count){
		
	}
</script>
</html>