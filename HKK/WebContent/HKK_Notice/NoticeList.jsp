<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="NOsetting.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<link href="/HKK/css/HKK_style.css" rel="stylesheet" type="text/css">
 <link rel='stylesheet prefetch' href='https://rawgit.com/JessicaPotter2/foodWebsite/master/css/reset.css'> 

 <link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">


 <jsp:include page="../HKK_menu.jsp" flush="false"/>
  <link rel="stylesheet" href="css/HKK_style.css">

<div class="index2-banner">
	<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
			<div class="text-logo"><img src="/HKK/images/notice.png" width="180" height="auto" 
			style="margin-left: 38%;"></div>
		</div>
</div>
<br><br>
<c:if test="${memcode == 3 }">

<table class="table table-striped table-bordered table-hover table-condensed" style="text-align: center; width:1000; margin:auto; border : 1px solid #dddddd " >
   <tr>
   
      <th colspan="4" style="text-align: right;">
         <a class="atag" href="NoticewriteForm.do">
       ${str_write}&nbsp;&nbsp;&nbsp;
         </a>
      </th>
   </tr>
   <tr>
      <th style="text-align: center; width:3%;"> ${str_num} </th>
      <th style="text-align: center; width:30%;"> ${str_subject} </th>
      <th style="text-align: center; width:10%;"> ${str_writer} </th><!-- session값 -->
      <th style="text-align: center; width:10%;"> ${str_reg_date}</th>
      
   </tr>
   
   
<c:if test="${count == 0 }">
     <tr>
      <td colspan="6" align="center">
         ${msg_list_x}
      </td>
     </tr>
</c:if>
<c:if test="${count != 0 }">
<c:if test="${noticechoice == null }">
   <c:forEach var="NTDto" items="${ArtiCles}">   
         <tr>         
            <td>
        		<img src="/HKK/images/notice.jpg">
   			</td>
   			<td>
            <b><a href="Noticecontent.do?pageNum=${pageNum}&num=${NTDto.n_listnum}&number=${number+1}" style="color: black;">${NTDto.n_title}</a></b>
            </td>            
            <td>${str_wr}</td>
            <td>
            <fmt:formatDate value="${NTDto.n_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
            </td>
         </tr>
</c:forEach> 
</c:if>
<c:if test="${noticechoice == null }">
<c:forEach var="noticeDto" items="${articles}">   
         <tr>
             <td>
       		 ${number}
        	 <c:set var="number" value="${number-1}"/>
        	 </td>
            <td>
            <a href="Noticecontent.do?pageNum=${pageNum}&num=${noticeDto.n_listnum}&number=${number+1}" style="color: #FF7E7E;">${noticeDto.n_title}</a>
            </td>       
            <td>${str_wr}</td>
            <td>
            <fmt:formatDate value="${noticeDto.n_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
            </td>
         </tr>
</c:forEach> 
</c:if>
<c:if test="${noticechoice != null }">
<c:forEach var="noticeDto" items="${articles}">   
         <tr>
             <td>
       		 ${number}
        	 <c:set var="number" value="${number-1}"/>
        	 </td>
            <td>
            <a href="Noticecontent.do?pageNum=${pageNum}&num=${noticeDto.n_listnum}&number=${number+1}&noticechoice=${noticechoice}&search=${search}" style="color: #FF7E7E;">${noticeDto.n_title}</a>
            </td>       
            <td>${str_wr}</td>
            <td>
            <fmt:formatDate value="${noticeDto.n_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
            </td>
         </tr>
</c:forEach> 
</c:if>
   </c:if>
   </table> 
</c:if>

<c:if test="${memcode != 3 }">
<table class="table table-striped table-bordered table-hover table-condensed" style="text-align: center; width:1000; margin:auto; border : 1px solid #dddddd " >
   <tr>
      <th style="text-align: center; width:3%;"> ${str_num} </th>
      <th style="text-align: center; width:30%;"> ${str_subject} </th>
      <th style="text-align: center; width:10%;"> ${str_writer} </th><!-- session값 -->
      <th style="text-align: center; width:10%;"> ${str_reg_date}</th>
      
   </tr>
   
   
<c:if test="${count == 0 }">
     <tr>
      <td colspan="6" align="center">
         ${msg_list_x}
      </td>
     </tr>
