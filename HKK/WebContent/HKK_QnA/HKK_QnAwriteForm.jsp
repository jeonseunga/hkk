<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="Qsetting.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/HKK/HKK_QnA/QnAJS.js"></script>
<link href="${project}css/HKK_style.css" rel="stylesheet" type="text/css">
<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>
<jsp:include page="../HKK_menu.jsp" flush="false"/>

<div class="index2-banner">
		<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
		
			<div class="text-logo"><img src="/HKK/images/write.png" width="130" height="auto" 
			style="margin-left: 41%; margin-top:-1%"></div>

		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div align = "center" >
	<form method="post" action="HKK_QnAwritePro.do" name="QnAwriteform" onsubmit="return QnAwriteck()"> 
		<input type="hidden" name="q_connum" value="${q_connum}">
		<input type="hidden" name="pw" value="${pw}">
		<table align="center">
			<tr>
				<th colspan="2" class="line">
					<a href="HKK_QnAList.do" class="atag" >${str_list}</a>&nbsp;&nbsp;&nbsp;
				</th>
			</tr>
			<tr> 
           		 <th class="line"> ${str_subject} </th>
            	<td class="line"> <input class="textbox" type="text" name="q_title" maxlength="50"> </td>
        	 </tr>  
			<tr>
				<th class="line">${str_content}</th>
				<th class="line">
					<textarea style="border: 1px solid lightgray; resize : none;" rows="10" cols="55" name="q_content"></textarea>
				</th>
			<tr>
				<th class="line" colspan="2">
					<input class="button3" type="submit" value="${btn_write}">
					<input class="button3" type="reset" value="${btn_cancel}">
				</th>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../HKK_bottom.jsp" flush="false"/>


	