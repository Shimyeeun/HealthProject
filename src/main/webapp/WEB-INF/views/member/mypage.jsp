<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
	
%>
<%! int totalDate=0;
	int percent=0;
%>
<body>
<!-- Challenge State -->
<h1 style="text-align: center; padding-top: 50px; padding-bottom:30px">Challenging List</h1>
	<div class="progress_area" style="display: flex; width:70%; margin:0 auto">
		<div>
		</div>
		<div class="container" style=" box-sizing:border-box">
			<c:choose>
				<c:when test="${fn:length(challList)<=0}">
					<h4 style="text-align:center; padding-top:20px">도전중인 챌린지가 없습니다. 챌린지에 도전하세요!</h4>
				</c:when>
				<c:when test="${fn:length(challList)>0}">
					<c:forEach var="challenge" items="${challList }">
						
						<div class="container" style="overflow:visible; margin-bottom:20px; padding:10px">
							<div class="progress_state" style="padding:10px">
								<h4 style="display:inline"> ${challenge.title } </h4>
								<p class="text-muted" style="margin-left:auto;display:inline">  신청금액 : ${challenge.target_point }원  &nbsp; 시작일 : ${challenge.start_date } &nbsp; 마감일 : ${challenge.end_date } 
							</div>
							
							<script>
						
							
								var totalDay;
								var ingDay;
								var percent;
								var idx;
								dateCal('${challenge.start_date}','${challenge.end_date}','${challenge.chal_idx}');
								function dateCal(start_date,end_date,chal_idx){
									var today = new Date(); 					
									var startdateArray = start_date.split('-');  
									var enddateArray = end_date.split('-');  
									var startdateObj = new Date(startdateArray[0], Number(startdateArray[1])-1, startdateArray[2]);  
									var enddateObj = new Date(enddateArray[0], Number(enddateArray[1])-1, enddateArray[2]);
									
									totalDay=(enddateObj.getTime()-startdateObj.getTime())/1000/60/60/24;
									ingDay = (today.getTime() -startdateObj.getTime())/1000/60/60/24;  
									percent=Math.ceil(Math.ceil(ingDay)/totalDay*100);  
									idx=chal_idx;
								}
								console.log(totalDay);
								
								console.log(ingDay);
								console.log(percent);
								console.log(idx);
								       
							</script>
							<script>	    
								$(function() {
									$("#progressbar"+idx).css({
									    width:percent+'%'						           
									});
								});
							
							</script>
							
							
							
							
						
							<div style="text-align:right; width:100%; padding:0.5rem;">
					
								<div class="progress" style="margin-left:auto; text-align:right; width:100%; padding:0; height:2rem" >
									<div id="progressbar${challenge.chal_idx}" class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow=""
									aria-valuemin="0" aria-valuemax="100" style="color:#000000">
									도전한지 <script>document.write(Math.ceil(ingDay))</script>일째 
									</div>
								</div>
						
							</div>
				
						</div>
					</c:forEach>
				</c:when>
			</c:choose>
		</div>
		
	</div>






<!--Calendar -->
	<div class="calendar_area">
		<div style="padding-top: 50px">
			<h1 style="text-align: center">Monthly Exercise</h1>
		</div>
		<div style="text-align: center; margin:0 auto; padding-bottom:50px">
			<img alt="calendar" src="${pageContext.request.contextPath}/resources/img/calendar.png" style="width:35%; height:900px">
		</div>
	</div>

	<div class="inbody_area">
		<div>
			<h1 style="text-align: center">Check My Inbody</h1>
		</div>
		<div class="graph_area">
			<div class="choice_date">
				<div class="input-group"
					style="width: 60%; margin: 0 auto; padding-top: 30px">
					<input type="text" id="datepicker1" class="col text-center p-1"
						placeholder="Start date" style="height: 40px;"> ~ <input
						type="text" id="datepicker2" class="col text-center p-1"
						placeholder="End date" style="height: 40px;">
					<button type="button" id="submit">　CHECK</button>
				</div>
			</div>

			<div class="view_graph"
				style="width: 65%; margin: 0 auto; padding-top: 50px">
				<canvas class="line_graph" id="myLineChart2"></canvas>
			</div>
		</div>


		<!--<canvas width="400" height="400" id="myLineChart"></canvas> -->

		<div>
			<form style="text-align: right; width: 80%;">
				<label>몸무게(Kg): <input id="weight" value="" type="text"
					name="weight" placeholder="몸무게를 입력해주세요."></label><br> <label>근육량(%):
					<input id="muscle" value="" type="text" name="muscle"
					placeholder="근육량을 입력해주세요.">
				</label><br> <label>체지방량(%): <input id="body_fat" value=""
					type="text" name="body_fat" placeholder="체지방량을 입력해주세요."><br></label><br>
				<input id="inbody_submit" type="submit" value="입력"
					style="background-color: black; color: white;">
			</form>
		</div>
	</div>


	<!--      달력 생성 코드 -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>

	<!--   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">-->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.bundle.js"></script>

	<script>
