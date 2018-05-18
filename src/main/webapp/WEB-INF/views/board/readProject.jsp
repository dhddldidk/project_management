<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>	
<%@ include file="../common/header.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="handlebars-v4.0.10.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#readContainer {
	/* border:1px solid red; */
	min-height: 825px;
	width: 90%;
	margin: 0 auto;
}

#wrapper td {
	padding: 15px;
	/* border:3px solid red; */
	font-size: 1.3em;
}

#wrapper {
	margin-top: 20px;
}

#wrapper td:first-child {
	width: 400px;
}

#wrapper tr td:first-child {
	text-align: center;
}

#wrapper tr td:last-child {
	background-color: #EAEAEA;
}

#readBtn {
	text-align: center;
}

#readBtn a {
	font-size: 1.3em;
	margin: 20px;
}
</style>
</head>
<body>
	<div id="readContainer">
		<table class="table" id="wrapper">
			<tbody>
				<tr class="warning">
					<td>프로젝트 이름</td>
					<td>${sProject.projectTitle }</td>
				</tr>
				<tr class="warning">
					<td>프로젝트 내용</td>
					<td>${sProject.projectContent }</td>
				</tr>
				<tr class="warning">
					<td>시작날짜</td>
					<td><fmt:formatDate value="${sProject.startdate }" pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr class="warning">
					<td>종료날짜</td>
					<td><fmt:formatDate value="${sProject.enddate }" pattern="yyyy-MM-dd" /></td>
				</tr>
				<tr class="warning">
					<td>상태</td>
					<td>${sProject.process }</td>
				</tr>
			</tbody>
		</table>

		<p id="readBtn">
			<a href="updateProject?projectNo=${sProject.projectNo }">[ 수정 ]</a> <a
				href="deleteProject?projectNo=${sProject.projectNo }" id="delete">[ 삭제 ]</a> <a
				href="listProject">[ 돌아가기 ]</a>
		</p>
	<script type="text/javascript">
		$("#delete").click(function(){
			
			if(confirm("정말 삭제하시겠습니까?") != true){
				return false;
			}
		})
	</script>
	</div>
</body>
</html>
<%@ include file="../common/footer.jsp"%>