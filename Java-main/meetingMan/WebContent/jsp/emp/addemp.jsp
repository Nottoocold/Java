<%@page import="com.zyc.meeting.entity.Dept"%>
<%@page import="java.util.ArrayList"%>
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
<title>Insert title here</title>
</head>
<body>
	<div class="layui-container">
		<form id="form" class="layui-form" action="/day0608_02/registerController">
			<div class="layui-form-item">
				<label class="layui-form-label">姓名：</label>
				<div class="layui-input-inline">
					<input type="text" name="ename" required lay-verify="required"
						placeholder="请输入姓名" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">密码：</label>
				<div class="layui-input-inline">
					<input type="password" name="epwd" required
						lay-verify="required" placeholder="请输入密码" autocomplete="off"
						class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">8-16位</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">员工类型：</label>
				<div class="layui-input-inline">
					<select name="estatus" lay-verify="required">
						<option value="0">普通员工</option>
						<option value="1">部门经理</option>
						<option value="2">经理助理</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">入职部门：</label>
				<div class="layui-input-inline">
					<select name="did" lay-verify="required">
					<%	ArrayList<Dept> depts = (ArrayList<Dept>) request.getAttribute("depts");
						for(Dept d : depts){
					%>
						<option value="<%=d.getDid() %>"><%=d.getDname() %></option>
					<% } %>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">电话：</label>
				<div class="layui-input-inline">
					<input type="text" name="etel" required lay-verify="required"
						placeholder="请输入联系方式" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">11电话号码</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-inline layui-col-md9">
					<button class="layui-btn" lay-submit lay-filter="formDemo">注册</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script>
		//Demo
/* 		layui.use('form', function() {
			var form = layui.form;

			//监听提交
			form.on('submit(formDemo)', function(data) {
				layer.msg(JSON.stringify(data.field));
				return false;
			});
		}); */
	</script>
</body>
</html>