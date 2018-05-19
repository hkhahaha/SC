<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<s:date name=""/>
<body>

<s:form action="upload" enctype="multipart/form-data">
<s:token/>
<s:textfield label="学号" name="student.sno"></s:textfield>
<s:textfield label="姓名" name="student.sname"></s:textfield>
<s:textfield label="性别" name="student.sex"></s:textfield>
<s:textfield label="电话" name="student.tel"></s:textfield>
<s:textfield label="出生日期" name="student.birth">
<s:date name="birth" format="YYYY-MM-DD"/></s:textfield>
<s:select name="name" label="选择那个傻逼的班级" labelposition="left" list="%{#session.clazzs}" />
<s:file label="上传图片" name="upimg"></s:file>
<s:submit value="添加学生"></s:submit>
</s:form>

</body>
</html>