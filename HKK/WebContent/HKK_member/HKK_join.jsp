<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>
<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300'>
<!-- radio -->
<!-- cdn...빼기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.min.css'>

<link rel="stylesheet" href="css/HKK_style.css">

<script src = "/HKK/HKK_member/HKK_member.js"></script>

	<jsp:include page="../HKK_menu.jsp" flush="false"/>
<%@ include file="Joinsetting.jsp"%>
 
<head>
  <meta charset="UTF-8">
  <title>join</title>
 
</head>
<body class="body">

  <div class="wrapperJ">
   <div class="con">
      <form class="formJ" method="post" name="insertform" 
         action="inputPro.do" onsubmit="return inputcheck()">
      
         <input type="hidden" name="checkid" value="0">
         <input type="hidden" name="authnum" value="noCheckemail">
         
         <input class="forminput" type="text" name="id" placeholder="id" onChange="Change()">
         <button class="formbutton"type="button" id="login-button" onclick ="confirmid()">${btn_confirm}</button><br>
         <input class="forminput" type="password" name="pw" placeholder="Password">
         <input class="forminput" type="password" name="repw" placeholder="Check Password">
         <input class="forminput" type="text" name="email" placeholder="email">
         <button class="formbutton"type="button" id="login-button" onclick ="sendemail()">${btn_email_check}</button><br>
         <input class="forminput" type="text" name="emailcode" placeholder="emailcode"><br>
         
         <input class="formcheckbox" type="checkbox" name="gender" value="남자"
                  onclick="oneCheck(this);">${str_gender_men } &nbsp;&nbsp;&nbsp;&nbsp;
           <input class="formcheckbox" type="checkbox" name="gender" value="여자"
                  onclick="oneCheck(this);">${str_gender_woman}    <br><br>
                    
         <button class="formbutton" type="submit" id="login-button">${btn_input}</button>
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
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


<jsp:include page="../HKK_bottom.jsp" flush="false"/>    
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

   <!--  <script src="js/index.js"></script> -->

</body>

</html>