<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:actionerror />
	<center>
		<s:form action="loginAction" method="post">
			<s:textfield name="username" label="用户名" />
			<s:password name="password" label="密码" />
			<s:submit value="登录" />
	</center>
	</s:form>
	<br>
</body>
</html>