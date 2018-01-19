<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="TodayhkkSetting.jsp"%> 

<link href="/HKK/css/HKK_style.css" rel="stylesheet" type="text/css">

	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
	<script type="text/javascript" src="/HKK/todayHKK/jquery.ui.datepicker-ko.js"></script>
	<script type="text/javascript" src="/HKK/todayHKK/calendar2.js"></script>
	<script src = "/HKK/todayHKK/todayHKK.js"></script>

<html>
<br>
<br>
<br>
<br>
<br>
<br>
<div align = "center">
<h2>${page_date}</h2>
<br>
<form name="selectDateform" onsubmit="return selectdate()">
	<input class="textbox1"type="text" name="t_date" id="txtDate" readonly> <br> <br> 
	<input class ="button1" type="submit" value="SELECT">
</form>
</div>	
</html>