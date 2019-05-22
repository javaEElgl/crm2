<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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

    <title>新建数据字典条目</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <script src="script/common.js"></script>
    <script type="text/javascript" src="/crm2/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
    	function fanhui(){
    		window.location.href="DictServlet";
    	}
    	function checktype(type){
    	var type2=document.getElementById("type2").value;
    		if(type2=="其它"){
    			if(confirm("确认新建其它类别？")){
    				document.getElementById("type2").style.display="none";
    				document.getElementById("type1").style.visibility="visible";
    			}else{
    				document.getElementById("type2").value="0";
    			}
    		}
    	}
    	function savedict(){
    		var type2=document.getElementById("type2").value;
    		if(type2=="0"){
    			alert("类别不能为空！");
    			return;
    		}
    		if(type2=="其它"){
    			var type1=document.getElementById("type1").value;
    			if(type1.length<=1){
    				alert("类别不合法！");
    				return ;
    			}
    			document.getElementById("type").value=type1;
    		}else{
    			document.getElementById("type").value=type2;    		
    		}
    		var item=document.getElementById("item").value;
    		var value=document.getElementById("value").value;
    		if(item==""){
    			alert("条目不能为空！");
    			return ;
    		}
    		if(value==""){
    			alert("值不能为空！");
    			return ;
    		}
    		if(confirm("确认保存？")){
    			document.getElementById("form1").submit();
    		}else{
    			return ;
    		}
    	}
    </script>
</head>
<body>

    <div class="page_title">数据字典管理 > 新建数据字典条目</div>
    <div class="button_bar">
        <button type="button" class="common_button" onclick="javascript:alert('新建数据字典条目')">帮助</button>
        <button type="button" class="common_button" onclick="fanhui()">返回</button>
        <button class="common_button" onclick="savedict();">保存</button>
    </div>
    <form action="DictAddServlet" id="form1">
    <input name="type" id="type" style="display: none;">
    <table class="query_form_table">
        <tr>
            <th>编号</th>
            <td><input readonly value="自动填写" disabled="disabled"/>
            </td>
            <th>类别</th>
            <td><select id="type2" name="type2" onchange="checktype(this.value);">
     			<option value="0">请选择</option>
            </select><input name="type1" id="type1" style="visibility:hidden;"/><span class="red_star">*</span></td>
        </tr>
        <tr>
            <th>条目</th>
            <td><input name="item" id="item"/><span class="red_star">*</span>
            </td>
            <th>值</th>
            <td><input name="value" id="value"/><span class="red_star">*</span>
            </td>
        </tr>
        <tr>
            <th>是否可编辑</th>
            <td><input name="isedit" type="checkbox" checked/>
            </td>
            <th>&nbsp;</th>
            <td>&nbsp;</td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
	$.post("AjaxTypeServlet",function(data){
    			var sel=document.getElementById("type2");
    			var jsondata=JSON.parse(data);
    			for(var i=0;i<jsondata.length;i++){
    				var op=new Option(jsondata[i],jsondata[i]);
    				sel.add(op);
    			}
    			var op=new Option("其它","其它");
    			sel.add(op);
    		})
</script>
</html>
