<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
   .text_center{
     text-align:center;
   }
   .join_wrap{
     border: 4px solid #e6e7e8;
     border-radius: 10px;
     padding: 40px;
   }
   ul{
     margin: 0;
    padding: 0;
    border: none;
    resize: none;
    list-style: none;
    box-sizing: border-box;
    border-spacing: 0;
    border-collapse: collapse;
    text-align: center;
   }
   li{
    display: inline-block;
    margin: auto 20px;
   }
   .join_wrap .joinList:before{
   	 content:" ";
   	 display: table;
   }
   .join_wrap .joinList li:first-child{
   		border-top: none;
    	padding-top: 0;
    	background-position: right bottom 40px;
   }
</style>
</head>
<body>
	
	<h1 class="text_center">회원 가입</h1>
	<div class="join_wrap">
		<ul class="joinList">
			
			<li class="member_register">
				<dl>
					<dt>멤버 회원가입</dt>
				</dl>
				<button class="btn" type="button" onclick="location.href='${contextPath}/member/Mem_memberForm.do'">멤버회원가입</button>
			</li>
			<li class="trainner_register">
				<dl>
					<dt>트레이너 회원가입</dt>
				</dl>
				<button class="btn" type="button" onclick="location.href='${contextPath}/trainer/Train_memberForm.do'">트레이너회원가입</button>
			</li>
			
		</ul>
	</div>
	
</body>
