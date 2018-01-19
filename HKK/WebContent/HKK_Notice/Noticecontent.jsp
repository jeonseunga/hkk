<%@page import="java.text.SimpleDateFormat"%>
<%@page import="notice.NoticeDataBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="notice.NoticeDataBean"%>
<%@page import="notice.NoticeDBBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="NOsetting.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
<link href="/HKK/css/HKK_style.css" rel="stylesheet" type="text/css">


<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'> 
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script src="/HKK/HKK_Notice/script.js"></script>
</head>



 <jsp:include page="../HKK_menu.jsp" flush="false"/> 


<div class="index2-banner">
	<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
			<div class="text-logo"></div>
		</div>
</div>

<br><br>
	   <table class="table table-striped table-bordered table-hover table-condensed" style="text-align: center; width:900; margin:auto; border : 1px solid #dddddd " >

	<input type="hidden" name="num" value="${num}"> <!-- num은 modifyform에서 쓸게 아니라 view에서 쓰기위해 받은거임 view에서 num을 받음 -->
	<input type="hidden" name="pageNum" value="${pageNum}"> <!-- 다음페이지로 넘기기 위해 pageNum까지넘김 -->

		
	<thead>
		<tr>
			<th colspan="3" style="background-color: #eeeeee; text-align: center;">공지사항 글보기</th> 
		</tr>
	</thead>	
	
	<tbody>
		<tr>
			<td style="width: 20%;">글 제목</td>
			<td colspan="2">${boardDto.n_title}</td>
		</tr>
	
		<tr>
			<td>작성자</td>
			<td colspan="2">${boardDto.n_id}</td>
		</tr>
		
		<tr>
			<td>작성일자</td>
			<td colspan="2"><fmt:formatDate value="${boardDto.n_reg_date}" type="both" pattern="yyyy-MM-dd"></fmt:formatDate></td>
		</tr>
	
		<tr>
			<td>내용</td>
			<td colspan="2" style="min-height: 200px; text-align: left;">${boardDto.n_content}</td>
		</tr>
	
	<!-- onclick="location='NoticedeletePro.do?num=${boardDto.n_listnum}&pageNum=${pageNum}&writer=${boardDto.n_id}'" -->
	
	
	<tr>
		<th colspan="3" style="text-align: center;">
	
			
			<input class="btn btn-success" type="button" value="${btn_delete}" onclick="deletecheck('${boardDto.n_listnum}','${sessionScope.memId}','${pageNum}','${boardDto.n_id}')">
			<c:if test="${noticechoice == null }">
			<input class="btn btn-success" type="button" value="${btn_prelist}"
			onclick="location='NoticeList.do?pageNum=${pageNum}'">
			</c:if>
			<c:if test="${noticechoice != null }">
			<input class="btn btn-success" type="button" value="${btn_prelist}"
			onclick="location='NoticeList.do?pageNum=${pageNum}&noticechoice=${noticechoice}&search=${search}'">
			</c:if>
			<!-- 보던 페이지로 가야됨pageNum(1페이지를 받아옴) -->
		</th>
	</tr>
</tbody>

</table>

<jsp:include page="../HKK_bottom.jsp" flush="false"/>
