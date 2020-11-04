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
			<c:choose>
					<c:when test="${maintrainersList == null }">
						<div class="container">
							<p align="center">
								<b><span style="font-size: 9pt;">등록된 트레이너가 없습니다.</span></b>
							</p>
						</div>
					</c:when>
					<c:when test="${maintrainersList !=null }">
						<c:forEach var="trainer" items="${maintrainersList }" begin="1" end="3">
							<div class="col-lg-4 col-sm-6 mb-4">
								<div class="portfolio-item">
									<a class="portfolio-link" data-toggle="modal"
										href=  "#trainerModal${trainer.mgr_id}">
									<div class="portfolio-hover">
										<div class="portfolio-hover-content">
											<i class="fas fa-plus fa-3x"></i>
										</div>
									</div> <img class="img-fluid" src="${trainer.trainer_img }" alt="" />
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
														src="${trainer.trainer_img }" alt="" />
														<p>${trainer.intro }</p>
														
														<button class="btn btn-primary" data-dismiss="modal" type="button" onclick="javascript:loginCheck('${isLogOn}','${trainer.mgr_id}','${member.mgr_id}')">
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
			<div style="text-align:right; width:100%; padding:0;">
    				<button class="btn" type="button"  onclick="location.href='/trainer/listTrainers.do'">더보기</button>
			</div>
			
			
				
	</section> 
	
	<!-- Contact-->
	<section class="page-section" id="contact">
		<div class="container">
			<div class="text-center">
				<h2 class="section-heading text-uppercase">Contact Us</h2>
				<h3 class="section-subheading text-muted">불편하신 사항이 있으면 저희에게 알려주세요</h3>
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


	
	
	<script>
function loginCheck(isLogOn,mgr_id,mgr_check){
	
		console.log(isLogOn);
		if(isLogOn=="true"){
			applyTrainer(mgr_id,mgr_check);
		}
		
		else{
			alert("로그인 후 이용가능합니다.");
		}
		
	}
	
	function applyTrainer(mgr_id,mgr_check){
		var mem_id="<c:out value="${member.mem_id}"/>";
		
		console.log(mem_id);
		console.log(mgr_check);
		if(mgr_check==""){
			if(confirm("트레이너를 신청하시겠습니까?")){
				
				location.href="main/updateMainTrainer.do?mgr_id="+mgr_id+"&mem_id="+mem_id;
				alert("트레이너 신청이 완료되었습니다.");
				return true;
			} 
			else
				return false;
				
		}
		else{
			alert("이미 트레이너가 있습니다.");
			
		}
	}
	</script>
	
	
	
	
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