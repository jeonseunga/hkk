
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="/HKK/HKK_member/HKK_member.js"></script>  

<h2> ${page_input}></h2>

<c:if test="${result == 0}">

	<script type="text/javascript">
		<!--
			erroralert(inputerror);
		//-->
	</script>
</c:if>
<c:if test="${result == 1 }">	

 	${sessionScope.memId = id};
  <c:redirect url="HKK_main.do"/>

</c:if>