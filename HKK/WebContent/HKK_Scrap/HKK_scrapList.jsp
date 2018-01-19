<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="SCsetting.jsp"%> 

<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script type="text/javascript" src="/HKK/js/jquery.ui.datepicker-ko.js"></script>
<script src = "/HKK/todayHKK/todayHKK.js"></script>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet"> 
<link href="/HKK/css/HKK_style.css" rel="stylesheet" type="text/css">
<jsp:include page="../HKK_menu.jsp" flush="false"/>

<!-- 메뉴바 중단 -->
<div class="index2-banner">
   <div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
      <div class="index2-banner-text">
         <div class="text-logo"><img src="/HKK/images/scrap.png" width="150" height="auto" 
         style="margin-left: 38%; margin-top:-1%"></div>
      </div>
</div>

<!-- ======================================================================================================= -->   
<!-- 메뉴바 하단 -->   
<br><br><br><br><br><br><br>   
<!-- ======================================================================================================= -->   
<!-- 리스트 -->

<table class="table table-striped table-bordered table-hover table-condensed" style="text-align: center; width:1000; margin:auto; border : 1px solid #dddddd ">
   <tr>
      <th style="width:7%">${str_num}</th>
      <th style="width:7%">${str_cotegory}</th>
      <th colspan="2" style="width:35%">${str_subject}</th>
      <th style="width:10%">${str_writer}</th>
      <th style="width:10%">${str_scrap_x}</th>
   </tr>
   <c:if test="${count==0}">
   <tr>
      <td colspan="5" align="center">${msg_list_x}</td>
   </tr>
   </c:if>
   <c:if test="${count!=0}">
   <c:forEach var="ScrapDto" items="${articles}">
   <tr align="center">
      <th>${ScrapDto.s_connum}</th>
      <td>
         <c:if test="${ScrapDto.s_foodcode==1}">${str_food1}</c:if>
         <c:if test="${ScrapDto.s_foodcode==2}">${str_food2}</c:if>
         <c:if test="${ScrapDto.s_foodcode==3}">${str_food3}</c:if>
         <c:if test="${ScrapDto.s_foodcode==4}">${str_food4}</c:if>
         <c:if test="${ScrapDto.s_foodcode==5}">${str_food5}</c:if>
      </td>
      <td style="width:35%">
         <a href="receipeView.do?food_connum=${ScrapDto.s_connum}&foodcode=${ScrapDto.s_foodcode}">
         <img src="${path}${ScrapDto.s_img_path}" alt="${str_img_x}" galleryimg="no" border="0" style="width:230px; height:auto;"></a>
      </td>
      <td>
         <a href="receipeView.do?food_connum=${ScrapDto.s_connum}&foodcode=${ScrapDto.s_foodcode}" style="color:black;">${ScrapDto.s_r_title}</a>
      </td>
      <td style="width:35%">${ScrapDto.s_r_id}</td>
      <td>
         <input type="button" value="${btn_scrap_x}" onclick="location='rkrkrk.do?s_renum=${ScrapDto.s_renum}'">
      </td>
   </tr>
   </c:forEach>
   </c:if>
</table>
<!-- =============================================================================================== -->
<!-- 페이지 -->

<center>
<c:if test="${count gt 0 }">
   <c:if test="${cstartPage gt pageBlock }">
         <a href="HKK_scrapList.do">[◀◀]</a>
         <a href="HKK_scrapList.do?pageNum=${startPage-pageBlock}">[◀]</a>
   </c:if>
      <c:forEach var="i" begin="${startPage}" end="${endPage}">
         <c:if test="${i == currentPage }">
         [${i}]
         </c:if>
         <c:if test="${i != currentPage}">
            <a href="HKK_scrapList.do?pageNum=${i}">[${i}]</a>
         </c:if>
      </c:forEach>
      <c:if test="${pageCount > endPage}">
         <a href="HKK_scrapList.do?pageNum=${startPage+pageBlock}">[▶]</a>
         <a href="HKK_scrapList.do?pageNum=${pageCount}">[▶▶]</a>
      </c:if>

</c:if>
</center>




<jsp:include page="../HKK_bottom.jsp" flush="false"/> 