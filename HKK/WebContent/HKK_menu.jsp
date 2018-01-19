<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="public-header">
		<div class="public-container clearfloat">
		<div class="header-logo"><a href="HKK_main.do"><img src = "/HKK/images/todayHKK.png" width = "130" height = auto  style = "margin-top: -18%; margin-left: -10%"></a></div>
		<ul class="header-nav clearfloat">
			<c:if test="${sessionScope.memId != null }">
			
		 	<li class="item"><a href="manage.do">MyPage</a></li>
		 	<li class="item"><a href="logout.do">Logout</a></li>
			<li class="item"><a href="HKK_scrapList.do">Scrap</a></li>
			</c:if>
			
			<c:if test="${sessionScope.memId == null }">
			
		    <li class="item"><a href="HKK_login.do">Login</a></li>
		    <li class="item"><a href="HKK_join.do">Join</a></li>
		    
			</c:if>
			
			<li class="item"><a href="NoticeList.do">Notice</a></li>
			<li class="item"><a href="todayHKK.do">TodayHankki</a></li>
			<li class="item"><a href="HKK_marketList.do">Market</a></li>
			<li class="item"><a href="RecommendList.do">Recommend</a></li>
			<li class="item"><a href="HKK_QnAList.do">QnA</a></li>
			
		</ul>
		</div>
</div>