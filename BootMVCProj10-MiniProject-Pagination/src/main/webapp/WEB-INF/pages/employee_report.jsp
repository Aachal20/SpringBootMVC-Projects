<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"/>

<div class="container">

<h1 style="color: red; text-align: center">Employees Report</h1>
<c:choose>
	<c:when test="${!empty empsData.getContent()}">
		<table class="table table-striped"> 
	<!-- 	<table class="table table-hover">  -->
	<!-- <table class="table">  -->
			<tr class="table-danger">
				<th>EmpNo</th>
				<th>EmpName</th>
				<th>Job</th>
				<th>salary</th>
				<th>Operations</th>
			</tr>

			<c:forEach var="emp" items="${empsData.getContent()}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td><a href="edit?no=${emp.empno}">edit<img src="images/edit.jpg" width="50" height="50" /></a>&nbsp;&nbsp;&nbsp;
					<a  onclick="return confirm('Do You want to delete')" href="delete?no=${emp.empno}">delete<img src="images/delete.jpg"  width="50" height="50"/></a></td>
				</tr>

			</c:forEach>
		</table>

	</c:when>
	<c:otherwise>
		<h1 style="text-align: center">Records Not Found</h1>

	</c:otherwise>



</c:choose>
<c:if test="${!empty resultMsg}">
	<h3 style="color: green; text-align: center">${resultMsg}</h3>
</c:if>

<br>
<br>
<hr>
<hr>
<a href="./" style="align:center"><img src="images/home.jpg" />Home</a>
<h1 style="text-align: center">
	<a href="add"><img src="images/add.jpg" width="100" height="70"/>Add Employee </a>
</h1>
</div>
