
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color: red; text-align: center">
	<a href="register">Politician Registration</a>
</h1>

<form:form method="POST" modelAttribute="pp">

	<table>

		<tr>
			<td>Politician Name ::</td>
			<td><form:input path="pname"/></td>

		</tr>


		<tr>
			<td>Politician Party Name ::</td>
			<td><form:input path="party"/></td>

		</tr>


		<tr>
			<td>Politician DOB ::</td>
			<td><form:input path="dob" type="date" /></td>

		</tr>


		<tr>
			<td>Politician DOJ ::</td>
			<td><form:input path="doj" type="date" /></td>

		</tr>

		<tr>
			<td>Has constitution post? ::</td>
			<td><form:radiobutton path="consPost" value="true"/>
				yes&nbsp;&nbsp; <form:radiobutton path="consPost" value="false"/>
				no</td>

		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="register"></td>
		</tr>

	</table>






</form:form>


