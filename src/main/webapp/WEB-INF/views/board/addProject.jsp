<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var stDate=$("#datepicker1").val();
	$(function() {
		$("#datepicker1").datepicker({
			dateFormat : "yy-mm-dd",
		});
		$("#datepicker2").datepicker({
			dateFormat : "yy-mm-dd",
			
		});
	});
</script>
<style>
#random {
	width: 200px;
}

.container {
	min-height: 825px;
	width: 80%;
	margin: 0 auto;
}

.container h2 {
	border-left: 20px solid orange;
	border-bottom: 1px solid orange;
	margin-bottom: 20px;
}

.form-group {
	margin-bottom: 30px;
}
</style>
</head>
<body>
	<div class="container">
		<h2>프로젝트 추가하기</h2>
		<form action="addProject" method="post">
			<div class="form-group">
				<label for="projectTitle">프로젝트 이름 :</label> <input type="text"
					class="form-control" id="projectTitle" placeholder="프로젝트 이름"
					name="projectTitle">
			</div>
			<div class="form-group">
				<label for="projectContent">프로젝트 내용 :</label>
				<textarea class="form-control" id="projectContent"
					placeholder="프로젝트 내용" name="projectContent" rows="10" cols="60"></textarea>
			</div>
			<div class="form-group">
				<label for="startdate">시작날짜 :</label> <input type="text"
					class="form-control" id="datepicker1" placeholder="클릭하세요"
					name="startdateForm">
			</div>
			<div class="form-group">
				<label for="enddate">마감날짜 :</label> <input type="text"
					class="form-control" id="datepicker2" placeholder="클릭하세요"
					name="enddateForm">
			</div>
			<div class="form-group">
				<label for="process">상태 :</label> <select name="process"
					class="form-control" id="random">
					<option>준비</option>
					<option>진행중</option>
					<option>종료</option>
					<option>보류</option>
				</select>
			</div>
			<button type="submit" class="btn btn-danger">프로젝트 추가하기</button>
			<button type="reset" class="btn btn-default">취소</button>
		</form>
	</div>
	<script type="text/javascript">
		/* $(document).ready(function(){
		   $.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/addProject",
				dataType:"json",
				headers:{"Content-Type":"application/json"},
				success:function(result){
					console.log(result);
					if(result=="success"){
						alert("등록되었습니다.");
					}
				}
			})
		})
		 */
	</script>
</body>
</html>
<%@ include file="../common/footer.jsp"%>