$(function() {
       $("#datepicker1, #datepicker2").datepicker({
           dateFormat: 'yy.mm.dd'
       });
});

</script>

<script type="text/javascript">
$("#submit").click(function() {
	
    var mem_id = "${member.mem_id }";
	var datepicker1 = $("#datepicker1").val();
    var datepicker2 = $("#datepicker2").val();

    var allData = { "mem_id": mem_id, "start_date" : datepicker1, "end_date" : datepicker2};
    
    $.ajax({
        method:"GET",
        url:"/member/selectInbodyValue.do",
        dataType : "json",
        data: allData,
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        success : function(data){
        	
        		var html=''
        		
        		if(data.length > 0 && data[0].data != false){
        			
        	        var weightList = [];
        	        var timeList=[];
					var muscleList = [];
					var bodyFatList = [];
        			
        			for(i=0; i<data.length; i++){
        				weightList.push(data[i].weight);
        				timeList.push(data[i].write_date);
        				muscleList.push(data[i].muscle);
        				bodyFatList.push(data[i].body_fat);
        				
        			}
        			console.log(weightList);
        			console.log(timeList);
        			var totalList = [timeList,weightList, muscleList, bodyFatList];
        			drawLineChart(totalList);
        		}
        },
        error:function(request,status,error){
            alert("에러");
        	//alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
       }
	});
});

function drawLineChart(chartData){
    var lineCanvas = document.querySelector('#myLineChart2');
   // var lineCanvas = document.getElementById("#myLineChart");
    var myChart = new Chart(lineCanvas, {
        type: 'bar',
        
        // The data for our dataset
        data: {
            labels: chartData[0],
            datasets: [{
                label: '근육량(%)',
                type : 'bar', // 'bar' type, 전체 타입과 같다면 생략가능
                backgroundColor: 'rgba(102, 051, 204, 0.2)',
                data: chartData[2]
            }, {
                label: '몸무게(kg)',
                type : 'line',         // 'line' type
                fill : false,         // 채우기 없음
                lineTension : 0.2,  // 0이면 꺾은선 그래프, 숫자가 높을수록 둥글해짐
                pointRadius : 0,    // 각 지점에 포인트 주지 않음
                backgroundColor: 'rgb(255, 153, 0)',
                borderColor: 'rgb(255, 153, 0)',
                data: chartData[1]
            }, {
                label: '체지방량(%)',
                type : 'line',
                fill : false,
                lineTension : 0.2,
                pointRadius : 0,
                borderColor: 'red',
                backgroundColor: 'red',
                data: chartData[3]
            }]
        },
    
        // Configuration options
        options: {
            legend: {
                 labels: {
                      fontColor: 'black' // label color
                     }
                  },
            scales: {
                // y축
                yAxes: [{
                    stacked: false,
                    ticks: {
                        fontColor:'black', // y축 폰트 color
                        suggestedMax: 100,
                        beginAtZero: true
                    }
                 }],
                 // x축
                 xAxes: [{
                     stacked: true,
                    ticks: {
                        fontColor:'black' // x축 폰트 color
                    }
                 }]
            }
        }
    });
};
</script>

	<script>

/* 인바디 정보 등록 */
 $("#inbody_submit").click(function() {
	 var mem_id = "${member.mem_id }";
	 var weight = $("#weight").val();
	 var muscle = $("#muscle").val();
	 var body_fat = $("#body_fat").val();
	 
	    console.log(weight);
	    console.log(muscle);
	    console.log(body_fat);
	    let today = new Date();   

	    let year = today.getFullYear(); // 년도
	    let month = today.getMonth() + 1;  // 월
	    let date = today.getDate();  // 날짜
	    let day = today.getDay();  // 요일
	    if(date<10){
	    	date = '0' + date;
	    }
	    today = year + '' + month +  date;
	    
	
	 var allData = { "mem_id": mem_id, "weight" : weight, "muscle" : muscle, "body_fat" : body_fat, "today" : today};
	  
	 $.ajax({
	        type:'GET',
	        url : "/member/insertInbody.do",
	        data: allData,
	        success : function(data){
	            if(data=="success")
	            {
	            	alert("입력이 완료되었습니다.");
	            }
	            else if(data == "fail"){
	            	alert("하루에 한 번만 입력 가능합니다.");
	            	location.href='#';
	            }
	        },
	        error:function(request,status,error){
	            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	       }
	        
	    });
 })
</script>

</body>
