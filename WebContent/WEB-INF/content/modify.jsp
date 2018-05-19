<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="dto.Clazz"%>
<%@page import="java.util.List"%>
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
<center>
<s:form action="modifiClazzAction">
<s:hidden name="clazz.id" value="%{#session.clazz.id}"></s:hidden>
<s:textfield name="clazz.name" label="姓名" value="%{#session.clazz.name}"></s:textfield>
<s:textfield name="clazz.type" label="系别" value="%{#session.clazz.type}"></s:textfield>
<s:textfield name="clazz.teacher" label="教师" value="%{#session.clazz.teacher}"></s:textfield>
<s:submit>提交</s:submit>
</s:form>
</center>
</body>
</html>