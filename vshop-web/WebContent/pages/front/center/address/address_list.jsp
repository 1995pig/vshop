<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/front/front_header.jsp"/>
<script type="text/javascript" src="js/front/center/address/address_list.js"></script>
<%!
												
	public static final String ADDRESS_ADD_URL = "pages/front/center/address/MemberAddressActionFront!addPre.action";
	public static final String ADDRESS_EDIT_URL = "pages/front/center/address/address_edit.jsp";
%>
<body>
	<div class="container">
		<div id="headDiv" class="row">
			<div class="col-md-12 col-xs-12">
				<jsp:include page="/pages/plugins/front/include_menu_member.jsp" />
			</div>
		</div>
		<div style="height: 60px;"></div>
		<div id="contentDiv" class="row">
			<div class="col-md-2 col-xs-2">
				<jsp:include page="/pages/plugins/front/center/include_center_item.jsp">
					<jsp:param value="5" name="ch"/>
				</jsp:include>
			</div>
			<div class="col-md-10 col-xs-10">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<strong><span class="glyphicon glyphicon-list"></span>&nbsp;个人地址信息列表</strong>
					</div>
					<div class="panel-body">
						<table class="table table-condensed">
							<thead>
								<tr>
									 
									<th class="text-center"><strong>默认</strong></th>
									<th class="text-center"><strong>收件人</strong></th>
									<th class="text-center"><strong>联系电话</strong></th>
									<th class="text-center"><strong>地址</strong></th>
									<th class="text-center"><strong>操作</strong></th>
								</tr>
							</thead>
							<tbody>
 							<c:if test="${allAddress!= null }">
 							 	<c:forEach items="${allAddress}" var="address">
 									<tr>
										<td class="text-center">
											<input type="radio" id="aid" name="aid" value="${address.adid }" ${address.deflag==1? "checked":""}>
 										</td>
										<td class="text-center">${address.receiver }</td>
										<td class="text-center">${address.phone } </td>
										<td class="text-center">${address.addr } </td>
										<td class="text-center">
											<a id="editBtn-${address.adid }" 
												href="pages/front/center/address/MemberAddressActionFront!editPre.action?adid=${address.adid}"  
												class="btn btn-primary btn-xs">编辑</a>
											<a id="deleteBtn-${address.adid }" 
												href="pages/front/center/address/MemberAddressActionFront!delete.action?adid=${address.adid}" 
												class="btn btn-primary btn-xs">删除</a>
										</td>
  									</tr>
 								</c:forEach>
 							</c:if>
								 
							 
							</tbody>
						</table>
						<div class="text-right">
							<button class="btn btn-danger" id="delBtn">修改 默认地址</button>
							<a href="<%=ADDRESS_ADD_URL%>" class="btn btn-primary">增加新地址</a>
						</div>
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
