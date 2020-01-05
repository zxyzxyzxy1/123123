<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/index_work.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
</head>
<body>
<center>
	<form action="queryGoods" method="post">
	<input type="hidden" name="pageNum" id="pageNum">
		品牌：<input type="text" name="name" value="${name }">
		发布时间：<input type="text" name="begin" value="${begin }">~
				<input type="text" name="end" value="${end }">
		<input type="submit" value="搜索"><br><br>
	</form>

	<table>
		<tr>
			<th>全选<input type="checkbox" id="c"></th>
			<th>编号</th>
			<th>品牌</th>
			<th>分类</th>
			<th>发布时间</th>
			<th>操作</th>
		</tr>
	<c:forEach items="${page.list }" var="g">
		<tr>
			<td><input type="checkbox" value="${g.id }" class="css" name="id"></td>
			<td>${g.id }</td>
			<td>${g.name }</td>
			<td>${g.tname }</td>
			<td>${g.datea }</td>
			<td>
				<input type="button" value="详情">
				<input type="button" value="编辑" onclick="show(${g.id })">
			</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="10"> 
				<input type="button" value="首页" onclick="fy(${page.firstPage})">
				<input type="button" value="上一页" onclick="fy(${page.firstPage==page.pageNum?page.firstPage:page.prePage})">
				<input type="button" value="下一页" onclick="fy(${page.lastPage==page.pageNum?page.lastPage:page.nextPage})">
				<input type="button" value="尾页" onclick="fy(${page.lastPage})">
				第${page.pageNum }/${page.lastPage }页
			</td>
		</tr>
	</table><br><br>
	<input type="button" value="添加">
	<input type="button" value="批量删除">
</center>
</body>
<script type="text/javascript">
	function show(gid){
		location="show.jsp?gid="+gid;
	}
	
	
	$("[value=批量删除]").click(function(){
		var ids = "";
		$(".css:checked").each(function(){
			ids += "," + $(this).val();
		})
		ids=ids.substring(1);
		
		if(confirm("你确认删除"+ids+"的数据吗")){
			$.post(
					"deleteGoods",
					{ids:ids},
					function(obj){
						if(obj){
							alert("删除成功")
							location="queryGoods";
						}else{
							alert("删除成功")
						}
					},
					"json"
				)
		}else{
			alert("...")
		}
	})
		
	$("[value=添加]").click(function(){
		location="add.jsp";
	})

	function fy(pageNum){
		$("#pageNum").val(pageNum);
		$("form").submit();
	}

	$("#c").click(function(){
		$(".css").attr("checked",this.checked);
	})
</script>
</html>