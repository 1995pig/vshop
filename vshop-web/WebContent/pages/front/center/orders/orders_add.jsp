<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/front/front_header.jsp"/>
<script type="text/javascript" src="js/front/center/orders/orders_add.js"></script>
<%!
	public static final String ORDERS_ADD_URL = "" ;
%>
<body class="back">
	<div class="container contentback">
		<div id="headDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<jsp:include page="/pages/plugins/front/include_menu_member.jsp" />
			</div>
		</div>
		<div style="height: 60px;"></div> 
		<div id="contentDiv" class="row">
			<div class="col-md-2 col-xs-2">
				<jsp:include page="/pages/plugins/front/center/include_center_item.jsp">
					<jsp:param value="1" name="ch"/>
				</jsp:include>
			</div>
			<div class="col-md-10 col-xs-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-file"></span>&nbsp;创建订单</strong>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" action="<%=ORDERS_ADD_URL%>" id="myform" method="post">
							<div class="form-group" id="aidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="aid">收件地址：</label>
								<div class="col-md-5">
									<div class="radio">
										<input type="radio" id="aid" name="aid" class="radio" checked value="1">李先生，13934720223，北京市朝阳区来广营马泉营
									</div>
									<div class="radio">
										<input type="radio" id="aid" name="aid" class="radio" value="2">李先生，13934720223，北京市朝阳区来广营马泉营
									</div>
									<div class="radio">
										<input type="radio" id="aid" name="aid" class="radio" value="3">李先生，13934720223，北京市朝阳区来广营马泉营
									</div>
									<div class="radio">
										<input type="radio" id="aid" name="aid" class="radio" value="4">李先生，13934720223，北京市朝阳区来广营马泉营
									</div>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="aidMsg"></div>
							</div>
							<div id="noteDiv" class="form-group">
								<label class="col-md-3 control-label" for="addr">订单备注：</label>
								<div class="col-md-5"> 
									<textarea id="note" name="note" class="form-control"></textarea>
								</div>
								<div class="col-md-4" id="noteMsg"></div>
							</div>
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<button type="submit" class="btn btn-primary btn-lg">下单</button>
									<a href="pages/front/center/shopcar/shopcar_list.jsp" class="btn btn-link">再想想还有什么没卖的？</a>
								</div>
							</div>
						</form>
					</div>
					<div class="panel-footer">
						<jsp:include page="/pages/plugins/include_alert.jsp"/>
					</div>
				</div>
			</div>
		</div>
		<div id="footDiv" class="row navbar-fixed-bottom">
			<jsp:include page="/pages/plugins/front/include_foot.jsp" />
		</div>
	</div>
<jsp:include page="/pages/plugins/front/front_footer.jsp"/>
