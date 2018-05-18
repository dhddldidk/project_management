<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>	
<%@ include file="../common/header.jsp"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="handlebars-v4.0.10.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
	#mainContainer{
		/* border:1px solid red; */
		min-height: 825px;
		width:90%;
		margin:0 auto;
	}
	#mainContainer p {
		text-align: right;
		margin-top:20px;
		font-size: 1.5em;
	}
	.container{
		width:100%;
	}
	#wrapper th,#wrapper td{
		padding:15px;
		text-align: center;
	}
	#wrapper th{
		font-size: 1.3em;
	}
	#wrapper td a{
		color:green;
		font-weight: bold;
	}
	#wrapper{
		margin-top:20px;
	}
</style>
<section id="mainContainer">
<div class="container">
 <p><a href="addProject">[새 프로젝트 등록]</a></p>
  <table class="table" id="wrapper">
    <thead>
      <tr class="warning">
        <th>프로젝트 이름</th>
        <th>시작날짜</th>
        <th>종료날짜</th>
        <th>상태</th>
      </tr>
    </thead>
    <c:forEach items="${list }" var="list">
    	<tbody>
    		<tr class="active">
			<td><a href="readProject?projectNo=${list.projectNo }">${list.projectTitle }</a></td>
			<td><fmt:formatDate value="${list.startdate }" pattern="yyyy-MM-dd"/></td>
			<td><fmt:formatDate value="${list.enddate }" pattern="yyyy-MM-dd"/></td>
			<td>${list.process}</td>
			</tr>
    	</tbody>
    </c:forEach>
   </table> 
   
   
</div>
</section>
</body>
</html>

<%@ include file="../common/footer.jsp"%>