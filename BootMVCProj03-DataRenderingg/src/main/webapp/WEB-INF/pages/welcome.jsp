<%@ page isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2 style="color: red; text-align: center">Home page</h2>

<h2 style="color: red; text-align: center">
	<a href="register"> Welcome to Aachal Academy </a>
</h2>
<%-- 
<b> Name ::::  ${Name} </b>
<b> Name ::::  ${Name} </b><br>
<b> age  ::   ${Age} </b>
<b> address :: ${adrs}</b> --%>


<b> Model Data is(FavColors) Array ,(Collections) </b>
<br>
favorite colors are :: Array
<c:if test="${!empty favColors}">
	<c:forEach var="color" items="${favColors}">
  ${color},
 </c:forEach>
</c:if>

<br>

<hr>

<b> NickNames (List Collections) </b>
<br>
<c:if test="${!empty nickNames}">
	<c:forEach var="name" items="${nickNames}">
 ${name},
  </c:forEach>
</c:if>
<br>
<hr>


<b> Phone Numbers(set collection ::</b>
<br>
<c:if test="${!empty phoneNos}">
	<c:forEach var="phone" items="${phoneNos}">
 ${phone},
  </c:forEach>
</c:if>
<br>
<hr>


<b> Id Details(Map collection -> given values only by taking keys)::</b>
<br>
<c:if test="${!empty idDetails}">
	
    ${idDetails.Aadhar},
    ${idDetails.panNo},
   ${idDetails.voterId},
 
</c:if>
<br>
<hr>


<b> Id Details(Map collection -> given both keys and values)::</b>
<br>
<c:if test="${!empty idDetails}">
	<c:forEach var="id" items="${idDetails}" >
	${id.key} ----------> ${id.value}<br>
	</c:forEach>
 </c:if>
<br>
<hr>

<b>
Model Data is </b><br>
<c:if test="${!empty product}">
        product Id :: ${product.pid}<br>
        product Id :: ${product.pname}<br>
        product Id :: ${product.price}<br>
        product Id :: ${product.qty}<br>
   
  
</c:if>

<h1 style="color:red;text-align:center"><b>List of Model data is :: </b></h1>
	<br>
	<c:choose>
		<c:when test="${!empty prodList}">
			<table align="center" border="1" bgcolor="cyan">
				<tr>
					<th>PID</th>
					<th>PNAME</th>
					<th>PRICE</th>
					<th>QTY</th>
				</tr>
				<c:forEach var="prod" items="${prodList}">
					<tr>
						<td>${prod.pid}</td>
						<td>${prod.pname}</td>
						<td>${prod.price}</td>
						<td>${prod.qty}</td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">No Records found</h1>
		</c:otherwise>
	</c:choose>
 







