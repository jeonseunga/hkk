<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="Rsetting.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta charset="UTF-8">
  <title>Food</title>
  
  
     <link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>

      <link rel="stylesheet" href="css/HKK_style.css">

  
</head>

<body>
<jsp:include page="../HKK_menu.jsp" flush="false"/>


	<div class="index2-banner">
		<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
		
			<div class="text-logo"><img src="/HKK/images/desert.png" width="150" height="auto" 
			style="margin-left: 40%; margin-top:-1%"></div>

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
   
    <table align="right">
	   <c:if test="${sessionScope.memId != null}">
	            <td align="left">
	               <input class="button1" type="button" value="${btn_write}" onclick="location='receipewriteForm.do'">
	            </td>
	   </c:if>
	</table>
	
      <div class="inedx-panel-header clearfloat">
         <h3>${str_dessert}</h3>
         <div class="line"></div>
      </div>
      <c:if test="${count==0}">
		<table>
				<tr>
					<td align="center">${msg_list_x}</td>
				</tr>
		</table>
		</c:if>
		<c:if test="${count!=0}">
      <div class="index-panel-body index-food-list">
         <ul class="clearfloat">
            <c:set var="i" value="${0}"/>
            <c:forEach var="desert" items="${write}">
            <li class="food-item">
               <a href="receipeView.do?food_connum=${desert.food_connum}&food_code=${desert.food_code}">
               <img src="${imgpath}${content[i]}" class="banner" alt="" border="0">
               <c:set var="i" value="${i+1}"/>
               <div class="name">${desert.food_title}</div>
               <div class="name">${desert.food_id}</div>
               </a>
            </li>
            </c:forEach>
         </ul>
      </div>
      </c:if>
   </div>
   <br>
   <br>
   <div align = "center">
   <form action="search.do" method="post">
	 <table align = "center">
	 	<tr>
            <td>
               <input type="hidden" name="foodcode" value="${param.foodcode}">
               <select name="search">
                  <option value="id"> ${str_writer} </option>
                  <option value="title"> ${str_title} </option>
               </select>
            </td>
            <td>   
               <input type="text" name="serch">
               <input type="submit" class="button2" value="${str_search}">
            <td>
         </tr>
      </table>
    </form>
    </div>
    <center>
		<c:if test="${count gt 0 }">
			<c:if test="${cstartPage gt pageBlock }">
				<a class="atag" href="category.do?foodcode=${1}">[◀◀]</a>
				<a class="atag" href="category.do?foodcode=${1}&pageNum=${startPage-pageBlock}">[◀]</a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<c:if test="${i == currentPage }">[${i}]</c:if>
				<c:if test="${i != currentPage}"><a class="atag" href="category.do?foodcode=${1}&pageNum=${i}" >[${i}]</a></c:if>
			</c:forEach>
			<c:if test="${pageCount > endPage}">
				<a class="atag" href="category.do?foodcode=${1}&pageNum=${startPage+pageBlock}">[▶]</a>
				<a class="atag" href="category.do?foodcode=${1}&pageNum=${pageCount}">[▶▶]</a>
			</c:if>
		</c:if>
	</center>
  <jsp:include page="../HKK_bottom.jsp" flush="false"/>    
</body>
</html>