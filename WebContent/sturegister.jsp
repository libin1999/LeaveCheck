<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>注册</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <style type="text/css">
        	.register form select {
				margin-bottom: 10px;
			    padding-top: 4px;
				padding-right: 6px;
				padding-bottom: 4px;
				padding-left: 6px;
				vertical-align: middle;
			    width: 95%;
			    height: 40px;
			    background: #fcfcfc6b;;
			    border: 0.5px solid #ddd;
			    -moz-border-radius: 2px;
			    -webkit-border-radius: 2px;
			    border-radius: 2px;
			    -moz-box-shadow: 0 1px 3px 0 rgba(0,0,0,.1) inset;
			    -webkit-box-shadow: 0 1px 3px 0 rgba(0,0,0,.1) inset;
			    box-shadow: 0 1px 3px 0 rgba(0,0,0,.1) inset;
			    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
			    color: #888;
			    font-size: 16px;
			}
        </style>
    </head>

    <body>

        <div class="header">
            <div class="container">
                <div class="row">
                    <div class="logo col-md-6 span4">
                        <h1><a href="">请假考勤系统<span class="red">....</span></a></h1>
                    </div>
                    <div class="links col-md-6 span8">
                        <a href="login.jsp"><h4>登录</h4></a>
                        <a class="blog"></a>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="register-container container">
            <div class=" register">
            	<form action="" method="post">
            		<h2>学生<span class="red"><strong>注册</strong></span></h2>
            		<div class="row">
		            	<div class=" col-md-6">
		                    <label for="firstname">姓名</label>
		                    <input class="uneditable-input" type="text" id="firstname" name="firstname" placeholder="填写你的姓名...">
		                    <label for="lastname">性别</label>
		                    <select>
		                    	<option selected="selected">请选择--</option>
		                    	<option>男</option>
		                    	<option>女</option>
		                    </select>
		                    <label for="username">登录密码</label>
		                    <input type="text" id="username" name="username" placeholder="choose a username...">
		                    <label for="username">本人联系电话</label>
		                    <input type="text" id="username" name="username" placeholder="choose a username...">
		                    <label for="username">紧急联系人姓名</label>
		                    <input type="text" id="username" name="username" placeholder="choose a username...">
		                    <label for="username">二级学院</label>
		                    <select>
		                    	<option selected="selected">请选择--</option>
		                    	<option>男</option>
		                    	<option>女</option>
		                    </select>
		                	<label for="username">班级</label>
		                    <select>
		                    	<option selected="selected">请选择--</option>
		                    	<option>男</option>
		                    	<option>女</option>
		                    </select>
		                </div>
		                <div class="col-md-6">
		                        <label for="email">学号</label>
		                        <input type="text" id="email" name="email" placeholder="enter your email...">
		                        <label for="password">入学年级份</label>
		                        <input type="password" id="password" name="password" placeholder="choose a password...">
		                        <label for="password">确认密码</label>
		                        <input type="password" id="password" name="password" placeholder="choose a password...">
		                        <label for="password">通讯地址</label>
		                        <input type="password" id="password" name="password" placeholder="choose a password...">
		                        <label for="password">紧急联系人电话</label>
		                        <input type="password" id="password" name="password" placeholder="choose a password...">
		                        <label for="password">专业</label>
		                        <select>
		                    		<option selected="selected">请选择--</option>
			                    	<option>男</option>
			                    	<option>女</option>
			                    </select>
		                        <label for="password">头像</label>
		                        <input style="width: auto;border-radius:0px; border:0px; height: auto;padding: 0px; margin: 0px;" type="file" id="password" name="password" placeholder="choose a password..."> 
		                       
								
		                </div>
		                <button type="submit">提交</button>
	                </div>
                </form>
            </div>
        </div>
        <!-- Javascript -->
        <script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.8.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap3/js/jquery.backstretch.min.js"></script>
        <script src="${pageContext.request.contextPath}/bootstrap3/js/scripts.js"></script>

    </body>

</html>

