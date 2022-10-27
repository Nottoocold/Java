<%@page import="com.zyc.meeting.entity.Room"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/day0608_02/layui-v2.6.8/layui/css/layui.css">
<script src="/day0608_02/layui-v2.6.8/layui/layui.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1 align="center">会议室信息</h1>

<table class="layui-table" lay-even lay-skin="line">
		<colgroup>
			<col width="150">
			<col width="200">
			<col>
		</colgroup>
		<thead>
			<tr>
				<th>会议室ID</th>
				<th>会议室名称</th>
				<th>会议室描述</th>
				<th>会议室状态</th>
				<th>可容纳人数</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				ArrayList<Room> rooms = (ArrayList<Room>) request.getAttribute("rooms");
				for (Room r : rooms) {
			%>
			<tr>
				<td><%=r.getRid() %></td>
				<td><%=r.getRname()%></td>
				<td><%=r.getRdesc()%></td>
				<%if(r.getRstatus().equals("0")) {%><td style="bgcolor:green">可使用</td><%} %>
				<%if(r.getRstatus().equals("1")) {%><td style="bgcolor:yellow">已预约</td><%} %>
				<%if(r.getRstatus().equals("2")) {%><td style="bgcolor:red">维修中</td><%} %>
				<td><%=r.getRnum()%></td>
				<td>
					<a href="/day0608_02/jsp/room/ordermeet.jsp?rid=<%= r.getRid() %>&rname=<%=r.getRname() %>&rdesc=<%=r.getRdesc() %>"
						<%if(!r.getRstatus().equals("0")) {%> class="layui-btn layui-btn-disabled" <%} %> >预定</a> 
				</td>	
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>
