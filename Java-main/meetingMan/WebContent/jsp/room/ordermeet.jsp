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
	<h1 align="center">预定会议</h1>
	
	<form class="layui-form" action="/day0608_02/orderMeetController">
		 <div class="layui-form-item"> <label class="layui-form-label">会议室ID</label>
	          <div class="layui-input-inline">
	           <input type="text" name="rid" value=<%=request.getParameter("rid") %> readonly lay-verify="title" autocomplete="off" class="layui-input">
	          </div>
         </div>
         <div class="layui-form-item"> <label class="layui-form-label">会议室名称</label>
	          <div class="layui-input-inline">
	           <input type="text" value=<%=request.getParameter("rname") %> readonly lay-verify="title" autocomplete="off" class="layui-input">
	          </div>
         </div>
         <div class="layui-form-item layui-form-text"> <label class="layui-form-label">会议室描述</label>
          <div class="layui-input-block"> <textarea placeholder=<%=request.getParameter("rdesc") %> readonly class="layui-textarea"></textarea>
          </div>
         </div>
         <div class="layui-form-item"> <label class="layui-form-label">预定人编号</label>
	          <div class="layui-input-inline">
	           <input type="text" name="eid" lay-verify="title" placeholder="4位编号" autocomplete="off" class="layui-input">
	          </div>
         </div>
         <div class="layui-form-item"> <label class="layui-form-label">预定人姓名</label>
	          <div class="layui-input-inline">
	           <input type="text" lay-verify="title" placeholder="可输入别名" autocomplete="off" class="layui-input">
	          </div>
         </div>
         <div class="layui-form-item"> <label class="layui-form-label">会议主题</label>
	          <div class="layui-input-inline">
	           <input type="text" name="mtitle" lay-verify="title" placeholder="喜欢开会" autocomplete="off" class="layui-input">
	          </div>
         </div>
         <div class="layui-inline"> <label class="layui-form-label">会议开始时间</label>
	           <div class="layui-input-inline">
	            <input type="text" name="mdate" class="layui-input" id="test5" placeholder="年月日时分秒">
	           </div>
         </div>
         <div class="layui-form-item"> <label class="layui-form-label">会议室时长</label>
	          <div class="layui-input-inline">
	           <input type="text" name="mtime" lay-verify="title" placeholder="最长不超过4小时" autocomplete="off" class="layui-input">
	          </div>
         </div>
         <div class="layui-form-item">
	          <div class="layui-input-block"> 
	          	<button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">确认预定</button><span >${msg}</span>
	          </div>
         </div>
         <br/>
	</form>
<script>
layui.use('laydate', function(){
	  var laydate = layui.laydate;
	  
	  laydate.render({
		    elem: '#test5'
		    ,type: 'datetime'
		  });
});
</script>
</body>
</html>
