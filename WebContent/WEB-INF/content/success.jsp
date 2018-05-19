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
<center><h1>班级学生管理系统</h1></center>
<s:actionmessage/>
<s:form>
<center>
<ul>
<li><s:a href="showClazz">查看班级</s:a></li>
<li><s:a href="build.jsp">增加班级</s:a></li>
<li><s:a href="showStudents">查看学生</s:a></li>
<li><s:a href="StudentClazzAction">增加学生</s:a></li>
</ul>
</center>
</s:form>
</body>
</html>