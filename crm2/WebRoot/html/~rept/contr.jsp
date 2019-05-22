<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>My JSP 'contr.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/crm2/js/highcharts.js"></script>
<script type="text/javascript">
	function baobiao(){
		var div1=document.getElementById("container");
		if(div1.style.display=="none"){
			div1.style.display="block";
		}else{
			div1.style.display="none";
		}
	}
</script>
</head>
<body>
	<form action="OrderListByConditionServlet" >
		<div class="page_title">客户贡献分析</div>
		<div class="button_bar">
			<button class="common_button" onclick="baobiao();" type="button">查看报表</button>
			<button class="common_button">查询</button>
		</div>
		<table class="query_form_table">
			<tr>
				<th>客户名称</th>
				<td><input name="customerName" /></td>
				<th>年份</th>
				<td><select name="orderYear" id="orderYear">
						<option value="all">全部</option>
				</select>
				</td>
			</tr>
		</table>
		<br />
		<table class="data_list_table">
			<tr>
				<th>编号</th>
				<th>客户名称</th>
				<th>订单金额（元）</th>
			</tr>
			<c:forEach items="${order }" var="o">
				<tr>
					<td class="list_data_number">${o.or_id}</td>
					<td class="list_data_ltext">${o.cst_name}</td>
					<td class="list_data_number">${o.or_money}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div id="container" style="width: 100%; height: 440px; display: none;" ></div>
</body>
<script type="text/javascript">
	var date=new Date();
	var year=date.getFullYear();
	var datesel=document.getElementById("orderYear");
	for(var i=year;i>=2000;i--){
		var op=new Option(i,i);
		datesel.add(op);
	}
	
	$(function() {
		var names = new Array();
		var moneys = new Array();
		var ids = new Array();
				$.post("GetContrServlet",function(data) {
							var jsondate = JSON.parse(data);
							for ( var i = 0; i < jsondate.length; i++) {
								names[i] = jsondate[i].cst_name;
								moneys[i] = jsondate[i].or_money;
								ids[i] = jsondate[i].or_id;
							}
							var chart = {
								type : 'column'
							};
							var title = {
								text : '客户贡献值'
							};
							var subtitle = {
								text : 'Source: runoob.com'
							};
							var xAxis = {
								categories : names,
								crosshair : true
							};
							var yAxis = {
								min : 0,
								title : {
									text : '贡献值（元）'
								}
							};
							var plotOptions = {
								column : {
									pointPadding : 0.2,
									borderWidth : 0,
									dataLabels: {
         								   enabled: true
       										 }
								}
							};
							var credits = {
								enabled : false
							};

							var series = [
									{
										name:'money',
										data:moneys
									} ];

							var json = {};
							json.chart = chart;
							json.title = title;
							json.subtitle = subtitle;
							json.xAxis = xAxis;
							json.yAxis = yAxis;
							json.series = series;
							json.plotOptions = plotOptions;
							json.credits = credits;
							$('#container').highcharts(json);
						})

	})
</script>
</html>