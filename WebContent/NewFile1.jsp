<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="bootstrap3/css/bootstrap.min.css">
	<script src="bootstrap3/js/jquery-1.8.2.min.js"></script>
	<script src="bootstrap3/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>创建模态框（Modal）</h2>
	<!-- 按钮触发模态框 -->
	<a class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
		查看详情
	</a>
	
	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div style="width: 800px;height: auto;" class="modal-dialog">
			<div class="modal-content" style="height: auto;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						请假详细信息
					</h4>
				</div>
				<div class="modal-body">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>姓名</th>
								<th>李斌</th>
								<th>性别</th>
								<th>男</th>
								<th>学号</th>
								<th>201710530919</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>学院</td>
								<td>智能制造学院</td>
								<td>班级</td>
								<td>2017级9班</td>
								<td>电话</td>
								<td>18908240242</td>
							</tr>
							<tr>
								<td>请假时间</td>
								<td colspan="2">2019-12-04</td>
								<td>返校时间</td>
								<td colspan="2">2019-12-28</td>
							</tr>
							
							<tr>
								<td style="width: 50px;">请假原因</td>
								<td colspan="5">
									<table style="margin-bottom: 0px; border: 0px;width: 100%;">
										<thead>
											<tr style="height: 150px;vertical-align:text-top; ">
												<th rowspan="6" colspan="2">病假</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td >申请人：李斌</td>
												<td>时间：2019年</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td>班级辅导员意见</td>
								<td colspan="5">
									<table style="margin-bottom: 0px; border: 0px;width: 100%;">
										<thead>
											<tr style="height: 150px;vertical-align:text-top; ">
												<th rowspan="6" colspan="2">病假</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td >准假人：李斌</td>
												<td>时间：2019年</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td style="text-align: center;">年级辅导员意见</td>
								<td colspan="5">
									<table style="margin-bottom: 0px; border: 0px; width: 100%;" >
										<tbody>
										<tr style="height: 150px;vertical-align:text-top; ">
											<td colspan="2">病假</td>
										</tr>
											<tr>
												<td>准假人：李斌</td>
												<td>时间：2019年</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal">
						确定
					</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>