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
<form action="list.do" method="post">
	电影名称:<input type="text" name="cname"/><input type="submit" value="搜索"/>
</form>
<table>
	<tr>
		<td colspan="10">
			<a href="add.jsp"><input type="button" value="添加"/> </a>
			<input type="button" value="批量删除" onclick="del()"/>
		</td>
	</tr>
	<tr>
		<td>
			<input type="checkbox" name="qx"/>全选/全不选
			<input type="checkbox" name="fx"/>反选
		</td>
		<td>编号</td>
		<td>电影名称</td>
		<td>剧情介绍</td>
		<td>导演</td>
		<td>电影分类</td>
		<td>发行日期</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${info.list }" var="c">
		<tr>
			<td>
				<input type="checkbox" name="xz" value="${c.cid }"/>
			</td>
			<td>${c.cid }</td>
			<td>${c.cname }</td>
			<td>${c.cdesc }</td>
			<td>${c.author }</td>
			<td>${c.tname }</td>
			<td>${c.begintime }</td>
			<td>
				<a href="update.jsp?cid=${c.cid }"><input type="button" value="修改"/></a>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="10">
			<a href="?pageNum=1">首页</a>
			<a href="?pageNum=${info.pageNum-1<1? info.pageNum:info.pageNum-1 }">上一页</a>
			<a href="?pageNum=${info.pageNum+1<info.pages? info.pageNum:info.pageNum+1 }">下一页</a>
			<a href="?pageNum=${info.pages }">尾页</a>
		</td>
	</tr>
</table>
<script type="text/javascript">
	$("[name='qx']").toggle(function(){
		$("[name='xz']").prop("checked",true);
	},function(){
		$("[name='xz']").prop("checked",false);
	})
	
	$("[name='fx']").click(function(){
		$("[name='xz']").each(function(){
			this.checked=!this.checked;
		})
	})
	
	function del(){
		var ids = $("[name='xz']").map(function(){
			return $(this).val();
		}).get().join(",");
		
		if (confirm("确定删除?")) {
			$.post("deleteCinemal.do",{"ids":ids},function(num){
				if (num) {
					alert("删除成功!");
					location.href="list.do";
				}else{
					alert("删除失败!");
				}
			},"json")
		}
	}
</script>
</body>
</html>