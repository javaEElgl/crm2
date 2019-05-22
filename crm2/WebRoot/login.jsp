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

<title>My JSP 'login.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<TITLE>巨人CRM用户登录页面</TITLE>
<LINK href="css/login.css" type=text/css rel=stylesheet>
<SCRIPT type=text/javascript>
<!--
	if (self != top) {
		top.location = self.location;
	}
	function ShowSoftKeyboard(obj) {
		if ((typeof (CheckLoaded) == "function")) {
			password1 = obj;
			showkeyboard();
			Calc.password.value = '';
		} else {
			return false;
		}
	}
// -->
</SCRIPT>

<SCRIPT src="js/softkeyboard.js" type=text/javascript></SCRIPT>
</HEAD>
<BODY id=loginbody>
	<FORM
		onkeypress="javascript:return WebForm_FireDefaultButton(event, 'IbtnEnter')"
		id=LoginForm name=LoginForm
		onsubmit="javascript:return WebForm_OnSubmit();"
		action="LoginServlet" method="post">
		<DIV>
			<INPUT id=__LASTFOCUS type=hidden name=__LASTFOCUS> <INPUT
				id=__EVENTTARGET type=hidden name=__EVENTTARGET> <INPUT
				id=__EVENTARGUMENT type=hidden name=__EVENTARGUMENT> <INPUT
				id=__VIEWSTATE type=hidden
				value=/wEPDwUKMTc0MjM4MjQyOQ9kFgICAw9kFgYCDQ8PFgIeEUNvbnRyb2xUb1ZhbGlkYXRlBQgyeDZ2MmwwZGRkAg8PDxYCHwAFCXg2djJsMGRicGRkAhEPDxYCHwAFCjZ2MmwwZGJwYjZkZGSXCNRTILTPFj9FnbWqgDCvRZ/FaA==
				name=__VIEWSTATE>
		</DIV>
		<SCRIPT type=text/javascript>
			//         
			var theForm = document.forms['LoginForm'];
			if (!theForm) {
				theForm = document.LoginForm;
			}
			function __doPostBack(eventTarget, eventArgument) {
				if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
					theForm.__EVENTTARGET.value = eventTarget;
					theForm.__EVENTARGUMENT.value = eventArgument;
					theForm.submit();
				}
			}
			//
		</SCRIPT>

		<SCRIPT src="js/WebResource.axd" type=text/javascript></SCRIPT>

		<SCRIPT src="js/WebResource(1).axd" type=text/javascript></SCRIPT>

		<SCRIPT type=text/javascript>
			//         
			function WebForm_OnSubmit() {
				if (typeof (ValidatorOnSubmit) == "function"
						&& ValidatorOnSubmit() == false)
					return false;
				return true;
			}
			//
		</SCRIPT>

		<DIV>
			<INPUT id=__EVENTVALIDATION type=hidden
				value=/wEWBQKljpevCQKsh5n9AQKkmrOfCgK0xajLAQKtiIODCgydmXfcaiQuZlfCHFSTsvZ8eoVR
				name=__EVENTVALIDATION>
		</DIV>
		<DIV id=wrap>
			<DIV id=loginBox>
				<H1>用户登录</H1>
				<H2>用户登录</H2>
				<UL>
					<LI><font size="2">欢迎使用客户关系管理系统！</font>
					</LI>
					<LI><LABEL for=TxtUserName>用 户 名：</LABEL> <INPUT class=inText
						id=2x6v2l0d style="FONT-FAMILY: 宋体" maxLength=20 name="username"
						EnableMultiStyle="false"></LI>
					<LI><LABEL for=TxtPassword>密 &nbsp;&nbsp;&nbsp; 码：</LABEL> <INPUT class=inText
						id=x6v2l0dbp type=password maxLength=20 name="password"
						EnableMultiStyle="false"></LI>
				</UL>
				<DIV id=buttonBar>
					<INPUT class=loginButton id=IbtnEnter onclick='javascript:WebForm_DoPostBackWithOptions(new WebForm_PostBackOptions("IbtnEnter", "", true, "", "LoginServlet", false, false))'
						type=submit value="" name=IbtnEnter>
				</DIV>
				<DIV class=errorMsg></DIV>
				<P id=copyRight>CRM客户管理系统</P>
			</DIV>
		</DIV>
		<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN><SPAN
			id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN><SPAN
			id=ValrAdminValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
		<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>
		<SCRIPT type=text/javascript>
			//         
			var Page_ValidationSummaries = new Array(document
					.getElementById("ValidationSummary1"));
			var Page_Validators = new Array(document
					.getElementById("ValrUserName"), document
					.getElementById("ValrPassword"), document
					.getElementById("ValrAdminValidateCode"));
			//
		</SCRIPT>

		<SCRIPT type=text/javascript>
			//         
			var ValrUserName = document.all ? document.all["ValrUserName"]
					: document.getElementById("ValrUserName");
			ValrUserName.controltovalidate = "2x6v2l0d";
			ValrUserName.focusOnError = "t";
			ValrUserName.errormessage = "请输入用户名！";
			ValrUserName.display = "None";
			ValrUserName.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
			ValrUserName.initialvalue = "";
			var ValrPassword = document.all ? document.all["ValrPassword"]
					: document.getElementById("ValrPassword");
			ValrPassword.controltovalidate = "x6v2l0dbp";
			ValrPassword.focusOnError = "t";
			ValrPassword.errormessage = "请输入密码！";
			ValrPassword.display = "None";
			ValrPassword.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
			ValrPassword.initialvalue = "";
			var ValrAdminValidateCode = document.all ? document.all["ValrAdminValidateCode"]
					: document.getElementById("ValrAdminValidateCode");
			ValrAdminValidateCode.controltovalidate = "6v2l0dbpb6";
			ValrAdminValidateCode.focusOnError = "t";
			ValrAdminValidateCode.errormessage = "";
			ValrAdminValidateCode.display = "None";
			ValrAdminValidateCode.evaluationfunction = "RequiredFieldValidatorEvaluateIsValid";
			ValrAdminValidateCode.initialvalue = "";
			var ValidationSummary1 = document.all ? document.all["ValidationSummary1"]
					: document.getElementById("ValidationSummary1");
			ValidationSummary1.showmessagebox = "True";
			ValidationSummary1.showsummary = "False";
			//
		</SCRIPT>

		<SCRIPT type=text/javascript>
			//         

			var Page_ValidationActive = false;
			if (typeof (ValidatorOnLoad) == "function") {
				ValidatorOnLoad();
			}

			function ValidatorOnSubmit() {
				if (Page_ValidationActive) {
					return ValidatorCommonOnSubmit();
				} else {
					return true;
				}
			}
			//
		</SCRIPT>
	</FORM>
</BODY>
</HTML>