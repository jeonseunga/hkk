<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<script src="/HKK/HKK_QnA/QnAJS.js"></script>
<%@ include file="Qsetting.jsp"%>
<script src="/HKK/HKK_MarketFile/marketJS.js"></script>
<link href="${project}css/HKK_style.css" rel="stylesheet" type="text/css">

<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>    
<%@ include file="Qsetting.jsp"%>
<jsp:include page="../HKK_menu.jsp" flush="false"/>
<div class="index2-banner">
	<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
			<div class="text-logo"></div>
		</div>
</div>
<br><br><br>
<div align = "center">
<form method="post" action="HKK_QnAReplyPro.do?q_connum=${QnADto.q_connum}">
<input type="hidden" name="number" value="${number}">
<input type="hidden" name="pageNum" value="${pageNum}">
<table width = "900px">
	<tr>
	    <th colspan="3"  class="line">
	       ${QnADto.q_title}
	    </th>
	</tr>
	<tr>
	    <th class="line">
	     ${str_writer} : ${QnADto.q_id}
	    </th>
	    <th class="line">
	     ${str_reg_date} : <fmt:formatDate value="${QnADto.q_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
	    </th>
	    <th class="line"></th>
	</tr>
	<tr>	
		<th class="line">${str_content}</th>					
		<th colspan="2" class="line">
		<pre>${QnADto.q_content}</pre>
		</th>
	</tr>
	</table>
	<br>
	<br>
	<table width="900px";>
	<tr>
		<th class="line" colspan="4">${str_Reply}</th>
	</tr>
	<c:if test="${memcode==3}">
	<tr>
		<th class="line" colspan="3">
       	 	<input type="text" class="textbox" name="r_reply_content">
       	 </th>
       	 <th class="line">
       	 	<input class="button3" type="submit" value="${btn_Reply}">
		</th>
	</tr>
	</c:if>
	<c:if test="${checkreply == 1 }">
		<tr>
			<th class="line">${str_writer}</th>
			<th class="line">${str_content}</th>
			<th class="line">${str_reg_date}</th>
			<th class="line"></th>
		</tr>
	 	<c:forEach var="QnAReDto" items="${articles}">
	 		<tr>
	 			<th class="line">${QnAReDto.q_r_id}</td>
				<th class="line">${QnAReDto.q_recontent}</td>
				<th class="line">
					<fmt:formatDate value="${QnAReDto.q_r_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
				</th>
				<th class="line">	
					<c:if test="${sessionScope.memId == QnAReDto.q_r_id }">
					<input class="button3" type="button" value="${btn_Reply_Del}" onclick="location='HKK_QnAReDelForm.do?pageNum=${pageNum}&q_connum=${QnADto.q_connum}&number=${number}&q_renum=${QnAReDto.q_renum}'">
					</c:if>
				</th>
			</tr>
		</c:forEach>
	</c:if>
	<tr>
		<th class="line" colspan="4">
		<c:if test="${sessionScope.memId == QnADto.q_id }">
			<input class="button3" type="button" value="${btn_delete}" onclick="location='HKK_QnADelForm.do?q_connum=${QnADto.q_connum}&pageNum=${pageNum}&number=${number}'" style="width:80">
		</c:if>
		<c:if test="${find == null }">
			<input class="button3" type="button" value="${btn_list}" onclick="location='HKK_QnAList.do?pageNum=${pageNum}'" style="width:80">
		</c:if>
		<c:if test="${find != null }">
			<input class="button3" type="button" value="${btn_list}" onclick="location='HKK_QnAList.do?pageNum=${pageNum}&find=${find}&findfind=${findfind}'" style="width:80">
		</c:if>
		</th>
	</tr>
</table>
</form>
</div>

<jsp:include page="../HKK_bottom.jsp" flush="false"/>
























