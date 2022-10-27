<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 引入 layui.css -->
<link rel="stylesheet"
	href="/day0608_02/layui-v2.6.8/layui/css/layui.css">
<!-- 引入 layui.js -->
<script src="/day0608_02/layui-v2.6.8/layui/layui.js"></script>

<title>meeting_updateDept</title>
</head>
<body>
	<form action="/day0608_02/updateDeptController">
		<div style="float: left; line-height: 40px; margin: 10px;">部门编号:</div>
		<div style="float: left; width: 300px; margin: 10px;">
			<input type="text" name="did" value="<%=request.getParameter("did")%>" readonly required lay-verify="required" autocomplete="off" class="layui-input">
		</div>

		<div
			style="clear: both; float: left; line-height: 40px; margin: 10px;">部门编号:</div>
		<div style="float: left; width: 300px; margin: 10px;">
			<input type="text" name="dname" value="<%=request.getParameter("dname")%>" required lay-verify="required" autocomplete="off" class="layui-input">
		</div>
		<div style="clear: both; margin: 10px;">
			<button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</form>
</body>

<script>
	
</script>
</html>

