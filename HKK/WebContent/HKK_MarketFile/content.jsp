<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  
<script src="/HKK/HKK_MarketFile/marketJS.js"></script>
<link href="${project}css/HKK_style.css" rel="stylesheet" type="text/css">

<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>    
<%@ include file="MKsetting.jsp"%>
<jsp:include page="../HKK_menu.jsp" flush="false"/>
<!-- ============================================================== -->
<div class="index2-banner">
	<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
			<div class="text-logo"><img src="/HKK/images/menuMarket.png" width="110" height="auto" 
			style="margin-left: 41%; margin-top:-1%"></div>
		</div>
</div>
<br>
<br>
<br><br><br>
<!-- 비회원인 경우 -->
<div align = "center">
<c:if test="${sessionScope.memId == null }">
<form method="post" action="HKK_matketReplyPro.do?pageNum=${pageNum}&m_connum=${marketDto.m_connum}">
<input type="hidden" name="number" value="${number}">

		<table width = "900px">
			<tr>
	            <th colspan="3"  class="line">
	               ${marketDto.m_title}
	            </th>
	         </tr>
	         <tr>
	            <th class="line">
	               ${str_writer} : ${marketDto.m_id}
	            </th>
	            <th class="line">
	               ${str_reg_date} : <fmt:formatDate value="${marketDto.m_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
	            </th>
	            <th class="line">
	               ${str_readcount} ${marketDto.m_readcount}
	            </th>
	         </tr>			
				<c:forEach var="MKcontentDto" items="${MkcontentDto}">
					<tr>
						<th class="line">
							<img src="${path}${MKcontentDto.m_image_path}" onerror="this.style.display='none'" alt='' border="0" style="width:250px; height:auto;">
						</th>
						<th colspan="2" class="line">
							<pre>${MKcontentDto.m_content}</pre>
						</th>
					</tr>
				</c:forEach>
		
			
			
			
			<tr>
				<th class="line" colspan="3">
					<c:if test="${find == null }">
					<input class="button3" type="button" value="${btn_list}" onclick="location='HKK_marketList.do?pageNum=${pageNum}'" style="width:80">
					</c:if>
					<c:if test="${find != null }">
					<input class="button3" type="button" value="${btn_list}" onclick="location='HKK_marketList.do?pageNum=${pageNum}&find=${find}&findfind=${findfind}'" style="width:80">
					</c:if>
				</th>
			</tr>
			</table>
			<br>
			<br>
			
			<table width = "900px">
				<tr>
					<th class="line" colspan="3">${str_Reply}</th>
				</tr>
			<c:if test="${checkreply == 1 }">
				<tr>
					<th class="line">${str_writer}</th>
					<th class="line">${str_content}</th>
					<th class="line">${str_reg_date}</th>
					
				</tr>
				<c:forEach var="MkReDto" items="${articles}">
			 		<tr>
			 			<td class="line">${MkReDto.m_r_id}</td>
						<td class="line" colspan="2">${MkReDto.m_r_recontent}</td>
						<td class="line">
							<fmt:formatDate value="${MkReDto.m_r_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
						</td>
					</tr>
				</c:forEach>
		 </c:if>
		</table>
	
	</form>
	</c:if>
	</div>
<!-- ======================================================================= -->
<!-- 회원인 경우 -->
<div align = "center">
<c:if test="${sessionScope.memId != null }">
<form method="post" name="MKcontentForm" action="HKK_marketReplyPro.do?pageNum=${pageNum}&m_connum=${marketDto.m_connum}" onsubmit="return ReplyCk()">
<input type="hidden" name="number" value="${number}">

		<table width = "900px">
			<tr>
	            <th colspan="3"  class="line">
	               ${marketDto.m_title}
	            </th>
	         </tr>
	         <tr>
	            <th class="line">
	               ${str_writer} : ${marketDto.m_id}
	            </th>
	            <th class="line">
	               ${str_reg_date} : <fmt:formatDate value="${marketDto.m_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
	            </th>
	            <th class="line">
	               ${str_readcount} ${marketDto.m_readcount}
	            </th>
	         </tr>
			<tr>
			
				<c:forEach var="MKcontentDto" items="${MkcontentDto}">
					<tr>
						<th class="line">
							<img src="${path}${MKcontentDto.m_image_path}" onerror="this.style.display='none'" alt='' border="0" style="width:250px; height:auto;">
						</th>
						<th colspan="2" class="line">
							<pre>${MKcontentDto.m_content}</pre>
						</th>
					</tr>
				</c:forEach>

			</tr>
			<tr>
				<th class="line" colspan="3">
					<c:if test="${memcode != 3 }">
					<c:if test="${sessionScope.memId == marketDto.m_id }">
						<input class="button3" type="button" value="${btn_delete}" onclick="conDel('${marketDto.m_connum}','${pageNum}','${memcode}')" style="width:80">
					</c:if>
					</c:if>
					<c:if test="${memcode == 3 }">
						<input class="button3" type="button" value="${btn_delete}" onclick="conDel('${marketDto.m_connum}','${pageNum}','${memcode}')" style="width:80">
					</c:if>
					<c:if test="${find == null }">
					<input class="button3" type="button" value="${btn_list}" onclick="location='HKK_marketList.do?pageNum=${pageNum}'" style="width:80">
					</c:if>
					<c:if test="${find != null }">
					<input class="button3" type="button" value="${btn_list}" onclick="location='HKK_marketList.do?pageNum=${pageNum}&find=${find}&findfind=${findfind}'" style="width:80">
					</c:if>
				</th>
			</tr>
			</table>
			<br>
			<br>
			
			<table width = "900px">
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
				<c:forEach var="MkReDto" items="${articles}">
			 		<tr>
			 			<td class="line">${MkReDto.m_r_id}</td>
						<td class="line" colspan="2">${MkReDto.m_r_recontent}</td>
						<td class="line">
							<fmt:formatDate value="${MkReDto.m_r_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
						</td>
						<th class="line">
							<c:if test="${sessionScope.memId == MkReDto.m_r_id }">
							<input class="button3" type="button" value="${btn_Reply_Del}" onclick="ReDel('${pageNum}','${marketDto.m_connum}','${number}','${MkReDto.m_r_renum}')">
							</c:if>
						</th>
					</tr>
				</c:forEach>
		 </c:if>
		</table>
	
	</form>
	</c:if>
	</div>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br>
<jsp:include page="../HKK_bottom.jsp" flush="false"/>


























