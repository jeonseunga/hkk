<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="setting.jsp"%>

<html>
<head>
  <meta charset="UTF-8">
  <title>Food</title>
  
  
 	 <link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>

      <link rel="stylesheet" href="css/HKK_style.css">

  
</head>


<body>
  <div class="public-header">
		<div class="public-container clearfloat">
		<div class="header-logo"><a href="HKK_main.do"><img src = "/HKK/images/todayHKK.png" 
				width = "130" height = auto  style = "margin-top: -18%; margin-left: -10%"></a></div>
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
	
	<div class="index-banner">
		<div class="index-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index-banner-text">
			<div class="text-logo"><img src = "/HKK/images/bannerlogo.png" width = "776" height = auto></div>
			<p class="text-info">
				<i class="line line-left"></i>
				<span class="text">Welcome to todayHKKI</span><i class="line line-right"></i>
			</p>
		</div>
	</div>
	<div class="index-menu">
		<div class="menu-tips">receipe</div>
		<div class="public-container  menu-list">
			<ul class="clearfloat">
            <li class="menu-item clearfloat">
               <a href="category.do?foodcode=${1}" class="title">
                  <h4>${str_hansik}</h4>
                  <p class="comment">한식최고!</p>
               </a>
               <div class="line"></div>
               <div class="price"></div>
            </li>
            <li class="menu-item clearfloat">
               <a href="category.do?foodcode=${2}" class="title">
                  <h4>${str_yangsik}</h4>
                  <p class="comment">파스타, 피자...</p>
               </a>
               <div class="line"></div>
               <div class="price"></div>
            </li>
            <li class="menu-item clearfloat">
               <a href="category.do?foodcode=${3}" class="title">
                  <h4>${str_ilsik}</h4>
                  <p class="comment">초밥, 돈까스, 덮밥...</p>
               </a>
               <div class="line"></div>
               <div class="price"></div>
            </li>
            <li class="menu-item clearfloat">
               <a href="category.do?foodcode=${4}" class="title">
                  <h4>${str_joongsik}</h4>
                  <p class="comment">짜장면, 탕수육, 짬뽕...</p>
               </a>
               <div class="line"></div>
               <div class="price"></div>
            </li>
            <li class="menu-item clearfloat">
               <a href="category.do?foodcode=${5}" class="title">
                  <h4>${str_dessert}</h4>
                  <p class="comment">케이크, 파르페, 타르트...</p>
               </a>
               <div class="line"></div>
               <div class="price"></div>
            </li>
			</ul>
		</div>
	</div>
	<div class="index-panel">
		<div class="inedx-panel-header clearfloat">
			<h3>${str_hansik}</h3>
			<div class="line"></div>
		</div>
		<div class="index-panel-body index-food-list">
			<ul class="clearfloat">
				<c:set var="i" value="${0}"/>
				<c:forEach var="han" items="${hansik}">
				<li class="food-item">
					<a href="receipeView.do?food_connum=${han.food_connum}&foodcode=${1}">
					<img src="${imgpath}${Hcontent[i]}" class="banner" alt="" border="0">
					<c:set var="i" value="${i+1}"/>
					<div class="name">${han.food_title}</div>
					<div class="name">${han.food_id}</div>
					</a>
				</li>
				
				</c:forEach>
				<li class="food-item">
					<a href="category.do?foodcode=${1}">
					<img src="images/next.jpg" class="banner" alt="" border="0">
					</a>
				</li>
			</ul>
		</div>
		
		<br>
		
		<div class="inedx-panel-header clearfloat">
			<h3>${str_yangsik}</h3>
			<div class="line"></div>
		</div>
		<div class="index-panel-body index-food-list">
			<ul class="clearfloat">
				<c:set var="i" value="${0}"/>
				<c:forEach var="yang" items="${yangsik}">
				<li class="food-item">
					<a href="receipeView.do?food_connum=${yang.food_connum}&foodcode=${1}">
					<img src="${imgpath}${Ycontent[i]}" class="banner" alt="" border="0">
					<c:set var="i" value="${i+1}"/>
					<div class="name">${yang.food_title}</div>
					<div class="name">${yang.food_id}</div>
					</a>
				</li>
				<li class="food-item">
				</li>
				</c:forEach>
				<li class="food-item">
					<a href="category.do?foodcode=${2}">
					<img src="images/next.jpg" class="banner" alt="" border="0">
					</a>
				</li>
			</ul>
		</div>
				
		<br>
		
		<div class="inedx-panel-header clearfloat">
			<h3>${str_ilsik}</h3>
			<div class="line"></div>
		</div>
		<div class="index-panel-body index-food-list">
			<ul class="clearfloat">
				<c:set var="i" value="${0}"/>
				<c:forEach var="il" items="${ilsik}">
				<li class="food-item">
					<a href="receipeView.do?food_connum=${il.food_connum}&foodcode=${1}">
					<img src="${imgpath}${Icontent[i]}" class="banner" alt="" border="0">
					<c:set var="i" value="${i+1}"/>
					<div class="name">${il.food_title}</div>
					<div class="name">${il.food_id}</div>
					</a>
				</li>
				</c:forEach>
				<li class="food-item">
					<a href="category.do?foodcode=${3}">
					<img src="images/next.jpg" class="banner" alt="" border="0">
					</a>
				</li>
			</ul>
		</div>
				
		<br>
		
		<div class="inedx-panel-header clearfloat">
			<h3>${str_joongsik}</h3>
			<div class="line"></div>
		</div>
		<div class="index-panel-body index-food-list">
			<ul class="clearfloat">
				<c:set var="i" value="${0}"/>
				<c:forEach var="joong" items="${joongsik}">
				<li class="food-item">
					<a href="receipeView.do?food_connum=${joong.food_connum}&foodcode=${1}">
					<img src="${imgpath}${Jcontent[i]}" class="banner" alt="" border="0">
					<c:set var="i" value="${i+1}"/>
					<div class="name">${joong.food_title}</div>
					<div class="name">${joong.food_id}</div>
					</a>
				</li>
				</c:forEach>
				<li class="food-item">
					<a href="category.do?foodcode=${4}">
					<img src="images/next.jpg" class="banner" alt="" border="0">
					</a>
				</li>
			</ul>
		</div>
				
		<br>
		
		<div class="inedx-panel-header clearfloat">
			<h3>${str_dessert}</h3>
			<div class="line"></div>
		</div>
		<div class="index-panel-body index-food-list">
			<ul class="clearfloat">
				<c:set var="i" value="${0}"/>
				<c:forEach var="desert" items="${dessert}">
				<li class="food-item">
					<a href="receipeView.do?food_connum=${desert.food_connum}&foodcode=${1}">
					<img src="${imgpath}${Hcontent[i]}" class="banner" alt="" border="0">
					<c:set var="i" value="${i+1}"/>
					<div class="name">${desert.food_title}</div>
					<div class="name">${desert.food_id}</div>
					</a>
				</li>
				</c:forEach>
				<li class="food-item">
					<a href="category.do?foodcode=${5}">
					<img src="images/next.jpg" class="banner" alt="" border="0">
					</a>
				</li>
			</ul>
		</div>
	</div>


  
  <jsp:include page="HKK_bottom.jsp" flush="false"/> 	
</body>
</html>