</c:if>
<c:if test="${count != 0 }">
<c:if test="${noticechoice == null }">
   <c:forEach var="NTDto" items="${ArtiCles}">   
         <tr>         
            <td>
        		<img src="/HKK/images/notice.jpg">
   			</td>
   			<td>
            <b><a href="Noticecontent.do?pageNum=${pageNum}&num=${NTDto.n_listnum}&number=${number+1}" style="color: black;">${NTDto.n_title}</a></b>
            </td>            
            <td>${str_wr}</td>
            <td>
            <fmt:formatDate value="${NTDto.n_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
            </td>
         </tr>
</c:forEach> 
</c:if>
<c:if test="${noticechoice == null }">
<c:forEach var="noticeDto" items="${articles}">   
         <tr>
             <td>
       		 ${number}
        	 <c:set var="number" value="${number-1}"/>
        	 </td>
            <td>
            <a href="Noticecontent.do?pageNum=${pageNum}&num=${noticeDto.n_listnum}&number=${number+1}" style="color: #FF7E7E;">${noticeDto.n_title}</a>
            </td>       
            <td>${str_wr}</td>
            <td>
            <fmt:formatDate value="${noticeDto.n_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
            </td>
         </tr>
</c:forEach> 
</c:if>
<c:if test="${noticechoice != null }">
<c:forEach var="noticeDto" items="${articles}">   
         <tr>
             <td>
       		 ${number}
        	 <c:set var="number" value="${number-1}"/>
        	 </td>
            <td>
            <a href="Noticecontent.do?pageNum=${pageNum}&num=${noticeDto.n_listnum}&number=${number+1}&noticechoice=${noticechoice}&search=${search}" style="color: #FF7E7E;">${noticeDto.n_title}</a>
            </td>       
            <td>${str_wr}</td>
            <td>
            <fmt:formatDate value="${noticeDto.n_reg_date}" type="both" pattern="yyyy-MM-dd HH:mm"/>
            </td>
         </tr>
</c:forEach> 
</c:if>
   </c:if>
</table> 
</c:if>

<br>
<div align="center">

    <form action="NoticeList.do">
      <table>
         <tr>
            <td>
            <select name="noticechoice">
            <option value="n_content"> 글제목 </option>
            </select>
            </td>
            
            <td><input class="text" name="search" ></td>
            <td> <button type="submit">검색</button></td>
         </tr>
      </table>
   </form>
</div>   
   


<c:if test="${noticechoice == null }">
<center>
   <c:if test="${count gt 0}">
        <c:if test="${startPage gt pageBlock}">
         <a class="atag" href="NoticeList.do?">[◀◀]</a> 
             <a class="atag" href="NoticeList.do?pageNum=${startPage - pageBlock}">[◀]</a> 
         </c:if>
         
               <c:forEach var="i" begin="${startPage}" end="${endPage}">
                   <c:if test="${i == currentPage}">
                     [${i}]
                  </c:if>
                 <c:if test="${i != currentPage}">
                     <a class="atag" href="NoticeList.do?pageNum=${i}">[${i}]</a>
                  </c:if>
               </c:forEach>
      
         <c:if test="${pageCount > endPage }">
                <a class="atag" href="NoticeList.do?pageNum=${startPage+pageBlock}">[▶]</a>   
               <a class="atag" href="NoticeList.do?pageNum=${pageCount}">[▶▶]</a> 
         </c:if>
     </c:if>
</center>
<br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br>

</c:if>

<c:if test="${noticechoice != null }">
	<center>
		<c:if test="${count gt 0 }">
			<c:if test="${cstartPage gt pageBlock }">
				<a class="atag" href="NoticeList.do?noticechoice=${noticechoice}&search=${search}">[◀◀]</a>
				<a class="atag" href="NoticeList.do?pageNum=${startPage-pageBlock}&noticechoice=${noticechoice}&search=${search}">[◀]</a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<c:if test="${i == currentPage }">[${i}]</c:if>
				<c:if test="${i != currentPage}"><a class="atag" href="NoticeList.do?pageNum=${i}&noticechoice=${noticechoice}&search=${search}" style="color:black;">[${i}]</a></c:if>
			</c:forEach>
			<c:if test="${pageCount > endPage}">
				<a class="atag" href="NoticeList.do?pageNum=${startPage+pageBlock}&noticechoice=${noticechoice}&search=${search}">[▶]</a>
				<a class="atag" href="NoticeList.do?pageNum=${pageCount}&noticechoice=${noticechoice}&search=${search}">[▶▶]</a>
			</c:if>
		</c:if>
		<br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br>

	</center>
</c:if>



<jsp:include page="../HKK_bottom.jsp" flush="false"/>
