<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%!
	public static final String GOODS_SEARCH_URL = "pages/front/goods/goods_list.jsp" ;
 	public static final String MEMBER_BASE_EDIT_URL = "pages/front/center/member/MemberCenterActionFront!editBasePre.action	";
	public static final String MEMBER_PASSWORD_EDIT = "pages/front/center/member/member_password_edit.jsp";
	public static final String MEMBER_ADDRESS = "pages/front/center/address/MemberAddressActionFront!list.action";
%>
<ul class="nav nav-pills nav-stacked">									<!-- 定义导航 -->
	<li class="${param.ch == 1 ? "active" : ""}"><a href="pages/front/center/orders/orders_list.jsp">我的订单</a></li>			<!-- 活跃导航项 -->
	<li class="${param.ch == 2 ? "active" : ""}"><a href="<%=MEMBER_BASE_EDIT_URL%>">个人信息</a></li>
	<li class="${param.ch == 3 ? "active" : ""}"><a href="<%=MEMBER_PASSWORD_EDIT%>">修改密码</a></li>
	<li class="${param.ch == 4 ? "active" : ""}"><a href="pages/front/center/shopcar/shopcar_list.jsp">购物车</a></li>			<!-- 禁用导航项 -->
	<li class="${param.ch == 5 ? "active" : ""}"><a href="<%=MEMBER_ADDRESS%>">地址管理</a></li>
</ul>
