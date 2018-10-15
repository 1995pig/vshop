<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="/pages/plugins/back/back_header.jsp"/>
<script type="text/javascript" src="js/back/admin/goods/goods_edit.js"></script>
<%!
	public static final String GOODS_EDIT_URL = "" ;
%>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 -->
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp" />
		<div class="content-wrapper text-left">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-edit"></span>&nbsp;编辑商品信息</strong>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="<%=GOODS_EDIT_URL%>" id="myform" method="post" enctype="multipart/form-data">
						<fieldset>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="goods.titleDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="goods.title">商品名称：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="goods.title" name="goods.title" class="form-control"
										placeholder="请输入商品名称" value="Java开发实战经典">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="goods.titleMsg"></div>
							</div>
							<div class="form-group" id="goods.iidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="goods.iid">所属类别：</label>
								<div class="col-md-5">
									<select id="goods.iid" name="goods.iid" class="form-control">
										<option value="1" selected>图书音响</option>
										<option value="2">汽车用品</option>
										<option value="3">电脑办公</option>
										<option value="4">手机数码</option>
										<option value="5">家居生活</option>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="goods.iidMsg"></div>
							</div>
							<div class="form-group" id="goods.sidDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="goods.sid">所属子类别：</label>
								<div class="col-md-5">
									<select id="goods.sid" name="goods.sid" class="form-control">
										<option value="1">幼儿图书</option>
										<option value="2" selected>计算机图书</option>
										<option value="3">养生</option>
									</select>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="goods.sidMsg"></div>
							</div>
							<div class="form-group" id="goods.priceDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="goods.price">商品价格：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="text" id="goods.price" name="goods.price" class="form-control"
										placeholder="请输入商品价格" value="79.8">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="goods.priceMsg"></div>
							</div>
							<div class="form-group" id="goods.photoDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="goods.photo">商品图片：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<input type="file" id="goods.photo" name="goods.photo" class="form-control"
										placeholder="请选择商品宣传图片">
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="goods.photoMsg"></div>
							</div>
							<!-- 定义输入表单样式，其中id主要用于设置颜色样式 -->
							<div class="form-group" id="goods.noteDiv">
								<!-- 定义表单提示文字 -->
								<label class="col-md-3 control-label" for="goods.note">项目描述：</label>
								<div class="col-md-5">
									<!-- 定义表单输入组件 -->
									<textarea id="goods.note" name="goods.note"
										class="form-control" placeholder="请输入商品描述信息" rows="10"></textarea>
								</div>
								<!-- 定义表单错误提示显示元素 -->
								<div class="col-md-4" id="project.noteMsg"></div>
							</div> 
							<div class="form-group">
								<div class="col-md-5 col-md-offset-3">
									<input type="hidden" id="goods.gid" name="goods.gid" value="1">
									<button type="submit" class="btn btn-primary">修改</button>
									<button type="reset" class="btn btn-warning">重置</button>
								</div>
							</div>
						</fieldset>
					</form>
				</div>
				<div class="panel-footer">
					<div class="alert alert-success" id="alertDiv" style="display: none;">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <span id="alertText"></span>
                    </div>
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
