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
		$.post("findCinemalByCid.do",{"cid":"${param.cid}"},function(data){
			var cin = data.cin;
			$("[name='cid']").val(cin.cid);
			$("[name='cname']").val(cin.cname);
			$("[name='cdesc']").val(cin.cdesc);
			$("[name='author']").val(cin.author);
			var num = data.list;
			for ( var i in num) {
				$("#tid").append("<input type='checkbox' name='tid' value='"+num[i].tid+"'/>"+num[i].tname)
			}
			var tid = cin.tid.split(",");
			for ( var i in tid) {
				$("[name='tid'][value='"+tid[i]+"']").prop("checked",true);
			}
			$("[name='begintime']").val(cin.begintime);
		},"json")
	})
</script>
<form action="#">
			<input type="hidden" name="cid"/>
	电影名称:<input type="text" name="cname"/><br>
	剧情介绍:<textarea rows="3" cols="20" name="cdesc"></textarea><br>
	导演:<input type="text" name="author"/><br>
	电影分类:<span id="tid"></span><br>
	发行日期:<input type="text" name="begintime" onclick="WdatePicker()"/><br>
	<input type="button" value="保存" onclick="update()"/>
</form>
<script type="text/javascript">
	function update(){
		$.post("insertOrupdate.do",$("form").serialize(),function(num){
			if (num) {
				
				alert("修改成功!");
				location.href="list.do";
			}else{
				alert("修改失败!");
			}
		},"json")
	}
</script>
</body>
</html>