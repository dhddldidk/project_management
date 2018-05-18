<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="handlebars-v4.0.10.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#random{
		width:200px;
	}
	.container{
		min-height: 825px;
		width:80%;
		margin:0 auto;
	}
	.container h2{
		border-left: 20px solid orange;
		border-bottom: 1px solid orange;
		margin-bottom: 20px;
	}
	.form-group{
		margin-bottom: 30px;
	}
</style>
<script>
	$(function() {
		$("#datepicker1").datepicker({dateFormat: "yy-mm-dd"});
		$("#datepicker2").datepicker({dateFormat: "yy-mm-dd"});
	});
</script>
</head>
<body>
	<div class="container">
  <h2>프로젝트 수정하기</h2>
  <form action="updateProject" method="post">
  	<input type="hidden" name="projectNo" value="${dbProject.projectNo }">
    <div class="form-group">
      <label for="projectTitle">프로젝트 이름 :</label>
      <input type="text" class="form-control" id="projectTitle" name="projectTitle" value="${dbProject.projectTitle }">
    </div>
    <div class="form-group">
      <label for="projectContent">프로젝트 내용 :</label>
      <textarea class="form-control" id="projectContent" name="projectContent" rows="10" cols="60">${dbProject.projectContent }</textarea>
    </div>
    <div class="form-group">
      <label for="startdate">시작날짜 :</label>
      <fmt:formatDate value="${dbProject.startdate }" pattern="yyyy-MM-dd" var="dbStartdate" />
      <input type="text" class="form-control" id="datepicker1" value="${dbStartdate }" name="uStartdate">
    </div>
    <div class="form-group">
      <label for="enddate">마감날짜 :</label>
      <fmt:formatDate value="${dbProject.enddate }" pattern="yyyy-MM-dd" var="dbEnddate"/>
      <input type="text" class="form-control" id="datepicker2" value="${dbEnddate }" name="uEnddate">
    </div>
    <div class="form-group" >
      <label for="process">상태 :</label>
      <select name="process" class="form-control" id="random">
      	<c:if test="${dbProject.process == '준비' }">
				<option selected="selected">준비</option>
				<option>진행중</option>
				<option>종료</option>
				<option>보류</option>
			</c:if>
			<c:if test="${dbProject.process == '진행중' }">
				<option>준비</option>
				<option selected="selected">진행중</option>
				<option>종료</option>
				<option>보류</option>
			</c:if>
			<c:if test="${dbProject.process == '종료' }">
				<option>준비</option>
				<option>진행중</option>
				<option selected="selected">종료</option>
				<option>보류</option>
			</c:if>
			<c:if test="${dbProject.process == '보류' }">
				<option>준비</option>
				<option>진행중</option>
				<option>종료</option>
				<option selected="selected">보류</option>
			</c:if>	
      </select>
    </div>
    <button type="submit" class="btn btn-warning">프로젝트 수정하기</button>
    <button type="reset" class="btn btn-default" id="cancel">취소</button>
  </form>
  <script type="text/javascript">
  	$("#cancel").click(function(){
  		
		var projectNo = $("input[type='hidden']").val();  	
  		location.href="readProject?projectNo="+projectNo;
  		
  	})
  </script>
</div>
</body>
</html>
<%@ include file="../common/footer.jsp"%>