<%@page import="java.util.ArrayList"%>
<%@page import="com.zyc.meeting.entity.Dept"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 引入 layui.css -->
<link rel="stylesheet"
	href="/day0608_02/layui-v2.6.8/layui/css/layui.css">
<!-- 引入 layui.js -->
<script src="/day0608_02/layui-v2.6.8/layui/layui.js"></script>

<title>meeting_dept</title>
</head>
<body>
	<h1 align="center">部门信息表</h1>

	<div class="layui-container">
		<div class="layui-row">
			<div class="layui-col-md9">
				<form class="layui-form" action="/day0608_02/addDeptController">
					<div class="layui-form-item">
						<label class="layui-form-label">部门名称：</label>
						<div class="layui-input-block">
							<input type="text" name="dname" required lay-verify="required"
								placeholder="请输入部门名称" autocomplete="off" class="layui-input">
							<button class="layui-btn" lay-submit lay-filter="formDemo">添加</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<table class="layui-table" lay-even lay-skin="line">
		<colgroup>
			<col width="150">
			<col width="200">
			<col>
		</colgroup>
		<thead>
			<tr>
				<th>部门编号</th>
				<th>部门名称</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Dept> depts = (List<Dept>) request.getAttribute("depts");
				for (Dept d : depts) {
			%>

			<tr>
				<td><%=d.getDid()%></td>
				<td><%=d.getDname()%></td>
				<td><a
					href="/day0608_02/jsp/dept/upDept.jsp?did=<%=d.getDid()%>&dname=<%=d.getDname()%>"
					class="layui-btn">修改</a> <a
					href="/day0608_02/delDeptController?did=<%=d.getDid()%>"
					class="layui-btn layui-btn-danger">删除</a></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>
