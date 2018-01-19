<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300'>
<!-- radio -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.min.css'>
<link rel="stylesheet" href="/HKK/css/HKK_style.css">

<script src = "/HKK/manage/HKK_manage.js"></script>
<%@ include file="manageSetting.jsp"%>

	<jsp:include page="../HKK_menu.jsp" flush="false"/>
	
<head>
  <meta charset="UTF-8">
  
 
</head>
<body class="body">


  <div class="wrapper">
	<div class="con">
	<br>
		<h1>${msg_grant}</h1>
	<br>
	<br>	
	<br>
		<form class="formMgb" method="post" action="memberGrantPro.do" name="manage">
			<table class="table">
				<input type="hidden" name="id" value="${id}">
				<input type="hidden" name="mem" value="${memcode}">
				<tr>
					<th colspan="2">
						<input class="formcheckbox" type="checkbox" name="memcode" value="1"
						onclick="grantCheck(this)">사용자 &nbsp;&nbsp;&nbsp;&nbsp;
        				<input class="formcheckbox" type="checkbox" name="memcode" value="2"
        				onclick="grantCheck(this)">협력처&nbsp;&nbsp;&nbsp;&nbsp;
        				<input class="formcheckbox" type="checkbox" name="memcode" value="3"
						onclick="grantCheck(this)">관리자
					</th>
				</tr>
				<tr>
					<th colspan="2">
					<br><br>
					</th>
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
