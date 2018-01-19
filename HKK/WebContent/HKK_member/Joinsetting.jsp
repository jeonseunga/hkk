<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	
	<fmt:requestEncoding value="utf-8"/>


	<c:set var="project"  value="/HKK/"/>
	<c:set var="msg_main"  value="비회원이시면 회원가입을 해주세요"/>
	<c:set var="msg_input"  value="회원정보를 입력하세요"/>
	<c:set var="msg_id_x"  value="는 사용할 수 없습니다"/>
	<c:set var="msg_id_o"  value="는 사용할 수 있습니다"/>
	<c:set var="msg_login"  value="회원가입에 성공했습니다. 로그인 해주세요"/>
	<c:set var="msg_main_login"  value="님 환영합니다"/>
	<c:set var="msg_pw" value="비밀번호를 다시 확인 해 주세요"/>
	<c:set var="msg_modify" value="수정할 정보를 입력하세요"/>

	<c:set var="page_main" value="메인 페이지"/>
	<c:set var="page_input" value="회원가입"/>
	<c:set var="page_confirm" value="중복확인"/>
	<c:set var="page_login" value="로그인"/>
	<c:set var="page_delete" value="회원탈퇴"/>
	<c:set var="page_modify" value="회원 정보 수정"/>

	<c:set var="str_id" value="id"/>
	<c:set var="str_pw" value="password"/>
	<c:set var="str_rpw" value="Check Password"/>
	<c:set var="str_gender_men" value="Men"/>
	<c:set var="str_gender_woman" value="Women"/>
	<c:set var="str_email_cancel" value="이메일 전송 실패"/>
	<c:set var="str_email_success" value="전송 완료"/>
	<c:set var="str_welcome" value="Welcome"/>
	<c:set var="str_email_auth" value="이메일 인증"/>

	<c:set var="btn_login" value="Check ID"/>
	<c:set var="btn_login_login" value="Login"/>
	<c:set var="btn_input" value="Join"/>
	<c:set var="btn_email_check" value="Check Email"/>
	<c:set var="btn_confirm" value="Check id"/>
	<c:set var="btn_ok" value="확인"/>
    <c:set var="btn_ok_cancel" value="취소"/>
	
	
	
	
