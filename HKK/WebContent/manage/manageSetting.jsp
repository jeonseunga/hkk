<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<c:set var="project" value="/HKK/"/>
<c:set var="imgpath" value="/HKK/upload/"/>

<c:set var="str_id" value="아이디"/>
<c:set var="str_pw" value="비밀번호"/>
<c:set var="str_email" value="이메일"/>
<c:set var="str_gender" value="성별"/>
<c:set var="str_grantlevel" value="권한등급"/>
<c:set var="str_drop" value="탈퇴"/>
<c:set var="str_grantupdate" value="권한부여"/>
<c:set var="str_member" value="회원정보"/>

<c:set var="btn_drop" value="탈퇴"/>
<c:set var="btn_grantupdate" value="권한부여"/>
<c:set var="btn_memberdrop" value="회원탈퇴"/>
<c:set var="btn_modify" value="정보수정"/>
<c:set var="btn_search" value="검색"/>
<c:set var="btn_ok" value="확인"/>
<c:set var="btn_cancle" value="취소"/>

<c:set var="msg_search" value="검색할 아이디"/>
<c:set var="msg_delete" value="님을 삭제하시겠습니까?"/>
<c:set var="msg_grant" value="권한을 설정해 주세요"/>
<c:set var="msg_noid" value="검색하신 아이디는 존재하지 않습니다"/>