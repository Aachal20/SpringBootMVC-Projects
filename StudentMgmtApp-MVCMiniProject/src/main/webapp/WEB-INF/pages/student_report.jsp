<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="color: red; text-align: center">Student Report</h1>
<c:choose>
	<c:when test="${!empty studsData}">
		<table border="1" bgcolor="yellow" align="center">
			<tr>
			<th>sr.no</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Address</th>
				<th>Course Name</th>
				<th>Email</th>
				<th>Ph No</th>
			</tr>

			<c:forEach var="stud" items="${studsData}">
				<tr>
				<td>${stud.sid}</td>
					<td>${stud.fname}</td>
					<td>${stud.lname}</td>
					<td>${stud.addrs}</td>
					<td>${stud.course}</td>
					<td>${stud.email}</td>
					<td>${stud.phno}</td>
					<td><a href="edit?no=${stud.sid}">edit<img src="images/edit.jpg" width="50" height="50" /></a>&nbsp;&nbsp;&nbsp;
					<a  onclick="return confirm('Do You want to delete')" href="delete?no=${stud.sid}">delete<img src="images/delete.jpg"  width="50" height="50"/></a></td>
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
	<a href="add"><img src="images/add.jpg" width="100" height="70"/>Add Student </a>
</h1>
