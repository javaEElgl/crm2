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

<title>My JSP 'edit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
	function editsale(){
		var name=document.getElementById("name").value;
		if(name==""){
			alert("客户名不能为空！");
			return;
		}
		var contact=document.getElementById("contact").value;
		if(contact==""){
			alert("联系人不能为空！");
			return;
		}
		var phone=document.getElementById("phone").value;
		var re=/^(13[0-9]{9})|(15[89][0-9]{8})$/;
		if(!re.test(phone)){
			alert("手机号码格式不正确！");
			return;
		}
		var rate=document.getElementById("rate").value;
		if(rate==""){
			alert("请填写成功几率！");
			return;
		}
		var source=document.getElementById("source").value;
		if(source==""){
			alert("请填写机会来源！");
			return;
		}
		var title=document.getElementById("title").value;
		if(title==""){
			alert("请填写概要！");
			return;
		}
		if(confirm("确认保存吗？")){
			document.getElementById("form1").submit();
		}else{
			return;
		}
	}
</script>
</head>
<body>

	<div class="page_title">销售机会管理&nbsp; &gt; 编辑销售机会</div>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:alert('对销售机会进行更新编辑');" type="button">帮助</button>
		<button class="common_button" onclick="back();" type="button">返回</button>
		<button class="common_button" onclick="editsale()">保存</button>
	</div>
	<form action="EditSaleServlet" method="post" id="form1">
	<input name="action" value="edit" style="display: none;"/>
	<input name="id" value="${s.id }" style="display: none;"/>
	<table class="query_form_table">
		<tr>
			<th>编号</th>
			<td><input readonly disabled="disabled">
			</td>
			<th>机会来源</th>
			<td><input name="source" id="source" size="20" value="${s.source }"/>
			</td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td><input value="${s.name }" name="name" id="name"/><span class="red_star">*</span>
			</td>
			<th>成功机率（%）</th>
			<td><input value="${s.rate }" name="rate" id="rate"/><span class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3"><input value="${s.title }" name="title" size="52" id="title"/><span
				class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>联系人</th>
			<td><input name="contact" id="contact" value="${s.contact }" size="20" />
			</td>
			<th>联系人电话</th>
			<td><input name="phone" id="phone" value="${s.phone }" size="20" />
			</td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3"><textarea rows="6" cols="50" name="desc">${s.desc}</textarea><span
				class="red_star">*</span>
			</td>
		</tr>
		<tr>
			<th>创建人</th>
			<td><input name="createName" value="${s.createName }" readonly size="20" /><span
				class="red_star">*</span>
			</td>
			<th>创建时间</th>
			<td><input id="t1" name="createTime" value="${s.createTime }" readonly
				size="20" /><span class="red_star">*</span>
			</td>
		</tr>
	</table>
	<br />
	<table disabled class="query_form_table" id="table1">
		<tr>
			<th>指派给</th>
			<td><select name="appointUserId"  id="" onchange="zhipai(this.value)" disabled="disabled">
				<option value="0">请选择</option>
				<c:forEach items="${users }" var="u">
						<option value="${u.id }">${u.name }</option>
				</c:forEach>
			</select><span class="red_star">*</span>
			</td>
			<th>指派时间</th>
			<td><input id="t2" name="appointTime" readonly size="20"  disabled="disabled"/><span
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
			document.getElementById("t2").value=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
			}
		}
</script>
</html>