<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Struts课程案例</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="robots" content="all,follow">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/vendor/bootstrap/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/fontastic.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/google-font/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/style.default.css" id="theme-stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/custom.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <div class="page">
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                  <div class="brand-text d-none d-lg-inline-block">请假考勤系统</div>
                  <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>请假考勤系统</strong></div></a>
                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                                
                <!-- Logout    -->
                <li class="nav-item"><a href="exit.action" class="nav-link logout"> <span class="d-none d-sm-inline">退出</span><i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch"> 
        <!-- Side Navbar -->
        <nav class="side-navbar">
          <!-- Sidebar Header-->
          <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><img src="${pageContext.request.contextPath}/image/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
              <h1 class="h4">${student.getUser().getRoleinfo().role_name}</h1>
              <p>个人信息</p>
            </div>
          </div>
          <!-- Sidebar Navidation Menus--><span class="heading">操作导航</span>
          <ul class="list-unstyled">
                    <li><a href="index.action"> <i class="icon-home"></i>系统首页 </a></li>
                    <li>
                    	<a href="#exampledropdownDropdown1" aria-expanded="false" data-toggle="collapse"> 
                    	<i class="fa fa-users"></i>用户管理 </a>
                      <ul id="exampledropdownDropdown1" class="collapse list-unstyled">
                        <li><a href="#">添加用户</a></li>
                        <li><a href="#">用户列表</a></li>
                      </ul>
                    </li>
                    <li>
                    	<a href="#exampledropdownDropdown2" aria-expanded="false" data-toggle="collapse"> 
                    	<i class="icon-interface-windows"></i>角色管理 </a>
                      <ul id="exampledropdownDropdown2" class="collapse list-unstyled">
                        <li><a href="#">添加角色</a></li>
                        <li><a href="#">角色列表</a></li>
                      </ul>
                    </li>
                    <li>
                    	<a href="#exampledropdownDropdown3" aria-expanded="false" data-toggle="collapse"> 
                    	<i class="icon-interface-windows"></i>链接管理 </a>
                      <ul id="exampledropdownDropdown3" class="collapse list-unstyled">
                        <li><a href="#">添加链接</a></li>
                        <li><a href="#">链接列表</a></li>
                      </ul>
                    </li>                    
          </ul>
        </nav>
        <div class="content-inner">
          <!-- Page Header-->
          <header class="page-header" style="margin-top: 0px;">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">请假申请</h2>
            </div>
          </header>
          
          <!-- Forms Section-->
          <section class="forms" style="padding: 0px;"> 
            <div class="container-fluid">
              <div class="row">
                <!-- Form Elements -->
                <div class="col-lg-12">
                  <div class="card">
                    <div class="card-header d-flex align-items-center">
                      <h3 class="h4">&nbsp;</h3>
                    </div>
                    <div class="card-body">
                      	<div class="col-xl-8 offset-1" style="font-size: 15px;">
                      		<form class="form-horizontal" role="form">
                      			
                      			<div class="col-md-6">
									<div class="form-group" style="margin-top: 15px;">
										<label for="name">姓名&nbsp;&nbsp;&nbsp;&nbsp;${student.stu_name}</label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group" style="margin-top: 15px;">
										<label for="name">联系方式&nbsp;&nbsp;&nbsp;&nbsp;${student.stu_phone }</label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group" style="margin-top: 15px;">
										<label for="name">学号&nbsp;&nbsp;&nbsp;&nbsp;${student.stu_number}</label>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group" style="margin-top: 15px;">
										<label for="name">班级&nbsp;&nbsp;&nbsp;&nbsp;${student.getClazz().clazz_name}</label>
									</div>
								</div>
								<div class="col-sm-12">
									<div class="form-group">
										<label for="name">请假类型 &nbsp;&nbsp;&nbsp;&nbsp;</label>
										 <label>
											<input name="type" type="radio">事假&nbsp;&nbsp;&nbsp;&nbsp;
											<input name="type" type="radio">病假
										</label>
									</div>
								</div>
								<div class="col-sm-12">
									<div class="form-group">
										<label for="name">选择日期</label>
										<input type="text" class="datepicker form-control" id="begion" name="date">
									</div>
									<div class="form-group">
										<label for="name">开始时间</label>
										<select class="form-control">
											<option>1</option>
											<option>2</option>
										 </select>
									</div>
									<div class="form-group">
										<label for="name">结束时间</label>
											<select class="form-control">
											   <option>1</option>
											   <option>2</option>
										   </select>
									</div>
								</div>
								<div class="col-sm-12">
									<div class="form-group" style="margin-top: 15px;">
										<label for="name">请假原因</label>
										 <textarea class="form-control" rows="3" cols="4"></textarea>
									</div>
								</div>
								<div class="col-sm-12">
									<div class="form-group">
										<label for="inputfile">附件</label>
										<input type="file" id="inputfile">
									</div>
								</div>
								<div class="col-sm-2 col-sm-offset-5">
									<button type="submit" class="btn btn-success">提交</button>
									<button type="reset"  class="btn btn-danger">重置</button>
								</div>
							</form>
                      	</div>
                    </div>
                  </div>
                </div>
              
              </div>
            </div>
          </section>
          
        </div>
      </div>
    </div>
    <div class="modal fade" id="myModal">
	    <div class="modal-dialog modal-lg">
	      <div class="modal-content">
	        <div class="modal-header">
	          <h4 class="modal-title">系统提示</h4>
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	        </div>
	        <div class="modal-body">
	          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;确定要删除用户?
	        </div>
	        <div class="modal-footer">
	          <form action="#" method="post">
	          	<input type="hidden" name="id" value="3"/>
		          <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
		          <button type="submit" class="btn btn-primary">确定</button>
	          </form>	
	        </div>
	      </div>
	    </div>
  	</div>
  	
    <!-- JavaScript files-->
    <script src="${pageContext.request.contextPath}/res/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/vendor/popper.js/umd/popper.min.js"> </script>
    <script src="${pageContext.request.contextPath}/res/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="${pageContext.request.contextPath}/res/vendor/chart.js/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/res/js/front.js"></script>
    <script src="${pageContext.request.contextPath}/res/vendor/bootstrap/js/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
    <script type="text/javascript">
		 $('.datepicker').datepicker({
	    	 weekStart:1,
	    	 color: 'red'
		 });
	</script>
  </body>
</html>