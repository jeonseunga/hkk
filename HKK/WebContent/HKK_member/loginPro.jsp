
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="Joinsetting.jsp" %> <%-- 한글파일만 모아서 따로관리 --%>     

<script src="${project}HKK_member/HKK_member.js"></script> 
<h2>${page_login}</h2>


<c:if test="${result == 0}">

	<script type="text/javascript">
	<%	System.out.println("아이디없음"); %>
	<!--
		erroralert(noiderror);
	//-->
	</script>
</c:if>

<c:if test="${result == -1}">
<%	System.out.println("비밀번호다름"); %>
	<script type="text/javascript">
		<!--
			erroralert(diffpasswderror);
		//-->
	</script>
</c:if>

<c:if test="${result == 1}">
	${sessionScope.memId = id};
	<%	System.out.println("됬다"); %>

		<c:redirect url="HKK_main.do"/>
		
</c:if>