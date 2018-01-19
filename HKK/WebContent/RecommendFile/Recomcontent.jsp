<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<script src="/HKK/RecommendFile/recommendJS.js"></script>
 <link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>
 <link href="${project}css/HKK_style.css" rel="stylesheet" type="text/css">
    
<%@ include file="REsetting.jsp"%>

<jsp:include page="../HKK_menu.jsp" flush="false"/>

	<div class="index2-banner">
		<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
		
			<div class="text-logo"><img src="/HKK/images/menuRecom.png" width="200" height="auto" 
			style="margin-left: 36%;"></div>

		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
<!-- ======================================================================================= -->
<!-- 비회원인 경우 -->
<div align = "center">
<c:if test="${sessionScope.memId == null }">
	<form>
	<input type="hidden" name="number" value="${number}">
	<table width="900px">
		<tr >
			<th class="line">${str_num}</th>
			<td class="line">${number}</td>
			<th class="line">${str_readcount}</th>
			<td class="line">${RecomDto.r_readcount}</td>
		</tr>
		<tr>
			<th class="line">${str_writer}</th>
			<td class="line">${RecomDto.r_id}</td>
			<th class="line">${str_reg_date}</th>
			<td class="line">
				<fmt:formatDate value="${RecomDto.r_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
			</td>
		</tr>
		<tr>
			<th class="line">${str_subject}</th>
			<td class="line" colspan="3">${RecomDto.r_title}</td>
		</tr>
		<tr>
			<th class="line" >${str_content}</th>
			<td class="line" colspan="3">
			<c:forEach var="ReComcontentDto" items="${RecomCon}">
				<img src="${path}${ReComcontentDto.r_image_path}" border="0"><br>
				${ReComcontentDto.r_content}<br>
			</c:forEach>
			</td>
		</tr>
		<tr>
			<th class="line" colspan="4">${str_Reply}</th>
		</tr>
		<!-- 댓글이 있는 경우 -->
		<c:if test="${checkreply == 1 }">
		<tr>
			<th class="line">${str_writer}</th>
			<th class="line" colspan="2">${str_content}</th>
			<th class="line">${str_reg_date}</th>
		</tr>
	 	<c:forEach var="ReComReDto" items="${articles}">
	 		<tr>
	 			<td class="line">${ReComReDto.r_r_id}</td>
				<td class="line" colspan="2">${ReComReDto.r_r_recontent}</td>
				<td class="line" >
					<fmt:formatDate value="${ReComReDto.r_r_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
					<c:if test="${sessionScope.memId == ReComReDto.r_r_id }">
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</c:if>
		<tr>
			<th class="line" colspan="4">
			<c:if test="${find == null }">
				<input class="input" type="button" value="${btn_list}" onclick="location='RecommendList.do?pageNum=${pageNum}'" style="width:80">
			</c:if>
			<c:if test="${find != null }">
				<input class="input" type="button" value="${btn_list}" onclick="location='RecommendList.do?pageNum=${pageNum}&find=${find}&findfind=${findfind}'" style="width:80">
			</c:if>
			</th>
		</tr>
	</table>
	</form>
</c:if>
</div>
<!-- ============================================================================================= -->
<!-- 회원인 경우 -->
<div align = "center">
<c:if test="${sessionScope.memId != null }">
<form method="post" name="ReConRewriteform" action="RecomReplyPro.do?pageNum=${pageNum}&r_connum=${RecomDto.r_connum}" onsubmit="return ReConCk()">
	<input type="hidden" name="number" value="${number}">
	<table width="900px">
		<tr>
			<th class="line">${str_num}</th>
			<td class="line">${number}</td>
			<th class="line">${str_readcount}</th>
			<td class="line">${RecomDto.r_readcount}</td>
		</tr>
		<tr>
			<th class="line">${str_writer}</th>
			<td class="line">${RecomDto.r_id}</td>
			<th class="line">${str_reg_date}</th>
			<td class="line">
				<fmt:formatDate value="${RecomDto.r_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
			</td>
		</tr>
		<tr>
			<th class="line">${str_subject}</th>
			<td class="line" colspan="3">${RecomDto.r_title}</td>
		</tr>
		
		<c:forEach var="ReComcontentDto" items="${RecomCon}">
			<tr>
				<th class="line">
					<img src="${path}${ReComcontentDto.r_image_path}" onerror="this.style.display='none'" alt='' border="0" style="width:250px; height:auto;"border="0"><br>
				<th class="line" colspan="3">
					<pre>${ReComcontentDto.r_content}</pre>
				</th>
			</tr>
		</c:forEach>	
		
		<tr >
			<td align="right" class="line" colspan="4">
			<c:if test="${sessionScope.memId == RecomDto.r_id }">
				<input class="button3" type="button" value="${btn_delete}" onclick="ReconDel('${RecomDto.r_connum}','${pageNum}')" style="width:80">
			</c:if>
				<c:if test="${find == null }">
				<input class="button3" type="button" value="${btn_list}" onclick="location='RecommendList.do?pageNum=${pageNum}'" style="width:80">
			</c:if>
			<c:if test="${find != null }">
				<input class="button3" type="button" value="${btn_list}" onclick="location='RecommendList.do?pageNum=${pageNum}&find=${find}&findfind=${findfind}'" style="width:80">
			</c:if>
			</td>
		</tr>
		</table>
		<br>
		<br>
		<table width = "900px">
		<tr>
			<th class="line" colspan="4">${str_Reply}</th>
		</tr>
		<tr>
				<th class="line" colspan="3">
					<input class = "textbox" type="text" name="r_reply_content">
				</th>
				<th class="line">
       	 			<input class="button3" type="submit" value="${btn_Reply}">
				</th>
		</tr>
		<c:if test="${checkreply == 1 }">
		<tr>
			<th class="line">${str_writer}</th>
			<th class="line">${str_content}</th>
			<th class="line">${str_reg_date}</th>
			<th class="line"></th>
		</tr>
	 	<c:forEach var="ReComReDto" items="${articles}">
	 	<tr>
	 		<td class="line">${ReComReDto.r_r_id}</td>
			<td class="line" colspan="2">${ReComReDto.r_r_recontent}</td>
			<td class="line">
				<fmt:formatDate value="${ReComReDto.r_r_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
				<c:if test="${sessionScope.memId == ReComReDto.r_r_id }">
				<input class="button3" type="button" value="${btn_Reply_Del}" onclick="ReDelCK('${pageNum}','${RecomDto.r_connum}','${number}','${ReComReDto.r_r_renum}')">
				</c:if>
				<c:if test="${sessionScope.memId != ReComReDto.r_r_id }">
						<th class="line"></th>
				</c:if>
			</td>
		</tr>
		</c:forEach>
		</c:if>

	</table>
	</form>
</c:if>
</div>
<jsp:include page="../HKK_bottom.jsp" flush="false"/>

























