<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<b> wish message:: ${wMsg}</b>
<b> sys date and time :: ${sysDate}</b>

<h1> Result Page</h1>
<b> Wish Message :: <c:out value="${wMsg}"/></b>

<h2 style="color:red;text-align:center"> Home page(wish.jsp)</h2>

<h2 style="color:red;text-align:center"> <a href ="register">  Register Student </a> </h2>