<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
  <div class="public-header">
		<div class="public-container clearfloat">
		<div class="header-logo"><a href="#"><img src = "/HKK/images/todayHKK.png" 
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
						<p class="comment">Cheese, tomato, mushrooms, onions.</p>
					</a>
					<div class="line"></div>
					<div class="price"></div>
				</li>
				<li class="menu-item clearfloat">
					<a href="category.do?foodcode=${2}" class="title">
						<h4>${str_yangsik}</h4>
						<p class="comment">Arcu pede enim justo.</p>
					</a>
					<div class="line"></div>
					<div class="price"></div>
				</li>
				<li class="menu-item clearfloat">
					<a href="category.do?foodcode=${3}" class="title">
						<h4>${str_ilsik}</h4>
						<p class="comment">Chicken, mozzarella cheese, onions.</p>
					</a>
					<div class="line"></div>
					<div class="price"></div>
				</li>
				<li class="menu-item clearfloat">
					<a href="category.do?foodcode=${4}" class="title">
						<h4>${str_joongsik}</h4>
						<p class="comment">Pineapple, Minced Beef, Cheese.</p>
					</a>
					<div class="line"></div>
					<div class="price"></div>
				</li>
				<li class="menu-item clearfloat">
					<a href="category.do?foodcode=${5}" class="title">
						<h4>${str_dessert}</h4>
						<p class="comment">Tuna, Sweetcorn, Cheese.</p>
					</a>
					<div class="line"></div>
					<div class="price"></div>
				</li>
			</ul>
		</div>
	</div>
</html>