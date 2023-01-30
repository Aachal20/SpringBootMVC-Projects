<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${!empty jsList}">
		<table bgcolor="pink" align="center" border="1">

			<tr>
				<th>JsId</th>
				<th>JSName</th>
				<th>JsAddress</th>
				<th>resume</th>
				<th>Photo</th>
			<tr>

				<c:forEach var="info" items="${jsList}">

					<tr>
						<td>${info.jsId }</td>
						<td>${info.jsName}</td>
						<td>${info.jsAddrs}</td>
						<td><a href="download?jsId=${info.jsId}&type=resume">Download
								Resume</a></td>
						<td><a href="download?jsId=${info.jsId}&type=photo">Download
								Photo</a></td>
					</tr>
				</c:forEach>

			</tr>
		</table>

	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">Record Not Found</h1>
	</c:otherwise>
</c:choose>