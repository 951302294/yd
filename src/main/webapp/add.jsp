<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/My97DatePicker/WdatePicker.js"></script>
</head>
<body>
<script type="text/javascript">
	$(function(){
		$.post("findTypeAll.do",function(num){
			for ( var i in num) {
				$("#tid").append("<input type='checkbox' name='tid' value='"+num[i].tid+"'/>"+num[i].tname)
			}
		},"json")
	})
</script>
<form action="#">
	电影名称:<input type="text" name="cname"/><br>
	剧情介绍:<textarea rows="3" cols="20" name="cdesc"></textarea><br>
	导演:<input type="text" name="author"/><br>
	电影分类:<span id="tid"></span><br>
	发行日期:<input type="text" name="begintime" onclick="WdatePicker()"/><br>
	<input type="button" value="保存" onclick="add()"/>
</form>
<script type="text/javascript">
	function add(){
		$.post("insertOrupdate.do",$("form").serialize(),function(num){
			if (num) {
				
				alert("添加成功!");
				location.href="list.do";
			}else{
				alert("添加失败!");
			}
		},"json")
	}
</script>
</body>
</html>