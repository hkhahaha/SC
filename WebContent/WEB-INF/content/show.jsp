<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="dto.Clazz"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
ActionContext ctx = ActionContext.getContext();
List<Clazz> abc = (List)ctx.getSession().get("clazzs");
System.out.println(123);
System.out.println(abc);
%>
<body>

<table class="default" width="100%" border="5">
<tr class="title">
<td>班级id</td>
<td>班级名称</td>
<td>班级教室</td>
<td>班级系别</td>
<td>修改</td>
<td>删除</td>
</tr>

<s:iterator value="#session.clazzs" var="cla">
<tr class="abc">
<td><s:property value="#cla.id"/></td>
<td><s:property value="#cla.name" /></td>
<td><s:property value="#cla.teacher"/></td>
<td><s:property value="#cla.type"/></td>
<td><s:property value="修改"/></td>
<td><s:property value="删除"/></td>
</tr>
</s:iterator>

</table>
</body>
</html>