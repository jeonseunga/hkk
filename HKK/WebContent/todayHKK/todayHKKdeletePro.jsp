<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script src = "/HKK/todayHKK/todayHKK.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<c:if test="${resultcheck ==0}">
	<script type="text/javascript">
			<!--
				erroralert(deleteiderror);
			//-->
			</script>
			<meta http-equiv = "refresh" content="0; url=todayHKK.do">
	</c:if>
	<c:if test="${resultcheck != 0}">
		<c:if test="${result == 0 }">
				<script type="text/javascript">
				<!--
				alert(deleteerror);
				//-->
				</script>
				<meta http-equiv = "refresh" content="0; url=todayHKK.do">
	
		</c:if>
		<c:if test="${result==1}">
			<c:redirect url="todayHKK.do"/>
		</c:if>
	</c:if>