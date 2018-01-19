<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300'>
<!-- radio -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.min.css'>
<link rel="stylesheet" href="/HKK/css/HKK_style.css">

<script src = "${project}/manage/HKK_manage.js"></script>
<%@ include file="manageSetting.jsp"%>
	<jsp:include page="../HKK_menu.jsp" flush="false"/>
<head>
  <meta charset="UTF-8">
  <title>join</title>
 
</head>
<body class="body">


  <div class="wrapperM">
	<div class="con">
		<h1></h1>
		
		<form class="formM" method="post" action="modifyMyMemberPro.do">
			<table class="table">
				<input type="hidden" name="id" value="${memberDto.id}">
				<tr>
					<th><input class="forminput2" type="text" placeholder="${str_id}" readonly></th>
					<th><input class="forminput2" type="text" placeholder="${memberDto.id}" readonly></th>
				</tr>
				<tr>
					<th><input class="forminput2" type="text" placeholder="${str_pw}" readonly></th>
					<th><input class="forminput2" type="password" name="pw" value="${memberDto.pw}"></th>
				</tr>
				<tr>
					<th><input class="forminput2" type="text" placeholder="${str_email}" readonly></th>
					<th><input class="forminput2" type="text" placeholder="${memberDto.email}" readonly></th>
				</tr>
				<tr>
					<th><input class="forminput2" type="text" placeholder="${str_gender}" readonly></th>
					<th><input class="forminput2" type="text" placeholder="${memberDto.gender}" readonly></th>
				</tr>
				<tr>
					<th><button class="formbutton"type="submit" id="login-button">${btn_modify}</button></th>
					<th><button class="formbutton"type="button" id="login-button"
						 onclick="location='deleteMyMemberView.do?id=${memberDto.id}'">${btn_memberdrop}</button></th>
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

<jsp:include page="../HKK_bottom.jsp" flush="false"/> 	
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

   <!--  <script src="js/index.js"></script> -->

</body>

</html>
