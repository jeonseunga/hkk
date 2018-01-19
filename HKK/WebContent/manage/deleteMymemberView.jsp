<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300'>
<!-- radio -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.min.css'>
<link rel="stylesheet" href="/HKK/css/HKK_style.css">

<script src = "${project}manage/HKK_manage.js"></script>
<%@ include file="manageSetting.jsp"%>

	<jsp:include page="../HKK_menu.jsp" flush="false"/>
	
<head>
  <meta charset="UTF-8">
  <title>join</title>
 
</head>
<body class="body">


  <div class="wrapper">
	<div class="con">
		
		<form class="formMgb" method="post" action="deleteMyMemberPro.do">
			<table class="table">
				<input type="hidden" name="id" value="${id}">
				<tr>
					<th> <input class="forminput2" type="text" placeholder="${str_pw}" readonly> </th>
					<th><input class="forminput2" type="password" name="pw"></th>
				</tr>
				<tr>
					<th> <button class="formbutton" type="submit" id="login-button">${btn_ok}</button> </th>
					<th> <button class="formbutton" type="button" id="login-button" onclick="location='HKK_main.do'">${btn_cancle}</button> </th>
				</tr>
			</table>
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
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br>


<jsp:include page="../HKK_bottom.jsp" flush="false"/> 	
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

   <!--  <script src="js/index.js"></script> -->

</body>

</html>
