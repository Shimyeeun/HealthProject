<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
	request.setCharacterEncoding("UTF-8");
%>

<body>

	<div class="progress_area" style="height: 200px">
		<div>
			<h3 style="text-align: center; padding-top: 50px;">진행률</h3>
		</div>
		<div style="text-align: center">그래프</div>
		<div></div>
	</div>

	<div class="calendar_area" style="height: 550px">
		<div>
			<h1 style="text-align: center">캘린더</h1>
		</div>
	</div>

	<div class="inbody_area" style="height: 450px">
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
					<button type="button" id="submit">CHECK</button>
				</div>
			</div>

			<div class="view_graph" style="width:80%; height:800px; margin:0 auto; position: relative">
				<canvas class="line_graph" id="myLineChart2"></canvas>
				<script type="text/javascript">
$("#submit").click(function() {
    var mem_id = "${member.mem_id }";
	var datepicker1 = $("#datepicker1").val();
    var datepicker2 = $("#datepicker2").val();
    
    console.log(mem_id);
    console.log(datepicker1);
    console.log(datepicker2);
    
    var allData = { "mem_id": mem_id, "start_date" : datepicker1, "end_date" : datepicker2 };
    
    $.ajax({
        method:"GET",
        url:"/member/myPage.do",
        dataType : "json",
        data: allData,
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        success : function(data){
        	
        		var html=''
        		
        		if(data.length > 0 && data[0].data != false){
        			
        			alert("정상적으로 들어왔습니다^^");
        	        var weightList = [];
        	        var timeList=[];

        			
        			for(i=0; i<data.length; i++){
        				weightList.push(data[i].weight);
        				timeList.push(data[i].write_date);
        				console.log(data[i].mem_id);
        				console.log(data[i].weight);
        				console.log(data[i].muscle);
        				console.log(data[i].body_fat);
        				console.log(data[i].write_date);
        				
        			}
        			console.log(weightList);
        			console.log(timeList);
        			var totalList = [weightList,timeList];
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
        type : 'line',
        data : {
            labels: chartData[1],
            datasets: [{
                data: chartData[0],
                label:'나의 인바디',
                backgroundColor: 'rgba(102, 051, 204, 0.2)'
            }]
        }
    });
}



</script>
			</div>

		</div>


		<!--<canvas width="400" height="400" id="myLineChart"></canvas> -->
	</div>
	<div>
		<form style="text-align: right; width: 80%;">
			<label>몸무게: <input id="weight" type="text" name="weight"
				placeholder="몸무게를 입력해주세요."></label><br> <label>근육량: <input
				id="muscle" type="text" name="muscle" placeholder="근육량을 입력해주세요."></label><br>
			<label>체지방량: <input id="body_fat" type="text" name="body_fat"
				placeholder="체지방량을 입력해주세요."><br></label><br> <input
				type="submit" value="입력"
				style="background-color: black; color: white;">
		</form>
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




</body>
