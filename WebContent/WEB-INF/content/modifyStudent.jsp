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
<s:form action="modifyStudent"  enctype="multipart/form-data">
<s:hidden name="student.sid" value="%{#session.student.sid}"></s:hidden>
<s:textfield label="学号" value="%{#session.student.sno}" name="student.sno"></s:textfield>
<s:textfield label="姓名" value="%{#session.student.sname}" name="student.sname"></s:textfield>
<s:textfield label="性别" value="%{#session.student.sex}" name="student.sex"></s:textfield>
<s:textfield label="电话" value="%{#session.student.tel}" name="student.tel"></s:textfield>
<s:textfield label="出生日期" value="%{#session.student.birth}" name="student.birth">
<s:date name="birth" format="YYYY-MM-DD"/></s:textfield>
<s:select name="name" label="选择那个傻逼的班级" labelposition="left" list="%{#session.clazzs}" value="%{#session.student.clazz}"/>
<s:file label="上传图片" name="upimg"></s:file>
<s:submit value="添加学生"></s:submit>
</s:form>
</body>
</html>