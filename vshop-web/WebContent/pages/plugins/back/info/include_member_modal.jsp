<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="userInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3 class="modal-title">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;查看“<span id="userMid"></span>”用户信息</strong></h3>
			</div>
			<div class="modal-body">
				<div id="memberBasicInfo">
					<table class="table table-bordered table-hover">
						<tr>
							<td style="width:15%"><strong>用户名：</strong></td>
							<td>MLDN</td>
						</tr>
						<tr>
							<td style="width:15%"><strong>姓名：</strong></td>
							<td>魔乐科技</td>
						</tr>
						<tr>
							<td style="width:15%"><strong>联系电话：</strong></td>
							<td>13689091234</td>
						</tr>
						<tr>
							<td style="width:15%"><strong>EMAIL：</strong></td>
							<td>mldnqa@163.com</td>
						</tr>
						<tr>
							<td style="width:15%"><strong>注册日期：</strong></td>
							<td>2017-10-10</td>
						</tr>
					</table>
				</div>
				<div id="memberAddressInfo">
					<div class="lead"><strong>联系地址</strong></div>
					<table class="table table-bordered table-hover">
						<thead>
							<tr>
								<th class="text-center"><strong>状态</strong></th>
								<th class="text-center"><strong>收件人</strong></th>
								<th class="text-center"><strong>联系电话</strong></th>
								<th class="text-center"><strong>地址</strong></th>
							</tr>
							<tbody>
								<tr>
									<td class="text-center">
										<input type="radio" id="flag" name="flag" checked>
									</td>
									<td class="text-center">老李</td>
									<td class="text-center">11031903209</td>
									<td class="text-center">北京市朝阳区来广营马泉营</td>
								</tr>
								<tr>
									<td class="text-center">
										<input type="radio" id="flag" name="flag">
									</td>
									<td class="text-center">老王</td>
									<td class="text-center">11031903209</td>
									<td class="text-center">北京市昌平区北清路</td>
								</tr>
							</tbody>
						</thead>
					</table>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>