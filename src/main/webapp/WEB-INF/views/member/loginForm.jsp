<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
   request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<body>
<div class="wrap">
<c:choose>
	<c:when test="${result=='loginFailed' }">
		<script>
	    window.onload=function(){
	      alert("아이디나 비밀번호가 틀립니다.다시 로그인 하세요!");
	    }
	  </script>
	</c:when>
</c:choose>

<div id ="content">
 
 <h1 id= "login_title">LOGIN</h1>
  
  <form name="frmLogin" method="post" action="${contextPath}/member/login.do">
	 <div id="login_member">
	     <h3>MEMBER</h3>
		<div id="input">
			<input aria-invalid="false" class="id_class" placeholder="아이디" type="text" name="mem_id" value="" title="id_title">
		</div>
		<div id="input">
			<input aria-invalid="false" class="pw_class" placeholder="비밀번호" type="password" name="mem_pwd" value="" title="pw_title">
		</div>
		<input id="member_submit" type="submit" value="멤버" style="background-color: black; color: white;">
	</div>
   </form>
  <form name="frmLogin" method="post" action="${contextPath}/trainer/login.do">
	<div id="login_trainer">
	     <h3>TRAINER</h3>
		<div id="input">
			<input aria-invalid="false" class="id_class" placeholder="아이디" type="text" name="mgr_id" value="" title="id_title">
		</div>
		<div id="input">
			<input aria-invalid="false" class="pw_class" placeholder="비밀번호" type="password" name="mgr_pw" value="" title="pw_title">
		</div>
		<input id="trainer_submit" type="submit" value="트레이너" style="background-color: black; color: white;">
	</div>	    
  </form>
 </div>
 
<div id ="find_account" style="">
		<a id="find_id" href="">아이디찾기 | 비밀번호 초기화</a>
		<br>홈페이지에 가입하지 않으셨나요?
		<a id="register" href="${contextPath}/member/memberForm.do">회원가입</a>
</div>
 

</body>
</html>