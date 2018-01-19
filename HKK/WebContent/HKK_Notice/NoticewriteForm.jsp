<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="NOsetting.jsp"%>



<script src="HKK_Notice/script.js"></script>

<link href="/HKK/css/HKK_style.css" rel="stylesheet" type="text/css">
 <link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'> 

 <link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">


 <jsp:include page="../HKK_menu.jsp" flush="false"/>
 
 
 <div class="index2-banner">
		<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
		
			<div class="text-logo"><img src="/HKK/images/write.png" width="130" height="auto" 
			style="margin-left: 41%; margin-top:-1%"></div>

		</div>
	</div>
 
  <link rel="stylesheet" href="css/HKK_style.css">

<style type="text/css">
   textarea { resize: none; }
</style>



<body onload="writefocus()">
<!-- 데이터는 폼이 받지만 정해진 값을 넘기려면 hidden으로 넘김 -->
   <form method="post" action ="NoticewritePro.do" name="writeform" onsubmit="return writecheck()">
   <input type="hidden" name="num" value="${num}">
   
   <!-- writePro에게 넘길 값들 -->
   <!-- 막아야되 작성자,내용,비밀번호 등등 javascript 생성 -->
   <br><br>
      <table class="table table-striped" style="text-align: center; width:800; margin:auto; border : 1px solid #dddddd " >
      
         <tr>
            <td> ${str_writer} </td>
            <td>
               <input class="input" type="text" name="writer" maxlength="10" value="${sessionScope.memId }" readonly style="width:460;">
               
               <b>공지글선택</b><select name="noticechoice">
                  <option value="1"> 공지중요글 </option>
                  <option value="2"> 공지일반글 </option>
               
                  </select>
            </td>
            
            
            
         </tr>
      
         <tr>
            <td>${str_subject}</td>
            <td>
            <input class="input" type="text" name="subject" maxlength="50" style="width:600;">
            </td>
         </tr>
         <tr>
            <td>${str_content}</td>
            <td>
               <textarea rows="10" cols="40" name="content" style="width:600;"></textarea>
            </td>
         </tr>
         <tr>
            
      
         </tr>
         
         <tr align="center">
            <th colspan="2" style="text-align: center;">
               <input class="btn btn-success" type="submit" value="${btn_write}">
               <input class="btn btn-success" type="reset" value="${btn_cancel}">
               <input class="btn btn-success" type="button" value="${btn_list}" onclick="location='NoticeList.do'">
               
            </th>
         </tr>
         
      </table>
   </form>
</body>


<jsp:include page="../HKK_bottom.jsp" flush="false"/>
