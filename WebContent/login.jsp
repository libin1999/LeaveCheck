
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<link href="${pageContext.request.contextPath}/bootstrap3/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath}/bootstrap3/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Validform_v5.3.2_min.js"></script>
<script>
$(function(){
	
$(".i-text").focus(function(){
	$(this).addClass('h-light');
});
$(".i-text").focusout(function(){
	$(this).removeClass('h-light');
});
	$("#user").focus(function(){
		 var username = $(this).val();
		 if(username=='输入账号'){
		 	$(this).val('');
		 }
	});
	$("#pwd").focus(function(){
		 var username = $(this).val();
		 if(username=='输入密码'){
		 	$(this).val('');
		 }
	});
});
</script>
</head>
<body>
<div class="header" style="height: auto;">
  <h1 class="headerLogo">
  	<img alt="..." src="${pageContext.request.contextPath}/image/logo.jpg" class="img-responsive img-circle pull-left">
  </h1>
</div>
<div class="banner">
<div class="login-aside">
  <div id="o-box-up"></div>
  <div id="o-box-down"  style="table-layout:fixed;">
   <div class="error-box"></div>
   <form class="registerform" action="jugelogin.action" method="post">
   <div class="fm-item" style="padding-bottom: 15px;">
	   <label for="logonId" class="form-label">请假系统登陆：</label>
	   <input name="user.username" type="text" value="输入账号" id="user" class="i-text"   datatype="s6-18" errormsg="用户名至少6个字符,最多18个字符！"  >    
       <div style="color:red;" class="ui-form-explain">${username}</div>
  </div>
  <div class="fm-item" style="padding-bottom:15px;">
	   <label for="logonId" class="form-label">登陆密码：</label>
	   <input name="user.password" type="password" value="输入密码"  id="pwd" class="i-text" datatype="*6-16" nullmsg="请设置密码！" errormsg="密码范围在6~16位之间！">    
       <div style="color:red;" class="ui-form-explain">${password}</div>
  </div>
  <div class="fm-item">
	    <label for="logonId" class="form-label"></label>
	  	<input  type="submit" value="" tabindex="4" id="send-btn" class="btn-login"> 
       <div class="ui-form-explain">
       		<a href="#">教师注册</a>
       		<a style="padding-left: 100px" href="${pageContext.request.contextPath}/sturegister.jsp">学生注册</a>
       </div>
  </div>
  </form>
  </div>
</div>
	<div class="bd">
		<ul>
			<li style="background:url(${pageContext.request.contextPath}/themes/theme-pic1.jpg) #CCE1F3 center 0 no-repeat;"><a target="_blank" href="#"></a></li>
			<li style="background:url(${pageContext.request.contextPath}/themes/theme-pic2.jpg) #BCE0FF center 0 no-repeat;"><a target="_blank" href="#"></a></li>
		</ul>
	</div>
	<div class="hd"><ul></ul></div>
</div>
<script type="text/javascript">jQuery(".banner").slide({ titCell:".hd ul", mainCell:".bd ul", effect:"fold",  autoPlay:true, autoPage:true, trigger:"click" });</script>


<div class="banner-shadow"></div>

<div class="footer">
   <p>Copyright © 2007-2017 znzzxy.sasu.cn All Rights Reserved 四川文理学院智能制造学院|四川省达州市通川区南坝路400号 蜀ICP备 06020089号 欢迎访问新版网站 技术支持</p>
</div>

</body>
</html>
    