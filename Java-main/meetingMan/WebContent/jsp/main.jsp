<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>meeting_main</title>
<link rel="stylesheet"
	href="/day0608_02/layui-v2.6.8/layui/css/layui.css">
<script src="/day0608_02/layui-v2.6.8/layui/layui.js"></script>
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo layui-hide-xs layui-bg-black">会议管理系统</div>

			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item layui-hide layui-show-md-inline-block">
					<a href="javascript:;"> <img
						src="//tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg"
						class="layui-nav-img"> tester
					</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">你的信息</a>
						</dd>
						<dd>
							<a href="">设置</a>
						</dd>
						<dd>
							<a href="">登出</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
					<a href="javascript:;"> <i
						class="layui-icon layui-icon-more-vertical"></i>
				</a>
				</li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">会议模块</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">查看会议</a>
							</dd>
							<dd>
								<a href="/day0608_02/getAllRooms" target="main">查看会议室</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">部门模块</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/day0608_02/getAllDeptController" target="main">查看部门</a>
							</dd>
							<dd>
								<a href="javascript:;">修改部门</a>
							</dd>
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">员工模块</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="/day0608_02/getAllEmpInfos" target="main">查看员工</a>
							</dd>
							<dd>
								<a href="/day0608_02/selectDidAndDname" target="main">新增员工</a>
							</dd>
						</dl>
					</li>

				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<iframe name="main" width="100%" height="800px" frameborder="0"></iframe>
		</div>

		<!-- 		<div class="layui-footer">
			底部固定区域
			底部固定区域
		</div> -->
	</div>
	<script>
		//JS 
		layui
				.use(
						[ 'element', 'layer', 'util' ],
						function() {
							var element = layui.element, layer = layui.layer, util = layui.util, $ = layui.$;

							//头部事件
							util
									.event(
											'lay-header-event',
											{
												//左侧菜单事件
												menuLeft : function(othis) {
													layer.msg('展开左侧菜单的操作', {
														icon : 0
													});
												},
												menuRight : function() {
													layer
															.open({
																type : 1,
																content : '<div style="padding: 15px;">处理右侧面板的操作</div>',
																area : [
																		'260px',
																		'100%' ],
																offset : 'rt' //右上角
																,
																anim : 5,
																shadeClose : true
															});
												}
											});

						});
	</script>
</body>
</html>
