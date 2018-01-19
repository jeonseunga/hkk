<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Qsetting.jsp"%> 

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
			<div class="text-logo"><img src="/HKK/images/qna.png" width="110" height="auto" 
			style="margin-left: 41%; margin-top:4%"></div>
		</div>
</div>

<!-- ======================================================================================================= -->	

<br><br><br><br><br><br><br>	
		
<!-- ======================================================================================================= -->	
<!-- 비회원인 경우 게시판 -->	
<c:if test="${sessionScope.memId == null }">
	<form method="post" action="HKK_QnAList.do">
		<table class="table table-striped table-bordered table-hover table-condensed" style="text-align: center; width:1000; margin:auto; border : 1px solid #dddddd ">
		<tr>
			<th style="width:7%">${str_num}</th>
			<th style="width:35%">${str_subject}</th>
			<th style="width:10%">${str_writer}</th>
			<th style="width:10%">${str_reg_date}</th>
		</tr>
		<tr>
			<td colspan="5" align="center">${msg_log_x}</td>
		</tr>
		</table>
	</form>
</c:if>

<!-- ======================================================================================================= -->	
<!-- 회원인 경우 게시판 -->	
<c:if test="${sessionScope.memId != null }">

<!-- ======================================================================================================= -->	
<!-- 일반사용자인 경우 게시판 -->	
	<c:if test="${memcode != 3 }">      
	
	
	
	<form method="post" action="HKK_QnAList.do">
	<table class="table table-striped table-bordered table-hover table-condensed" style="text-align: center; width:1000; margin:auto; border : 1px solid #dddddd ">
		<th colspan="4" style="text-align: right;">
		<a href="HKK_QnAwriteForm.do?pw=${pw}" style="color:black;">${str_write}</a>
		</th>
		<tr>
			<th style="width:7%">${str_num}</th>
			<th style="width:35%">${str_subject}</th>
			<th style="width:10%">${str_writer}</th>
			<th style="width:10%">${str_reg_date}</th>
		</tr>
		<c:if test="${count==0}">
				<tr>
					<td colspan="6" align="center">${msg_list_x}</td>
				</tr>
		</c:if>
		<c:if test="${count!=0}">
		<c:forEach var="QnADto" items="${articles}">
					<tr>
						<td>${QnADto.q_connum}</td>
						<c:if test="${find == null }">
						<td style="width:35%">
						<a href="HKK_QnAcontentPWForm.do?pageNum=${pageNum}&q_connum=${QnADto.q_connum}&number=${number+1}" style="color:black;">
						${QnADto.q_title}</a>
						</td>
						</c:if>
						<c:if test="${find != null }">
						<td style="width:35%">
						<a href="HKK_QnAcontentPWForm.do?pageNum=${pageNum}&q_connum=${QnADto.q_connum}&number=${number+1}&find=${find}&findfind=${findfind}" style="color:black;">
						${QnADto.q_title}</a>
						</td>
						</c:if>
						<td style="color:black;">${QnADto.q_id}</td>
						<td style="width:10%">
							<fmt:formatDate value="${QnADto.q_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
						</td>
					</tr>
		</c:forEach>
		</c:if>

	</table>
<br>	
<div align="center">

	<select name="find">
		<option value="1">${str_writer}</option>
		<option value="2">${str_subject}</option>
	</select> 
		<input type="text" name="findfind">
		<input type="submit" value="${btn_find}">
</div>
	</form>


	</c:if>
	
