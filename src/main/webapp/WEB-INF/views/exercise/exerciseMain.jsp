<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<body>
	<!-- Portfolio Grid-->
	<section class="page-section bg-light" id="portfolio">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">운동가이드영상</h2>
				<h3 class="section-subheading text-muted">집에서 따라해보세요.</h3>
			</div>
			<div class="row">
				<div class="col-lg-4 col-sm-6 mb-4">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal1">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/chest.jpeg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">가슴운동</div>
							<div class="portfolio-caption-subheading text-muted">Chest</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal2">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/back.jpg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">등운동</div>
							<div class="portfolio-caption-subheading text-muted">
								Back</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal3">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/arm.jpeg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">팔운동</div>
							<div class="portfolio-caption-subheading text-muted">Arm</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4 mb-lg-0">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal4">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/shoulder.jpeg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">어께운동</div>
							<div class="portfolio-caption-subheading text-muted">Shoulder</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4 mb-sm-0">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal5">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/leg.jpeg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">하체운동</div>
							<div class="portfolio-caption-subheading text-muted">Leg & Hip</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal6">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/running.jpeg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">유산소운동</div>
							<div class="portfolio-caption-subheading text-muted">Burning Calorie</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Clients-->
	<div class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6 my-3">
					<a href="#!"><img class="img-fluid d-block mx-auto"
						src="/resources/img/logos/envato.jpg" alt="" /></a>
				</div>
				<div class="col-md-3 col-sm-6 my-3">
					<a href="#!"><img class="img-fluid d-block mx-auto"
						src="/resources/img/logos/designmodo.jpg" alt="" /></a>
				</div>
				<div class="col-md-3 col-sm-6 my-3">
					<a href="#!"><img class="img-fluid d-block mx-auto"
						src="/resources/img/logos/themeforest.jpg" alt="" /></a>
				</div>
				<div class="col-md-3 col-sm-6 my-3">
					<a href="#!"><img class="img-fluid d-block mx-auto"
						src="/resources/img/logos/creative-market.jpg" alt="" /></a>
				</div>
			</div>
		</div>
	</div>
	<!-- Portfolio Modals-->
	<!-- Modal 1-->
	<div class="portfolio-modal modal fade" id="portfolioModal1"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/resources/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">가슴운동</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<section class="videogrid">	
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
								</section>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 2-->
	<div class="portfolio-modal modal fade" id="portfolioModal2"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/resources/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<section class="page-section bg-light" id="portfolio">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">운동가이드영상</h2>
				<h3 class="section-subheading text-muted">집에서 따라해보세요.</h3>
			</div>
			<div class="row">
				<div class="col-lg-4 col-sm-6 mb-4">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal1">
							<img class="img-fluid"
							src="/resources/img/exr/chest.jpeg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">가슴운동</div>
							<div class="portfolio-caption-subheading text-muted">Chest</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal2">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/back.jpg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">등운동</div>
							<div class="portfolio-caption-subheading text-muted">
								Back</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal3">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/arm.jpeg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">팔운동</div>
							<div class="portfolio-caption-subheading text-muted">Arm</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4 mb-lg-0">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal4">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/shoulder.jpeg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">어께운동</div>
							<div class="portfolio-caption-subheading text-muted">Shoulder</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 mb-4 mb-sm-0">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal5">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/leg.jpeg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">하체운동</div>
							<div class="portfolio-caption-subheading text-muted">Leg & Hip</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#portfolioModal6">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/exr/running.jpeg" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">유산소운동</div>
							<div class="portfolio-caption-subheading text-muted">Burning Calorie</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 3-->
	<div class="portfolio-modal modal fade" id="portfolioModal3"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/resources/img/close-icon.svg" alt="Close modal" />
				</div>
				<section class="page-section bg-light" id="portfolio">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">운동가이드영상</h2>
				<h3 class="section-subheading text-muted">집에서 따라해보세요.</h3>
			</div>
			<div class="row">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<div class="col-lg-4 col-sm-6">
					<div class="portfolio-item">
						 <iframe src="http://youtube.com/embed/RjexvOAsVtI"></iframe>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">유산소운동</div>
					</div>
				</div>
							</div>
							<div class="col-lg-4 col-sm-6 mb-4">
					<div class="portfolio-item">
						 <iframe src="http://youtube.com/embed/RjexvOAsVtI"></iframe>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">유산소운동</div>
					</div>
				</div>
							</div>
							<div class="col-lg-4 col-sm-6">
					<div class="portfolio-item">
						 <iframe src="http://youtube.com/embed/RjexvOAsVtI"></iframe>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">유산소운동</div>
					</div>
				</div>
							</div>
							<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i> Close Project
								</button>
						</div>
					</div>
				</div>
				</section>
			</div>
		</div>
	</div>
	<!-- Modal 4-->
	<div class="portfolio-modal modal fade" id="portfolioModal4"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/resources/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/resources/img/portfolio/04-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Lines</li>
									<li>Category: Branding</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 5-->
	<div class="portfolio-modal modal fade" id="portfolioModal5"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/resources/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/resources/img/portfolio/05-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Southwest</li>
									<li>Category: Website Design</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 6-->
	<div class="portfolio-modal modal fade" id="portfolioModal6"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="/resources/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">Project Name</h2>
								<p class="item-intro text-muted">Lorem ipsum dolor sit amet
									consectetur.</p>
								<img class="img-fluid d-block mx-auto"
									src="/resources/img/portfolio/06-full.jpg" alt="" />
								<p>Use this area to describe your project. Lorem ipsum dolor
									sit amet, consectetur adipisicing elit. Est blanditiis dolorem
									culpa incidunt minus dignissimos deserunt repellat aperiam
									quasi sunt officia expedita beatae cupiditate, maiores
									repudiandae, nostrum, reiciendis facere nemo!</p>
								<ul class="list-inline">
									<li>Date: January 2020</li>
									<li>Client: Window</li>
									<li>Category: Photography</li>
								</ul>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									<i class="fas fa-times mr-1"></i> Close Project
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<!-- Contact form JS-->
	<script src="/resources/mail/jqBootstrapValidation.js"></script>
	<script src="/resources/mail/contact_me.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>