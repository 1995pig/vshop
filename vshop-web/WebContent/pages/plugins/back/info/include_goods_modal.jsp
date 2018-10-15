<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="modal fade" id="goodsInfo"  tabindex="-1" aria-labelledby="modalTitle" aria-hidden="true" data-keyboard="true">
	<div class="modal-dialog" style="width: 1000px">
		<div class="modal-content">
			<div class="modal-header">
				<button class="close" type="button" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h3 class="modal-title">
					<strong><span class="glyphicon glyphicon-eye-open"></span>&nbsp;查看商品信息</strong></h3>
			</div>
			<div class="modal-body">
				<table class="table table-hover table-condensed">
					<tbody>
						<tr>
							<td class="text-center" rowspan="7" style="width:30%"><img src="upload/goods/goods.png"></td>
							<td class="text-center" style="width:20%"><strong>商品名称：</strong></td>
							<td class="text-center" style="width:50%">Java开发实战经典</td>
						</tr>
						<tr>
							<td class="text-center"><strong>所属类别：</strong></td>
							<td class="text-center">图书音响</td>
						</tr>
						<tr>
							<td class="text-center"><strong>所属子类别：</strong></td>
							<td class="text-center">计算机图书</td>
						</tr>
						<tr>
							<td class="text-center"><strong>商品价格：</strong></td>
							<td class="text-center">79.8</td>
						</tr>
						<tr>
							<td class="text-center"><strong>发布管理员：</strong></td>
							<td class="text-center">mldn</td>
						</tr>
						<tr>
							<td class="text-center"><strong>发布日期：</strong></td>
							<td class="text-center">2017-10-10</td>
						</tr>
						<tr>
							<td class="text-center" colspan="3">
								<pre class="pre-scrollable" style="height:100px;width:600px;">
									<p>JAVA WEB编程：</p>本课程属于JavaScript高级编程技术，所以在学习此技术之前一定要先掌握JavaScript与WEB开发技术后才可以进行学习。 本课程主要讲解了AJAX技术产生的历史背景、XMLHttpRequest对象的作用、基本属性、操作函数，并且通过大量实例讲解AJAX技术在项目开发中的实际应用，并且结合XML实现异步数据处理。
								</pre>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭窗口</button>
			</div>
		</div>
	</div>
</div>