<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>

<div class="contaniner" width="80%">
<h1 align="center">운동영상 테스트페이지</h1>
<table class="table table-striped" align="center" border="1" width="80%">
	<tr height="10" align="center">
		<td>영상번호</td>
		<td>분류</td>
		<td>제목</td>
		<td>영상</td>
	</tr>
	<c:choose>
		<c:when test="${ moviesList == null }">
			<tr height="10">
				<td colspan="4">
					<p align="center">
						<b><span style="font-size: 9pt;">등록된 영상이 없습니다.</span></b>
					</p>
				</td>
			</tr>
		</c:when>
		<c:when test="${ moviesList != null }">
			<c:forEach var="movie" items="${moviesList}">
				<tr align="center">
					<td width="3%">${movie.movie_idx}</td>
					<td width="3%">${movie.category_exr}</td>
					<td align='left' width="35%"><span style="padding-right: 30px"></span>
						<a class='cls1'
						href="${contextPath}/exercise/viewmovie.do?movie_idx=${movie.movie_idx}">${movie.title}</a></td>
					<td><iframe width="300" height="150" src=${movie.youtube} frameborder="0" allowfullscreen=""></iframe><td>
				</tr>
			</c:forEach>
		</c:when>
	</c:choose>
</table>
</div>
<script>
	function fn_movieForm(isLogOn,movieForm,loginForm){
	  if(isLogOn != '' && isLogOn != 'false'){
	    location.href=movieForm;
	  }else{
	    alert("로그인 후 글쓰기가 가능합니다.")
	    location.href=loginForm+'?action=/exercise/movieForm.do';
	  }
	}
</script>