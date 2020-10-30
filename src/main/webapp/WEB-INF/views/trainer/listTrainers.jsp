<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>

	<section class="page-section bg-light" id="portfolio">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">트레이너 소개</h2>
				<h3 class="section-subheading text-muted">트레이너를 직접 선택하세요</h3>
			</div>
				<div class="row">
				<c:choose>
					<c:when test="${trainersList == null }">
						<div class="container">
							<p align="center">
								<b><span style="font-size: 9pt;">등록된 트레이너가 없습니다.</span></b>
							</p>
						</div>
					</c:when>
					<c:when test="${trainersList !=null }">
						<c:forEach var="trainer" items="${trainersList }" varStatus="trainerNum">
							<div class="col-lg-4 col-sm-6 mb-4">
								<div class="portfolio-item">
									<a class="portfolio-link" data-toggle="modal"
										href=  "#trainerModal${trainer.mgr_id}">
									<div class="portfolio-hover">
										<div class="portfolio-hover-content">
											<i class="fas fa-plus fa-3x"></i>
										</div>
									</div> <img class="img-fluid" src="/resources/img/trainer/${trainer.image_name }" alt="" />
									</a>
									<div class="portfolio-caption">
										<div class="portfolio-caption-heading">${trainer.name }</div>
										<div class="portfolio-caption-subheading text-muted">${trainer.gender }</div>
									</div>
								</div>
							</div>
							<div class="portfolio-modal modal fade" id="trainerModal${trainer.mgr_id}"
							tabindex="-1" role="dialog" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="close-modal" data-dismiss="modal">
											<img src="../resources/img/close-icon.svg" alt="Close modal" />
										</div>
										<div class="container">
											<div class="row justify-content-center">
												<div class="col-lg-8">
													<div class="modal-body">
														<h2 class="text-uppercase">${trainer.name }</h2>
														<p class="item-intro text-muted">${trainer.gender }</p>
														<img class="img-fluid d-block mx-auto"
														src="../resources/img/trainer/${trainer.image_name }" alt="" />
														<p>${trainer.intro }</p>
														<button class="btn btn-primary" data-dismiss="modal" type="button">
									 					트레이너 신청하기
														</button>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							
						</c:forEach>
					</c:when>
			</c:choose>	
		</div>	
		</div>
	</section>
	
	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Contact form JS-->
	<script src="resources/mail/jqBootstrapValidation.js"></script>
	<script src="resources/mail/contact_me.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>