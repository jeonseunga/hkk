<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="MKsetting.jsp"%> 

<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
<script type="text/javascript" src="/HKK/js/jquery.ui.datepicker-ko.js"></script>
<script src = "/HKK/todayHKK/todayHKK.js"></script>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
 
<link href="/HKK/css/HKK_style.css" rel="stylesheet" type="text/css">
<jsp:include page="../HKK_menu.jsp" flush="false"/>

<!-- 메뉴바 중단 -->

<div class="index2-banner">
	<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
			<div class="text-logo"><img src="/HKK/images/menuMarket.png" width="110" height="auto" 
			style="margin-left: 41%; margin-top:-1%"></div>
		</div>
</div>

<!-- ======================================================================================================= -->	

<br><br><br><br>	
<!-- ======================================================================================================= -->	
<!-- 비회원인 경우 -->	
<c:if test="${sessionScope.memId == null }">
      <form method="post" action="HKK_marketList.do">

		
		<c:if test="${count==0}">
		<div align = "center">
		      <table>
				<tr>
					<td colspan="5" align="center">${msg_list_x}</td>
				</tr>
			 </table>
		</div>	 
		</c:if>
		
		<div class="index-panel">
		<div class="index-panel-body index-food-list">
         <ul class="clearfloat">
		<c:if test="${count!=0}">
			<c:set var="i" value="${0}"/>
			<c:forEach var="MarketDto" items="${articles}">
						<c:if test="${find==null}">
							<li class="food-item">
				            <a href="content.do?pageNum=${pageNum}&m_connum=${MarketDto.m_connum}&number=${number+1}">
							<img src="${path}${recomcntent.get(i).getM_image_path()}" class="banner" border="0">
							<c:set var="i" value="${i+1}"/>
				               <div class="name">${MarketDto.m_title}</div>
				               <div class="name">${MarketDto.m_id}</div>
				                <div class="name"><fmt:formatDate value="${MarketDto.m_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/></div>
				               </a>
				            </li>
						</c:if>
							            
						<c:if test="${find!=null}">
							<li class="food-item">
				              <a href="content.do?pageNum=${pageNum}&m_connum=${MarketDto.m_connum}&number=${number+1}&find=${find}&findfind=${findfind}">
				               <img src="${path}${recomcntent.get(i).getM_image_path()}" class="banner" border="0">
				               <c:set var="i" value="${i+1}"/>
				               <div class="name">${MarketDto.m_title}</div>
				               <div class="name">${MarketDto.m_id}</div>
				               <div class="name"><fmt:formatDate value="${MarketDto.m_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/></div>
				               </a>
				            </li>
						</c:if>
			</c:forEach>
		</c:if>
         </ul>
      </div>
      </div>
	  <br>
      <br>
      <div align = "center">
		 <table>
		 	<tr>
	            <td>     
	               <select name="find">
	                  <option value="id"> ${str_writer} </option>
	                  <option value="title"> ${str_subject} </option>
	               </select>
	            </td>
	            <td>   
	               <input type="text" name="findfind">
	               <input type="submit" class="button2" value="${btn_find}">
	            <td>
	         </tr>
	      </table>
    </div>
	</form>
	</c:if>
<!-- =============================================================================================== -->
<!-- 회원인 경우 -->
<c:if test="${sessionScope.memId != null }">	
<!-- 장터 게시물 작성 가능한 경우 -->
	<c:if test="${memcode == 2 }">    
	&nbsp;&nbsp;&nbsp;<input type="button" class="button1" value="${str_write}" 
	 onclick="location.href = 'HKK_marketwriteForm.do'">  
      <form method="post" action="HKK_marketList.do">

		
		<c:if test="${count==0}">
		      <table>
				<tr>
					<td colspan="5" align="center">${msg_list_x}</td>
				</tr>
			 </table>
		</c:if>
		
		<div class="index-panel">
		<div class="index-panel-body index-food-list">
         <ul class="clearfloat">
		<c:if test="${count!=0}">
			<c:set var="i" value="${0}"/>
			<c:forEach var="MarketDto" items="${articles}">
						<c:if test="${find==null}">
							<li class="food-item">
				            <a href="content.do?pageNum=${pageNum}&m_connum=${MarketDto.m_connum}&number=${number+1}">
							<img src="${path}${recomcntent.get(i).getM_image_path()}" class="banner" border="0">
							<c:set var="i" value="${i+1}"/>
				               <div class="name">${MarketDto.m_title}</div>
				               <div class="name">${MarketDto.m_id}</div>
				                <div class="name"><fmt:formatDate value="${MarketDto.m_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/></div>
				               </a>
				            </li>
						</c:if>
							            
						<c:if test="${find!=null}">
							<li class="food-item">
				              <a href="content.do?pageNum=${pageNum}&m_connum=${MarketDto.m_connum}&number=${number+1}&find=${find}&findfind=${findfind}">
				               <img src="${path}${recomcntent.get(i).getM_image_path()}" class="banner" border="0">
				               <c:set var="i" value="${i+1}"/>
				               <div class="name">${MarketDto.m_title}</div>
				               <div class="name">${MarketDto.m_id}</div>
				               <div class="name"><fmt:formatDate value="${MarketDto.m_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/></div>
				               </a>
				            </li>
						</c:if>
			</c:forEach>
		</c:if>
         </ul>
      </div>
      </div>
	  <br>
      <br>
      <div align = "center">
		 <table>
		 	<tr>
	            <td>     
	               <select name="find">
	                  <option value="id"> ${str_writer} </option>
	                  <option value="title"> ${str_subject} </option>
	               </select>
	            </td>
	            <td>   
	               <input type="text" name="findfind">
	               <input type="submit" class="button2" value="${btn_find}">
	            <td>
	         </tr>
	      </table>
    </div>
	</form>
	</c:if>
