<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/back/admin/goods/goods_list.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp" />
		<div class="content-wrapper text-left">
			<!-- 此处编写需要显示的页面 --> 
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-list"></span>&nbsp;商品信息列表</strong>
				</div>
				<div class="panel-body">
					<jsp:include page="/pages/plugins/split_plugin_search_bar.jsp"/>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center">
									<input type="checkbox" id="selectAll">
								</th>
								<th class="text-center"><strong>商品名称</strong></th>
								<th class="text-center"><strong>发布者</strong></th>
								<th class="text-center"><strong>价格</strong></th>
								<th class="text-center"><strong>发布日期</strong></th>
								<th class="text-center"><strong>操作</strong></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">
									<input type="checkbox" id="goods.gid" name="goods.gid" value="1">
								</td>
								<td class="text-center">
									<a id="showBtn-1" onmouseover="this.style.cursor='hand'">Java开发实战经典</a>
								</td>
								<td class="text-center">mldn</td>
								<td class="text-center">79.8</td>
								<td class="text-center">2017-10-10</td>
								<td class="text-center">
									<a type="button" class="btn btn-info btn-xs" href="pages/back/admin/goods/goods_edit.jsp">
										<span class="glyphicon glyphicon-edit"></span>&nbsp;编辑</a>
								</td>
							</tr>
						</tbody>
					</table>
					<div>
						<button class="btn btn-danger" id="rmBtn">删除商品</button>
					</div>
					<div id="splitBarDiv" style="float:right">
						<jsp:include page="/pages/plugins/split_plugin_page_bar.jsp"/> 
					</div>
				</div>
				<div class="panel-footer">
					<jsp:include page="/pages/plugins/include_alert.jsp"/>
				</div>
			</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
