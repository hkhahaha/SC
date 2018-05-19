<%@page import="dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<form action="search">
<s:textfield label="学生姓名查询" name="sno"></s:textfield>
<s:submit label="查询"></s:submit>
</form>


<table class="default" width="100%" border="5">
<tr class="title">
<td>学生id</td>
<td>学号</td>
<td>学生姓名</td>
<td>学生性别</td>
<td>学生电话</td>
<td>学生生日</td>
<td>学生图片</td>
<td>学生班级</td>
<td>修改</td>
<td>删除</td>
</tr>

<s:iterator value="#session.students" var="stu">
<tr class="students">
<td><s:property value="#stu.sid"/></td>
<td><s:property value="#stu.sno" /></td>
<td><s:property value="#stu.sname"/></td>
<td><s:property value="#stu.sex"/></td>
<td><s:property value="#stu.tel"/></td>
<td><s:property value="#stu.birth"/></td>
<td><img src="<s:property value="#stu.upimg" />" width="30%" height="30%"></td>
<td><s:property value="#stu.clazz.name"/></td>
<td><a href="modifiStudentAction?sid=<s:property value="#stu.sid"/>">修改</a></td>
<td><a href="DeleteStudentAction?sid=<s:property value="#stu.sid"/>">删除</a></td>
</tr>
</s:iterator>
</table>

</body>
</html>