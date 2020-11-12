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
<style>
.title{
	font-size : 50px;
	color : green;
	text-align : center;
	font-weight: bold;

}
.button{
	font-size : 30px;
	align : center;
}
#canvas{
	margin-left : 550px;
}
#label-container{
	margin-left : 700px;
}
#counter{
	text-align: center;
	color : blue;
	font-style : 'Malgun Gothic';
	font-size : 60px;
}
#warning{
	text-align: center;
	color : red;
	font-size : 20px;
	font-style : 'Malgun Gothic';
}
</style>
<body>
<section class="machine">
	<div class="title">인공지능 운동코치</div>
	</br>
	<div class="title"><button class="button" type="button" onclick="init()">운동시작</button></div>
  <div><canvas id="canvas"></canvas></div>
  <div id="label-container"></div>
  <div id="counter"></div>
  <div id="warning"></div>
</section>
  <script src="https://cdn.jsdelivr.net/npm/@tensorflow/tfjs@1.3.1/dist/tf.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@teachablemachine/pose@0.8/dist/teachablemachine-pose.min.js"></script>
  <script type="text/javascript">
    // More API functions here:
    // https://github.com/googlecreativelab/teachablemachine-community/tree/master/libraries/pose

    // the link to your model provided by Teachable Machine export panel
    const URL = "/resources/json/";
    let model, webcam, ctx, labelContainer, maxPredictions, counter;

    async function init() {
        const modelURL = URL + "model.json";
        const metadataURL = URL + "metadata.json";

        // load the model and metadata
        // Refer to tmImage.loadFromFiles() in the API to support files from a file picker
        // Note: the pose library adds a tmPose object to your window (window.tmPose)
        model = await tmPose.load(modelURL, metadataURL);
        maxPredictions = model.getTotalClasses();

        // Convenience function to setup a webcam
        const size = 400;
        const flip = true; // whether to flip the webcam
        webcam = new tmPose.Webcam(size, size, flip); // width, height, flip
        await webcam.setup(); // request access to the webcam
        await webcam.play();
        window.requestAnimationFrame(loop);

        // append/get elements to the DOM
        const canvas = document.getElementById("canvas");
        canvas.width = size; canvas.height = size;
        ctx = canvas.getContext("2d");
        labelContainer = document.getElementById("label-container");
        for (let i = 0; i < maxPredictions; i++) { // and class labels
            labelContainer.appendChild(document.createElement("div"));
        }
    }

    async function loop(timestamp) {
        webcam.update(); // update the webcam frame
        await predict();
        window.requestAnimationFrame(loop);
    }

    var status = "rock"; //초기상태
    var count = 0;
    async function predict() {
        // Prediction #1: run input through posenet
        // estimatePose can take in an image, video or canvas html element
        const { pose, posenetOutput } = await model.estimatePose(webcam.canvas);
        // Prediction 2: run input through teachable machine classification model
        const prediction = await model.predict(posenetOutput);
        if(prediction[0].probability.toFixed(2) == 1.00){
	    	if( status=="squat" ){ //스탠드 -> 스쿼트로 바뀌면 count+1
	    		count++;
	    		document.getElementById("warning").innerHTML = "";
	    		document.getElementById("counter").innerHTML = count;
	    		if(count>=5){
	    			document.getElementById("counter").innerHTML = "5번 모두 완료했습니다.";
	    		}
	    	}
	    	status = "bent";
	    } else if (prediction[1].probability.toFixed(2) == 1.00){
	    	document.getElementById("warning").innerHTML = "올바른 동작으로 해주세요";
	    	status = "sissor";
	    } else if (prediction[2].probability.toFixed(2) == 1.00){
	    	status = "squat";
	    }
        for (let i = 0; i < maxPredictions; i++) {
            const classPrediction =
                prediction[i].className + ": " + prediction[i].probability.toFixed(2);
            labelContainer.childNodes[i].innerHTML = classPrediction;
            
        }

        // finally draw the poses
        drawPose(pose);
        
    }
	
    function drawPose(pose) {
        if (webcam.canvas) {
            ctx.drawImage(webcam.canvas, 0, 0);
            // draw the keypoints and skeleton
            if (pose) {
                const minPartConfidence = 0.5;
                tmPose.drawKeypoints(pose.keypoints, minPartConfidence, ctx);
                tmPose.drawSkeleton(pose.keypoints, minPartConfidence, ctx);
            }
        }
    }
</script>
</body>
</html>