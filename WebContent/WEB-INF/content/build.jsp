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
增加班级
<s:form action="ClazzAction">
<s:textfield name="clazz.name" label="姓名"></s:textfield>
<s:textfield name="clazz.type" label="系别"></s:textfield>
<s:textfield name="clazz.teacher" label="教师"></s:textfield>
<s:submit>提交</s:submit>
</s:form>
</center>
</body>
</html>