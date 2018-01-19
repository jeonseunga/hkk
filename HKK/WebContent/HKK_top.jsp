<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
  <meta charset="UTF-8">
  <title>Food</title>
  

  
</head>

<body>
  <div class="public-header">
		<div class="public-container clearfloat">
		<div class="header-logo"><a href="#"></a></div>
		<ul class="header-nav clearfloat">
			<c:if test="${sessionScope.memId != null }">
			
		 	<li class="item"><a href="manage.do">MyPage</a></li>
		 	<li class="item"><a href="logout.do">Logout</a></li>
		 	<li class="item"><a href="#">Scrap</a></li>
			
			</c:if>
			
			<c:if test="${sessionScope.memId == null }">
			
		    <li class="item"><a href="HKK_login.do">Login</a></li>
		    <li class="item"><a href="inputForm.do">Join</a></li>
		    
		    
			</c:if>
			
			<li class="item"><a href="#">Notice</a></li>
			<li class="item"><a href="todayHKK.do">TodayHankki</a></li>
			<li class="item"><a href="#">Market</a></li>
			<li class="item"><a href="#">Recommend</a></li>
			<li class="item"><a href="#">QnA</a></li>
		</ul>
		</div>
	</div>
	<div class="index2-banner">
		<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
			<div class="text-logo"></div>
			<p class="text-info">
				<i class="line line-left"></i>
				<span class="text">Welcome to Today HanKKi!</span><i class="line line-right"></i>
			</p>
		</div>
	</div>
