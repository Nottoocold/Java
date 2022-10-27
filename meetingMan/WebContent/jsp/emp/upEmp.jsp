<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入 layui.css -->
<link rel="stylesheet" href="/day0608_02/layui-v2.6.8/layui/css/layui.css">
<!-- 引入 layui.js -->
<script src="/day0608_02/layui-v2.6.8/layui/layui.js"></script>

<title>Insert title here</title>

</head>
<body>
<%HashMap<String,String> eMap =(HashMap<String,String>) request.getAttribute("emp"); %>
	<form class="layui-form" action="/day0608_02/updateEmp" method="post">
		 <div class="layui-form-item">
    		<label class="layui-form-label">员工编号：</label>
    		<div class="layui-input-block">
      			<input type="text" name="eid" value=<%= eMap.get("eid") %> readonly autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		<div class="layui-form-item">
    		<label class="layui-form-label">员工姓名：</label>
    		<div class="layui-input-block">
      			<input type="text" name="ename" value=<%= eMap.get("ename") %> autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		<div class="layui-form-item">
    		<label class="layui-form-label">员工类型：</label>
    		<div class="layui-input-block">
      			<input type="text" name="estatus" value=<%= eMap.get("estatus") %> autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		<div class="layui-form-item">
    		<label class="layui-form-label">入职日期</label>
    		<div class="layui-input-block">
      			<input type="text" name="edate" value=<%= eMap.get("edate") %> readonly autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		<div class="layui-form-item">
    		<label class="layui-form-label">联系方式：</label>
    		<div class="layui-input-block">
      			<input type="text" name="etel" value=<%= eMap.get("etel") %> autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		<div class="layui-form-item">
    		<label class="layui-form-label">所属部门</label>
    		<div class="layui-input-block">
      			<input type="text" name="dname" value=<%= eMap.get("dname") %> autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		<div class="layui-form-item">
    		<label class="layui-form-label">密码：</label>
    		<div class="layui-input-block">
      			<input type="text" name="epwd" value=<%= eMap.get("epwd") %> autocomplete="off" class="layui-input">
    		</div>
  		</div>
  		<div class="layui-form-item">
    		<div class="layui-input-block">
		      <button class="layui-btn" lay-submit lay-filter="formDemo">修改</button>
		      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    		</div>
  		</div>
	</form>
</body>
</html>