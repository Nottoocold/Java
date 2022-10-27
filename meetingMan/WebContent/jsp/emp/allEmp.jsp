<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.zyc.meeting.entity.Emp"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<h1 align="center">员工信息表</h1>
<!--  模糊查询在这里-->
	<form class="layui-form" action="/day0608_02/selectByCondition">
		<div class="layui-form-item">
    	<div class="layui-input-inline"><label class="layui-form-label">员工编号：</label></div>
    		<div class="layui-input-inline">
      			<input type="text" name="eidcon" lay-verify="required" placeholder="请输入编号" autocomplete="off" class="layui-input">
    		</div>
    		<div class="layui-input-inline"><label class="layui-form-label">入职日期：</label></div>
    		<div class="layui-input-inline">
      			<input type="text" name="edatecon" lay-verify="required" placeholder="请输入日期" autocomplete="off" class="layui-input">
    		</div>
    		<div class="layui-input-inline"><label class="layui-form-label">员工类型：</label></div>
		    <div class="layui-input-inline">
		      <select name="estatuscon">
		        <option value="-1" selected>请选择类型<option>
		        <option value="0" >普通员工</option>
		        <option value="1">部门经理</option>
		        <option value="2">经理助理</option>
		      </select>
		    </div>
		    <div class="layui-input-inline">
		      <button type="submit" class="layui-btn">查询</button>
		      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
		    </div>
  		</div>
	</form>
	<!--以下数据展示区-->
	<table class="layui-table" lay-even lay-skin="line">
		<colgroup>
			<col width="150">
			<col width="200">
		</colgroup>
		<thead>
			<tr>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>员工类型</th>
				<th>员工入职日期</th>
				<th>员工电话</th>
				<th>员工所属部门</th>
				<th>员工密码</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Emp> emps = (ArrayList<Emp>) request.getAttribute("emps");
				ArrayList<String> dnames = (ArrayList<String>)request.getAttribute("dnames");
				if(emps.size() !=0 && dnames.size() != 0){
					for (int e = 0; e < emps.size(); e++) {
			%>
			<tr>
				<td><%=emps.get(e).getEid()%></td>
				<td><%=emps.get(e).getEname()%></td>
				<%	Integer i = emps.get(e).getEstatus();
					 if(i==0){
				%> 
				<td>普通员工 </td>
				<% }%>
				<%  if(i==1){ %>
				<td>部门经理</td>	
				<%} %>	
				<% if(i==2) { %>
				<td>经理助理</td>
				<% }%>
				<td><%=emps.get(e).getEdate()%></td>
				<td><%=emps.get(e).getEtel()%></td>
				<td><%=dnames.get(e)%></td>
				<td><%=emps.get(e).getEpwd()%></td>
				<td>
					<a href="/day0608_02/selectById?eid=<%= emps.get(e).getEid()%>" class="layui-btn">修改</a> 
				    <a href="/day0608_02/delEmpController?eid=<%= emps.get(e).getEid() %>" class="layui-btn layui-btn-danger">删除</a>
				</td>
			</tr>
			<%
				}
					}
			%>
		</tbody>
	</table>
</body>
</html>