<!-- 장터 게시물 작성 권한이 없는 경우 -->
	<c:if test="${memcode != 2 }">    
     <form method="post" action="HKK_marketList.do">

		
		<c:if test="${count==0}">
		      <table>
				<tr>
					<td colspan="5" align="center">${msg_list_x}</td>
				</tr>
			 </table>
		</c:if>
		
		<div class="index-panel">
		<div class="index-panel-body index-food-list">
         <ul class="clearfloat">
		<c:if test="${count!=0}">
			<c:set var="i" value="${0}"/>
			<c:forEach var="MarketDto" items="${articles}">
						<c:if test="${find==null}">
							<li class="food-item">
				            <a href="content.do?pageNum=${pageNum}&m_connum=${MarketDto.m_connum}&number=${number+1}">
							<img src="${path}${recomcntent.get(i).getM_image_path()}" class="banner" border="0">
							<c:set var="i" value="${i+1}"/>
				               <div class="name">${MarketDto.m_title}</div>
				               <div class="name">${MarketDto.m_id}</div>
				                <div class="name"><fmt:formatDate value="${MarketDto.m_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/></div>
				               </a>
				            </li>
						</c:if>
							            
						<c:if test="${find!=null}">
							<li class="food-item">
				              <a href="content.do?pageNum=${pageNum}&m_connum=${MarketDto.m_connum}&number=${number+1}&find=${find}&findfind=${findfind}">
				               <img src="${path}${recomcntent.get(i).getM_image_path()}" class="banner" border="0">
				               <c:set var="i" value="${i+1}"/>
				               <div class="name">${MarketDto.m_title}</div>
				               <div class="name">${MarketDto.m_id}</div>
				               <div class="name"><fmt:formatDate value="${MarketDto.m_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/></div>
				               </a>
				            </li>
						</c:if>
			</c:forEach>
		</c:if>
         </ul>
      </div>
      </div>
	  <br>
      <br>
      <div align = "center">
		 <table>
		 	<tr>
	            <td>     
	               <select name="find">
	                  <option value="id"> ${str_writer} </option>
	                  <option value="title"> ${str_subject} </option>
	               </select>
	            </td>
	            <td>   
	               <input type="text" name="findfind">
	               <input type="submit" class="button2" value="${btn_find}">
	            <td>
	         </tr>
	      </table>
    </div>
	</form>
	</c:if>
</c:if>

<!-- ==================================================================================== -->
<!-- 검색을 하지 않은 경우 페이지 -->
<br>
<c:if test="${find == null }">
			<center>
<c:if test="${count gt 0 }">
	<c:if test="${cstartPage gt pageBlock }">
			<a class="atag" href="HKK_marketList.do" style="color:black;">[◀◀]</a>
			<a class="atag" href="HKK_marketList.do?pageNum=${startPage-pageBlock}" style="color:black;">[◀]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${i == currentPage }">
			[${i}]
			</c:if>
			<c:if test="${i != currentPage}">
				<a class="atag" href="HKK_marketList.do?pageNum=${i}" style="color:black;">[${i}]</a>
			</c:if>
		</c:forEach>
		<c:if test="${pageCount > endPage}">
			<a class="atag" href="HKK_marketList.do?pageNum=${startPage+pageBlock}" style="color:black;">[▶]</a>
			<a class="atag" href="HKK_marketList.do?pageNum=${pageCount}" style="color:black;">[▶▶]</a>
</c:if>

</c:if>
</center>
</c:if>
<!-- ==================================================================================== -->
<!-- 검색을 한 경우 페이지 -->
<c:if test="${find != null }">
	<center>
<c:if test="${count gt 0 }">
	<c:if test="${cstartPage gt pageBlock }">
			<a class="atag" href="HKK_marketList.do?find=${find}&findfind=${findfind}" style="color:black;">[◀◀]</a>
			<a class="atag" href="HKK_marketList.do?pageNum=${startPage-pageBlock}&find=${find}&findfind=${findfind}" style="color:black;">[◀]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${i == currentPage }">
			[${i}]
			</c:if>
			<c:if test="${i != currentPage}">
				<a class="atag" href="HKK_marketList.do?pageNum=${i}&find=${find}&findfind=${findfind}" style="color:black;">[${i}]</a>
			</c:if>
		</c:forEach>
		<c:if test="${pageCount > endPage}">
			<a class="atag" href="HKK_marketList.do?pageNum=${startPage+pageBlock}&find=${find}&findfind=${findfind}" style="color:black;">[▶]</a>
			<a class="atag" href="HKK_marketList.do?pageNum=${pageCount}&find=${find}&findfind=${findfind}" style="color:black;">[▶▶]</a>
</c:if>

</c:if>
</center>
</c:if>

<jsp:include page="../HKK_bottom.jsp" flush="false"/>