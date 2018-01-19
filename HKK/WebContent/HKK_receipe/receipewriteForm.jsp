<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="Rsetting.jsp"%>

<script src="${project}HKK_receipe/receipe.js"></script>
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
   <form name="writeform" method="post" action="receipewritePro.do" enctype="multipart/form-data"
      onsubmit="return writeCheck()">
      <table  width = "900px">
      <input type="hidden" name="food_readcount" value="0">
         <tr> 
            <th class="line"> ${str_title} </th>
            <td class="line"> <input class="textbox" type="text" name="food_title" maxlength="40"> </td>
         </tr>
         <tr>
            <th class="line"> ${str_youtube} </th>
            <td class="line"> <input class="textbox" type="text" name="food_video_path"> </td>
         </tr>
         <tr>
            <th class="line"> ${str_category} </th>
            <td class="line">
               <select name="foodcode">
                  <option value="1"> ${str_hansik} </option>
                  <option value="2"> ${str_yangsik} </option>
                  <option value="3"> ${str_ilsik} </option>
                  <option value="4"> ${str_joongsik} </option>
                  <option value="5"> ${str_dessert} </option>
               </select>
            </td>
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
               <input class = "button2" type="submit" value="${btn_write_insert}">
               <input class = "button2" type="reset" value="${btn_cancle}">
            </th>
         </tr>
      </table>
      
   </form>
   </div>
   <jsp:include page="../HKK_bottom.jsp" flush="false"/>
</body>
