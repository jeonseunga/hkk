<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file = "Joinsetting.jsp"%>  
<html>
<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300'>

      <link rel="stylesheet" href="css/HKK_style.css">

	<jsp:include page="../HKK_menu.jsp" flush="false"/>
<head>
  <meta charset="UTF-8">
  <title>login</title>
 
</head>
<body class="body">


  <div class="wrapper">
	<div class="con">
		<h1>${str_welcome }</h1>
		
		<form class="form" method="post" action="loginPro.do">
			<input class="forminput" type="text" name="id" placeholder="id">
			<input class="forminput" type="password" name="pw" placeholder="Password">
			<button class="formbutton"type="submit" id="login-button">${btn_login_login}</button>
		</form>
	</div>
	
	<ul class="bg-bubbles">
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<jsp:include page="../HKK_bottom.jsp" flush="false"/> 	
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

</body>

</html>

