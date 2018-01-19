<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300'>
<!-- radio -->

<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.min.css'>
<link rel="stylesheet" href="/HKK/css/HKK_style.css">

<script src = "/HKK/manage/HKK_manage.js"></script>
<%@ include file="manageSetting.jsp"%>

	<jsp:include page="../HKK_menu.jsp" flush="false"/>
	
<head>
  <meta charset="UTF-8">
  <title>manage</title>
 
</head>
<body class="body">


  <div class="wrapperMg">
	<div class="con">
		<form class="formMg" method="post" action="modifyMyMemberPro.do" name="manage" onsubmit="return pwCheck()">
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
					<th><button class="formbutton" type="submit" id="login-button">${btn_modify}</button></th>
					<th><button class="formbutton" type="button" id="login-button"
						onclick="location='deleteMyMemberView.do?id=${memberDto.id}'">${btn_memberdrop}</button></th>
				</tr>
			</table>
			<table class="table">
				<tr>
					<th> <input class="forminput2" type="text" name="search" placeholder="${msg_search}"> </th>
					<th> <button class="formbutton" type="button" id="login-button"
						onclick="searchid()">${btn_search}</button> </th>
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

	<c:if test="${search != null}">
	<div class="wrapperMgb">
		<c:if test="${memberlistDto.id != null}">
		
		<div class="con">
			<form class="formMgb" method="post" action="memberGrantView.do">
				<table class="table">
					<input type="hidden" name="id" value="${memberlistDto.id}">
					<tr>
						<th> <input class="forminput2" type="text"  placeholder="${str_id}" readonly> </th>
						<th> <input class="forminput2" type="text"  placeholder="${memberlistDto.id}" readonly> </th>
					</tr>
					<tr>
						<th> <input class="forminput2" type="text"  placeholder="${str_email}" readonly> </th>
						<th> <input class="forminput2" type="text"  placeholder="${memberlistDto.email}" readonly> </th>
					</tr>
					<tr>
						<th> <input class="forminput2" type="text"  placeholder="${str_gender}" readonly> </th>
						<th> <input class="forminput2" type="text"  placeholder="${memberlistDto.gender}" readonly> </th>
					</tr>
					<tr>
						<th> <input class="forminput2" type="text"  placeholder="${str_grantlevel}" readonly> </th>
						<th> <input class="forminput2" type="text"  placeholder="${memberlistDto.memcode}" readonly> </th>
					</tr>
					<tr>
						<th> <button class="formbutton"type="submit" id="login-button">${btn_grantupdate}</button> </th>
						<th> <button class="formbutton"type="button" id="login-button"
								onclick="location='deleteMemberView.do?id=${memberlistDto.id}'">${btn_memberdrop}</button> </th>
					</tr>
				</table>
			</form>
		</div>
		</c:if>

		<c:if test="${memberlistDto.id == null}">
		<div class="con">
			<form class="formMgb">
				<table class="table">
					<tr>
						<th>
							<input class="forminput3" type="text"  placeholder="${msg_noid}" readonly>
						</th>
					</tr>
				</table>
			</form>
		</div>
		
		</c:if>
		
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
	</c:if>
	

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<jsp:include page="../HKK_bottom.jsp" flush="false"/> 	
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

   <!--  <script src="js/index.js"></script> -->

</body>

</html>
