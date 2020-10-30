<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%>-->
<!DOCTYPE html>
<body>
	<!-- main poster -->
	<section class="masthead">
	 <div class="container">
	     <div class="section-subheading">Welcome To Our Gym!</div>
	     <div class="section-heading text-uppercase">It's Nice To Meet You</div>
	     <a class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" href="#services">Tell Me More</a>
     </div>
	</section>
	<!-- Services-->
	<section class="page-section" id="services">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">Services</h2>
				<h3 class="section-subheading text-muted">모두 방구석 헬스왕이 되어봅시다!</h3>
			</div>
			<div class="row text-center">
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fas fa-circle fa-stack-2x text-primary"></i> <i
						class="fas fa-dumbbell fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="my-3">방구석 트레이닝</h4>
					<p class="text-muted">헬스장에 가지 않고도 집에서 간편하게 운동할 수 있도록 도와드려요. 다양한 운동방법 영상과 커뮤니티를 통해 유익한 정보를 얻어가세요.</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fas fa-circle fa-stack-2x text-primary"></i> <i
						class="fas fa-comments fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="my-3">맞춤 트레이닝</h4>
					<p class="text-muted">트레이너를 직접 골라 신청할 수 있어요. 1대1 맞춤 관리를 통해 체계적으로 집에서도 PT받는 효과를 얻을 수 있어요.</p>
				</div>
				<div class="col-md-4">
					<span class="fa-stack fa-4x"> <i
						class="fas fa-circle fa-stack-2x text-primary"></i> <i
						class="fas fa-won-sign fa-stack-1x fa-inverse"></i>
					</span>
					<h4 class="my-3">리워드</h4>
					<p class="text-muted">포인트를 충전하고 챌린지에 도전하세요. 챌린지에 성공하면 리워드를 받아갈 수 있어요. 실패한 챌린저의 포인트를 성공한 챌린저들끼리 나눠가져요.  </p>
				</div>
			</div>
		</div>
	</section>
 	<!-- portfolio -->
	<section class="page-section bg-light" id="portfolio">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">TRAINERS</h2>
				<h3 class="section-subheading text-muted">트레이너를 직접 선택하세요</h3>
			</div>
			<div class="row">
				 <div class="col-lg-4 col-sm-6 mb-4">
					<div class="portfolio-item">
						<a class="portfolio-link" data-toggle="modal"
							href="#trainerModal1">
							<div class="portfolio-hover">
								<div class="portfolio-hover-content">
									<i class="fas fa-plus fa-3x"></i>
								</div>
							</div> <img class="img-fluid"
							src="/resources/img/trainer/윤민서.png" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">윤민서</div>
							<div class="portfolio-caption-subheading text-muted">남</div>
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
							src="/resources/img/trainer/김건강.png" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">김건강</div>
							<div class="portfolio-caption-subheading text-muted">남</div>
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
							src="/resources/img/trainer/이요가.png" alt="" />
						</a>
						<div class="portfolio-caption">
							<div class="portfolio-caption-heading">이요가</div>
							<div class="portfolio-caption-subheading text-muted">여</div>
						</div>
					</div>
				</div>
				<div style="text-align:right; width:100%; padding:0;">
    				<button class="btn" type="button"  onclick="location.href='/trainer/listTrainers.do'">더보기</button>
				</div>
			</div>
		</div>
	</section>
	<!-- About
	<section class="page-section" id="about">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">About</h2>
				<h3 class="section-subheading text-muted">Lorem ipsum dolor sit
					amet consectetur.</h3>
			</div>
			<ul class="timeline">
				<li>
					<div class="timeline-image">
						<img class="rounded-circle img-fluid"
							src="resources/img/about/1.jpg" alt="" />
					</div>
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4>2009-2011</h4>
							<h4 class="subheading">Our Humble Beginnings</h4>
						</div>
						<div class="timeline-body">
							<p class="text-muted">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sunt ut voluptatum eius sapiente, totam
								reiciendis temporibus qui quibusdam, recusandae sit vero unde,
								sed, incidunt et ea quo dolore laudantium consectetur!</p>
						</div>
					</div>
				</li>
				<li class="timeline-inverted">
					<div class="timeline-image">
						<img class="rounded-circle img-fluid"
							src="resources/img/about/2.jpg" alt="" />
					</div>
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4>March 2011</h4>
							<h4 class="subheading">An Agency is Born</h4>
						</div>
						<div class="timeline-body">
							<p class="text-muted">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sunt ut voluptatum eius sapiente, totam
								reiciendis temporibus qui quibusdam, recusandae sit vero unde,
								sed, incidunt et ea quo dolore laudantium consectetur!</p>
						</div>
					</div>
				</li>
				<li>
					<div class="timeline-image">
						<img class="rounded-circle img-fluid"
							src="resources/img/about/3.jpg" alt="" />
					</div>
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4>December 2012</h4>
							<h4 class="subheading">Transition to Full Service</h4>
						</div>
						<div class="timeline-body">
							<p class="text-muted">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sunt ut voluptatum eius sapiente, totam
								reiciendis temporibus qui quibusdam, recusandae sit vero unde,
								sed, incidunt et ea quo dolore laudantium consectetur!</p>
						</div>
					</div>
				</li>
				<li class="timeline-inverted">
					<div class="timeline-image">
						<img class="rounded-circle img-fluid"
							src="resources/img/about/4.jpg" alt="" />
					</div>
					<div class="timeline-panel">
						<div class="timeline-heading">
							<h4>July 2014</h4>
							<h4 class="subheading">Phase Two Expansion</h4>
						</div>
						<div class="timeline-body">
							<p class="text-muted">Lorem ipsum dolor sit amet, consectetur
								adipisicing elit. Sunt ut voluptatum eius sapiente, totam
								reiciendis temporibus qui quibusdam, recusandae sit vero unde,
								sed, incidunt et ea quo dolore laudantium consectetur!</p>
						</div>
					</div>
				</li>
				<li class="timeline-inverted">
					<div class="timeline-image">
						<h4>
							Be Part <br /> Of Our <br /> Story!
						</h4>
					</div>
				</li>
			</ul>
		</div>
	</section>-->
	
	<!-- Clients-->
	<!--  
	<div class="py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6 my-3">
					<a href="#!"><img class="img-fluid d-block mx-auto"
						src="resources/img/logos/envato.jpg" alt="" /></a>
				</div>
				<div class="col-md-3 col-sm-6 my-3">
					<a href="#!"><img class="img-fluid d-block mx-auto"
						src="resources/img/logos/designmodo.jpg" alt="" /></a>
				</div>
				<div class="col-md-3 col-sm-6 my-3">
					<a href="#!"><img class="img-fluid d-block mx-auto"
						src="resources/img/logos/themeforest.jpg" alt="" /></a>
				</div>
				<div class="col-md-3 col-sm-6 my-3">
					<a href="#!"><img class="img-fluid d-block mx-auto"
						src="resources/img/logos/creative-market.jpg" alt="" /></a>
				</div>
			</div>
		</div>
	</div>-->
	<!-- Contact-->
	<section class="page-section" id="contact">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">Contact Us</h2>
				<h3 class="section-subheading text-muted">Lorem ipsum dolor sit
					amet consectetur.</h3>
			</div>
			<form id="contactForm" name="sentMessage" novalidate="novalidate">
				<div class="row align-items-stretch mb-5">
					<div class="col-md-6">
						<div class="form-group">
							<input class="form-control" id="name" type="text"
								placeholder="Your Name *" required="required"
								data-validation-required-message="Please enter your name." />
							<p class="help-block text-danger"></p>
						</div>
						<div class="form-group">
							<input class="form-control" id="email" type="email"
								placeholder="Your Email *" required="required"
								data-validation-required-message="Please enter your email address." />
							<p class="help-block text-danger"></p>
						</div>
						<div class="form-group mb-md-0">
							<input class="form-control" id="phone" type="tel"
								placeholder="Your Phone *" required="required"
								data-validation-required-message="Please enter your phone number." />
							<p class="help-block text-danger"></p>
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group form-group-textarea mb-md-0">
							<textarea class="form-control" id="message"
								placeholder="Your Message *" required="required"
								data-validation-required-message="Please enter a message."></textarea>
							<p class="help-block text-danger"></p>
						</div>
					</div>
				</div>
				<div class="text-center">
					<div id="success"></div>
					<button class="btn btn-primary btn-xl text-uppercase"
						id="sendMessageButton" type="submit">Send Message</button>
				</div>
			</form>
		</div>
	</section>

	<!-- Portfolio Modals-->
	<!-- Modal 1-->
	<div class="portfolio-modal modal fade" id="trainerModal1"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="resources/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">윤민서</h2>
								<p class="item-intro text-muted">남</p>
								<img class="img-fluid d-block mx-auto"
									src="resources/img/trainer/윤민서.png" alt="" />
								<p>안녕하세요. 제 2회 전국 보디딜더 대회에서 금상을 수상한 윤민서입니다. 저한테 오세요!!!</p>
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									 트레이너 신청하기
								</button>
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
					<img src="resources/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">김건강</h2>
								<p class="item-intro text-muted">남</p>
								<img class="img-fluid d-block mx-auto"
									src="resources/img/trainer/김건강.png" alt="" />
								<p>안녕하세요. 건강을 위해 저 김건강과 함께해요:)</p>
								
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									 트레이너 신청하기
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
					<img src="resources/img/close-icon.svg" alt="Close modal" />
				</div>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-8">
							<div class="modal-body">
								<!-- Project Details Go Here-->
								<h2 class="text-uppercase">이요가</h2>
								<p class="item-intro text-muted">여</p>
								<img class="img-fluid d-block mx-auto"
									src="resources/img/trainer/이요가.png" alt="" />
								<p>안녕하세요. 매일매일 같이 요가해요!</p>
								
								<button class="btn btn-primary" data-dismiss="modal"
									type="button">
									트레이너 신청하기
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal 4-->
	<div class="portfolio-modal modal fade" id="portfolioModal4"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="close-modal" data-dismiss="modal">
					<img src="resources/img/close-icon.svg" alt="Close modal" />
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
									src="resources/img/portfolio/04-full.jpg" alt="" />
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
					<img src="resources/img/close-icon.svg" alt="Close modal" />
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
									src="resources/img/portfolio/05-full.jpg" alt="" />
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
					<img src="resources/img/close-icon.svg" alt="Close modal" />
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
									src="resources/img/portfolio/06-full.jpg" alt="" />
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
	<script src="resources/mail/jqBootstrapValidation.js"></script>
	<script src="resources/mail/contact_me.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
</body>