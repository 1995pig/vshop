<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/back/admin/orders/orders_details_show.js"></script>
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
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;订单详情</strong>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-3"><strong>订单编号：</strong></div>
						<div class="col-md-9 col-md-pull-1">1001</div>
					</div>
					<div class="row">
						<div class="col-md-3"><strong>下单用户：</strong></div>
						<div class="col-md-9 col-md-pull-1">MLDN</div>
					</div>
					<div class="row">
						<div class="col-md-3"><strong>下单日期：</strong></div>
						<div class="col-md-9 col-md-pull-1">2017-10-10</div>
					</div>
					<div class="row">
						<div class="col-md-3"><strong>总金额：</strong></div>
						<div class="col-md-9 col-md-pull-1">520</div>
					</div>
					<div class="row">
						<div class="col-md-3"><strong>购买商品总数：</strong></div>
						<div class="col-md-9 col-md-pull-1">6</div>
					</div>
					<div class="row">
						<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center"><strong>商品名称</strong></th>
								<th class="text-center"><strong>价格</strong></th>
								<th class="text-center"><strong>购买数量</strong></th>
								<th class="text-center"><strong>总额</strong></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">
									<a id="showBtn-1" onmouseover="this.style.cursor='hand'">Java开发实战经典</a>
								</td>
								<td class="text-center">79.8</td>
								<td class="text-center">10</td>
								<td class="text-center">798</td>
							</tr>
							<tr>
								<td class="text-center">
									<a id="showBtn-1" onmouseover="this.style.cursor='hand'">Java开发实战经典</a>
								</td>
								<td class="text-center">79.8</td>
								<td class="text-center">10</td>
								<td class="text-center">798</td>
							</tr>
							<tr>
								<td class="text-center">
									<a id="showBtn-1" onmouseover="this.style.cursor='hand'">Java开发实战经典</a>
								</td>
								<td class="text-center">79.8</td>
								<td class="text-center">10</td>
								<td class="text-center">798</td>
							</tr>
						</tbody>
					</table>
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
	<jsp:include page="/pages/plugins/back/info/include_goods_modal.jsp"/>
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
