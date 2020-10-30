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

</head>
<body>
<form name="frmLogin" method="post"
	action="${contextPath}/trainer/addTrainer.do">
	<table align="center">
	   <tr>
	      <td width="200"><p align="right">아이디</td>
	      <td width="400"><input type="text" name="mgr_id"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">비밀번호</td>
	      <td width="400"><input type="password" name="mgr_pw"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이름</td>
	       <td width="400"><p><input type="text" name="name"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">주소</td>
	       <td width="400"><p><input type="text" name="address"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이미지</td>
	       <td width="400"><p><input type="file" name="image_name"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">성별</td>
	       <td width="400"><p><input type="text" name="gender"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">자기소개</td>
	       <td width="400"><p><textarea name="intro" id="intro" cols="40" rows="10"></textarea></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="가입하기"><input type="reset" value="다시입력"></td>
	    </tr>
	</table>
	
	
</form>
</body>
</html>