<!-- ======================================================================================================= -->	
<!-- 관리자인 경우 게시판 -->	
	<c:if test="${memcode == 3 }">    
	<form method="post" action="HKK_QnAList.do">
	<table class="table table-striped table-bordered table-hover table-condensed" style="text-align: center; width:1000; margin:auto; border : 1px solid #dddddd ">
		<tr>
			<th style="text-align: center; width:7%">${str_num}</th>
			<th style="text-align: center; width:35%">${str_subject}</th>
			<th style="text-align: center; width:10%">${str_writer}</th>
			<th style="text-align: center; width:10%">${str_reg_date}</th>
		</tr>
		<c:if test="${count==0}">
				<tr>
					<td colspan="6" align="center">${msg_list_x}</td>
				</tr>
		</c:if>
		<c:if test="${count!=0}">
		<c:forEach var="QnADto" items="${articles}">
					<tr>
						<td>${QnADto.q_connum}</td>
						<c:if test="${find == null }">
						<td style="width:35%">
						<a href="HKK_QnAcontent.do?pageNum=${pageNum}&q_connum=${QnADto.q_connum}&number=${number+1}" style="color:black;">
						${QnADto.q_title}</a>
						</td>
						</c:if>
						<c:if test="${find != null }">
						<td style="width:35%">
						<a href="HKK_QnAcontent.do?pageNum=${pageNum}&q_connum=${QnADto.q_connum}&number=${number+1}&find=${find}&findfind=${findfind}" style="color:black;">
						${QnADto.q_title}</a>
						</td>
						</c:if>
						<td style="color:black;">${QnADto.q_id}</td>
						<td style="width:10%">
							<fmt:formatDate value="${QnADto.q_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
						</td>
					</tr>
		</c:forEach>
		</c:if>

	</table>
<center>	
	<select name="find">
		<option value="1">${str_writer}</option>
		<option value="2">${str_subject}</option>
	</select> 
		<input type="text" name="findfind">
		<input type="submit" value="${btn_find}">
</center>
	</form>
	</c:if>
</c:if>

<!-- ======================================================================================================= -->	
<!-- 검색을 안한 경우 페이지 -->	
<br><br>
<c:if test="${find == null }">
	<center>
		<c:if test="${count gt 0 }">
			<c:if test="${cstartPage gt pageBlock }">
				<a class="atag" href="HKK_QnAList.do">[◀◀]</a>
				<a class="atag" href="HKK_QnAList.do?pageNum=${startPage-pageBlock}">[◀]</a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<c:if test="${i == currentPage }">[${i}]</c:if>
				<c:if test="${i != currentPage}"><a class="atag" href="HKK_QnAList.do?pageNum=${i}" style="color:black;">[${i}]</a></c:if>
			</c:forEach>
			<c:if test="${pageCount > endPage}">
				<a class="atag" href="HKK_QnAList.do?pageNum=${startPage+pageBlock}">[▶]</a>
				<a class="atag" href="HKK_QnAList.do?pageNum=${pageCount}">[▶▶]</a>
			</c:if>
		</c:if>
	</center>
</c:if>

<!-- ======================================================================================================= -->	
<!-- 검색을 한 경우 페이지 -->	
<c:if test="${find != null }">
	<center>
		<c:if test="${count gt 0 }">
			<c:if test="${cstartPage gt pageBlock }">
				<a href="HKK_QnAList.do?find=${find}&findfind=${findfind}">[◀◀]</a>
				<a href="HKK_QnAList.do?pageNum=${startPage-pageBlock}&find=${find}&findfind=${findfind}">[◀]</a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<c:if test="${i == currentPage }">[${i}]</c:if>
				<c:if test="${i != currentPage}"><a href="HKK_QnAList.do?pageNum=${i}&find=${find}&findfind=${findfind}" style="color:black;">[${i}]</a></c:if>
			</c:forEach>
			<c:if test="${pageCount > endPage}">
				<a href="HKK_QnAList.do?pageNum=${startPage+pageBlock}&find=${find}&findfind=${findfind}">[▶]</a>
				<a href="HKK_QnAList.do?pageNum=${pageCount}&find=${find}&findfind=${findfind}">[▶▶]</a>
			</c:if>
		</c:if>
	</center>
</c:if>

<jsp:include page="../HKK_bottom.jsp" flush="false"/>