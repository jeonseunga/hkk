<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="REsetting.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/HKK/RecommendFile/recommendJS.js"></script>
 <link href="${project}css/HKK_style.css" rel="stylesheet" type="text/css">

<link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'>
 

<body onload="addForm()">
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
	<div align = "center" >
<form method="post" action="RecomwritePro.do" name="Recomwriteform" enctype="multipart/form-data" onsubmit="return ReComwriteck()"> 
	<input type="hidden" name="r_connum" value="${r_connum}">	
		<table align="center">
			 <tr> 
           		 <th class="line"> ${str_subject} </th>
            	<td class="line"> <input class="textbox" type="text" name="r_title" maxlength="50"> </td>
        	 </tr>      
			<tr>
			<th colspan="2" class="line">
	              <input type="hidden" name="count" value="0">
	              <div id="addedFormDiv" class="filebox"></div><BR> <!-- 폼을 삽입할 DIV -->
			</th>
			</tr>
         	<tr>
            <td colspan="2" align="right" class="line">
               <input class = "button2" type="button" name="addreceipe" value="${btn_add}" onclick="addForm()">
            </td>
         	</tr>
			<tr>
            <th colspan="2" class="line">
               <input class = "button3" type="submit" value="${btn_write}">
               <input class = "button3" type="reset" value="${btn_cancel}">
               <input class="button3" type="button" value="${btn_list}"
					onclick="location='HKK_RecommendList.do'">
            </th>
         </tr>
		</table>
	</form>
	</div>
	<jsp:include page="../HKK_bottom.jsp" flush="false"/>
</body>

