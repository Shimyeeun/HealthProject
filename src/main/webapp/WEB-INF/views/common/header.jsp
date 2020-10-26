<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<header>

	<table class="header-table" width="90%"
		style="margin-left: auto; margin-right: auto;">
		 <thead>
		<tr>
			<td width="5%"><a href="${contextPath}/main.do"> <img
					src="${contextPath}/resources/img/logo.png" width="100"
					height="100" />
			</a></td>
			<td width="35%"><a href="${contextPath}/main.do"
				style="text-decoration: none;"><h4>방구석 헬스왕</h4></a></td>
			<td width="35%"">
				<!-- Navigation-->
				<nav>
					<ul class="navbar-nav text-uppercase ml-auto">
						<li class="nav-item"><a class="nav-link js-scroll-trigger"
							href="#services">Services</a></li>
						<li class="nav-item"><a class="nav-link js-scroll-trigger"
							href="#portfolio">Portfolio</a></li>
						<li class="nav-item"><a class="nav-link js-scroll-trigger"
							href="#about">About</a></li>
						<li class="nav-item"><a class="nav-link js-scroll-trigger"
							href="/board/listArticles.do">COMMUNITY</a></li>
						<li class="nav-item"><a class="nav-link js-scroll-trigger"
							href="#contact">Contact</a></li>
					</ul>
				</nav>
			</td>
			<td width="5%">
				<!-- <a href="#"><h3>로그인</h3></a> --> <c:choose>
					<c:when test="${isLogOn == true  && member!= null}">
						<button class="btn" type="button" onclick="location.href='${contextPath}/member/logout.do'">로그아웃</button>
					</c:when>
					<c:otherwise>
						<button class="btn" type="button" onclick="location.href='${contextPath}/member/loginForm.do'">로그인</button>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
		</thead>
	</table>

</header>