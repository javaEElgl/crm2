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

<title>My JSP 'add.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function savecust(){
		var custname=document.getElementById("custname").value;
		var region=document.getElementById("region").value;
		var manager=document.getElementById("manager").value;
		var level=document.getElementById("level").value;
		var satisfy=document.getElementById("satisfy").value;
		var credit=document.getElementById("credit").value;
		var addr=document.getElementById("addr").value;
		var tel=document.getElementById("tel").value;
		var fax=document.getElementById("fax").value;
		var zip=document.getElementById("zip").value;
		var website=document.getElementById("website").value;
		var licenceid=document.getElementById("licenceid").value;
		var chieftain=document.getElementById("chieftain").value;
		var bankroll=document.getElementById("bankroll").value;
		var turnover=document.getElementById("turnover").value;
		var bank=document.getElementById("bank").value;
		var bankid=document.getElementById("bankid").value;
		var loaclid=document.getElementById("loaclid").value;
		var nationalid=document.getElementById("nationalid").value;
		if(custname==""){alert("客户名不能为空！");return;}
		if(region==0){alert("地区不能为空！");return;}
		if(manager==0){alert("客户经理不能为空！");return;}
		if(level==0){alert("客户等级不能为空！");return;}
		if(satisfy==0){alert("客户满意度不能为空！");return;}
		if(credit==0){alert("客户信用度不能为空！");return;}
		if(addr==""){alert("地址不能为空！");return;}
		var re1=/^(13[0-9]{9})|(15[89][0-9]{8})$/;
		var re2=/^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
		if(!re1.test(tel)&&!re2.test(tel)){alert("电话不合法！");return;}
		var re3=/^[0-9][0-9]{5}$/;
		if(!re3.test(zip)){alert("邮政编码不合法！");return;}
		if(fax==""){alert("传真不能为空！");return;}
		if(website==""){alert("网址不能为空！");return;}
		if(licenceid==""){alert("营业执照注册号不能为空！");return;}
		if(chieftain==""){alert("法人不能为空！");return;}
		if(bankroll==""){alert("注册资金不能为空！");return;}
		if(turnover==""){alert("年营业额不能为空！");return;}
		if(bank==""){alert("开户银行不能为空！");return;}
		if(bankid==""){alert("银行卡号不能为空！");return;}
		if(loaclid==""){alert("地税登记号不能为空！");return;}
		if(nationalid==""){alert("地税登记号不能为空！");return;}
		document.getElementById("form1").submit();
	}
	function checkcname(name){
		$.post("CheckCustNameServlet",{"name":name},function(data){
			if(data=="no"){
				document.getElementById("info1").innerHTML="<font color='red'>客户名已存在</font>";
				document.getElementById("b1").disabled=true;	
			}else{
			document.getElementById("info1").innerHTML="<font color='green'>客户名可用</font>";
				document.getElementById("b1").disabled=false;
			}
		});
	}
</script>
</head>
<body>
	<div class="page_title">客户信息管理 > 客户信息</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('添加客户信息');">帮助</button>
		<button class="common_button" onclick="back();">返回</button>
		<button class="common_button" onclick="savecust()" id="b1" type="button">保存</button>
	</div>
	<form action="AddCustServlet" method="post" id="form1">
	<table class="query_form_table">
		<tr>
			<th>客户编号</th>
			<td><input id="custno" readonly="readonly" name="custno"/>
			</td>
			<th>名称</th>
			<td><input name="custname" id="custname" onblur="checkcname(this.value)"/><span class="red_star" id="info1">*</span>
			</td>
		</tr>
		<tr>
			<th>地区</th>
			<td><select name="region" id="region">
					<option value="0">请选择...</option>
					<c:forEach items="${alist}" var="a">
						<option value="${a.d_item }">${a.d_item }</option>
					</c:forEach>
			</select> <span class="red_star">*</span>
			</td>
			<th>客户经理</th>
			<td>
			<select name="manager" id="manager">
			<option value="0">请选择</option>
			<c:forEach items="${ulist }" var="u">
						<option value="${u.userName }">${u.userName }</option>
			</c:forEach>
			</select>
			<span class="red_star">*</span></td>
		</tr>
		<tr>
			<th>客户等级</th>
			<td>
			<select name="level" id="level">
			<option value="0">请选择</option>
			<c:forEach items="${glist}" var="g">
						<option value="${g.d_item }">${g.d_item }</option>
					</c:forEach>
			</select>
			<span class="red_star">*</span></td>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<th>客户满意度</th>
			<td><select name="satisfy" id="satisfy"><option value="0">未指定</option>
					<option value="5">☆☆☆☆☆</option>
					<option value="4">☆☆☆☆</option>
					<option value="3">☆☆☆</option>
					<option value="2">☆☆</option>
					<option value="1">☆</option>
			</select><span class="red_star">*</span></td>
			<th>客户信用度</th>
			<td><select name="credit" id="credit">
			<option value="0">未指定</option>
					<option value="5">☆☆☆☆☆</option>
					<option value="4">☆☆☆☆</option>
					<option value="3">☆☆☆</option>
					<option value="2">☆☆</option>
					<option value="1">☆</option>
			</select><span class="red_star">*</span></td>
		</tr>
	</table>
	<br />
	<table class="query_form_table" id="table1">
		<tr>
			<th>地址</th>
			<td><input value="" name="addr" id="addr"/><span class="red_star">*</span></td>
			<th>邮政编码</th>
			<td><input name="zip" id="zip" size="20" /><span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>电话</th>
			<td><input name="tel" id="tel" size="20" /><span class="red_star">*</span>
			</td>
			<th>传真</th>
			<td><input name="fax" id="fax" size="20" /><span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>网址</th>
			<td><input name="website" id="website" size="20" /><span class="red_star">*</span>
			</td>
			<th></th>
			<td></td>
		</tr>
	</table>
	<br />
	<table class="query_form_table" id="table2">
		<tr>
			<th>营业执照注册号</th>
			<td><input value="" name="licenceid" size="20" id="licenceid"/>
			</td>
			<th>法人</th>
			<td><input name="chieftain" size="20" id="chieftain"/><span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>注册资金（万元）</th>
			<td><input value="" name="bankroll" size="20" id="bankroll"/></td>
			<th>年营业额</th>
			<td><input value="" name="turnover" size="20" id="turnover"/></td>
		</tr>
		<tr>
			<th>开户银行</th>
			<td><input value="" name="bank" size="20" id="bank"/><span
				class="red_star">*</span></td>
			<th>银行帐号</th>
			<td><input value="" name="bankid" size="20" id="bankid"/><span
				class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>地税登记号</th>
			<td><input value="" name="loaclid" size="20" id="loaclid"/>
			</td>
			<th>国税登记号</th>
			<td><input value="" name="nationalid" size="20" id="nationalid"/>
			</td>
		</tr>
	</table>
	</form>
</body>
<script type="text/javascript">
	$.post("GetNoServlet",function(data){
		document.getElementById("custno").value="NBKF000"+data;
	});
</script>
</html>
