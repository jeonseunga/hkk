<%@page import="java.util.ArrayList"%>
<%@page import="todayhkk.TodayHKKDBBean"%>
<%@page import="todayhkk.TodayHKKDataBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="TodayhkkSetting.jsp"%> 

<script src = "${project}todayHKK/todayHKK.js"></script>
<link href="${project}css/HKK_style.css" rel="stylesheet" type="text/css">


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<jsp:include page="../HKK_menu.jsp" flush="false"/>

<head>
	
  <meta charset="UTF-8">
  <title>${page_todayHKK}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
    
</head>
<body>

	<div class="index2-banner">
		<div class="index2-banner-bg"><img src="https://github.com/JessicaPotter2/foodWebsite/blob/master/images/banner.jpg?raw=true" alt="banner"/></div>
		<div class="index2-banner-text">
			<div class="text-logo"><img src = "${project}images/menuHKKI.png" width = "250"
			 height = auto style="margin-left: 34%;"></div>

		</div>
	</div>


	<div class="index-menu">
		<div class="menu-tips"><a href="#" onclick="calender();">${date}</a></div>
	</div>

	

		<br><br><br><br>
		
  <div class="comments-app">
  

  <!-- From -->
  <c:if test="${sessionScope.memId == null }">
			
  </c:if>
  <c:if test="${sessionScope.memId != null }">
  <div class="comment-form">
	    <form class="form" name="form" 
	    		method="post" action="todayHKKPro.do" enctype="multipart/form-data">
	      <table>
	      	<tr>
	      		<td class="line">
	      			<input type="file" id="image" name="image">  
	      		</td>
	      		</tr>
	      		<tr>
	      		<td> 
	      			${str_MB}
	      		</td>
	      	</tr>
	      	<tr>
	      	<td>
	      	</td>
	      	</tr>
	  
	      </table>
	      	
	      <div class="form-row">
	        <textarea class="input" style="resize:none;" name="t_content"></textarea>     
	      </div>
	
	      <div class="form-row">
	        <input type="submit" value="Add Comment" >
	       <!-- 아이디없으면 누를수 없게 유효성검사해놓기 -->
	      </div>
	    </form>

  </div>
  </c:if>
  
    <c:if test="${search_count == 0}">
    	<script type="text/javascript">
				<!--
				alert(nosearch);
				//-->
		</script>
		<meta http-equiv = "refresh" content="0; url=todayHKK.do">	
    </c:if>
    
    <c:if test="${count == 0}">
    	<script type="text/javascript">
				<!--
				alert(nocontent);
				//-->
		</script>
		<meta http-equiv = "refresh" content="10000; url=todayHKK.do">	
    </c:if>

  <!-- Comments List -->
  <div class="comments" >
    <!-- Comment -->
    <div class="comment" >
    
    
	
	<c:if test="${count != 0}">
	<c:forEach var="article" items="${articles}">
	
      <!-- Comment Box -->
       
      <div class="comment-box">
        <div class="comment-text"><img src="${path}${article.t_image_path}" border="0"><br>
        ${article.t_content}</div>

        <div class="comment-footer">
          <div class="comment-info">
            <span class="comment-author">
              <a>${article.t_id}</a>
            </span>
            <span class="comment-date">${article.t_reg_date}</span>
            <c:if test="${sessionScope.memId != null }">
            <a href="#" onclick="confirmDelete(${article.t_listnum})">${btn_delete}</a>
            </c:if>

          </div>

          <div class="comment-actions">
          </div>
        </div>
      </div>
      <br>
	</c:forEach>
     </c:if>
      		
     
    </div>
    		
    </div>
    <div align = "center">
	    <form name="searchidform" >
			<table>
				<tr>
					<th>
						<input type="text" name="id" placeholder="search ID">
					</th>
						<td>&nbsp;</td>
					<th>
						<!-- <input  type="submit" value="Search">-->
						<a href="#" onclick="searchid();" style="color:black;">${btn_search}</a>
					</th>
				</tr>
			</table>
		</form>
	</div>		
    </div>


<jsp:include page="../HKK_bottom.jsp" flush="false"/>
</body>
