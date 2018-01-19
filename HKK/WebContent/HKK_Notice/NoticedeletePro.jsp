<%@page import="notice.NoticeDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="NOsetting.jsp"%>

<link href="style.css" rel="stylesheet" type="text/css">


<script src="TodayHkki/notice/script.js"></script>

 
   
<h2>${page_delete }</h2>


<c:if test="${deletecheck == 1 }">
<script type="text/javascript">
		<!--
		alert( deleteerror2 );
		//-->
	</script>
</c:if>


<c:if test="${resultCheck == 0}">
	<script type="text/javascript">
		<!--
		erroralert( repasswderror );
		//-->
	</script>
</c:if>
	
<c:if test="${resultCheck == 1 }">
</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			<!--
				alert(deleteerror);
			//-->
		</script>
		<meta http-equiv="refresh" content="0; url=list.do?pageNum=${pageNum}">
	</c:if>

<c:if test="${result == -1 }">
	
			<script type="text/javascript">
				<!--
					alert(replyerror);
				//-->
			</script>
			<meta http-equiv="refresh" content="0; url=list.do?pageNum=${pageNum}">
</c:if>
<c:if test="${result == 1 }">

	<c:redirect url="NoticeList.do?pageNum=${pageNum}"/>

</c:if>
