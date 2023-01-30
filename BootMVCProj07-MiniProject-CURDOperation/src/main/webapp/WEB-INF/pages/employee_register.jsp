<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1 style="color: red; text-align: center">Register Employee</h1>
<%-- 
<form:form modelAttribute="emp">
	<table border="1" bgcolor="pink" align="center">

		<tr>
			<td>Employee Name</td>
			<td>Employee Desg</td>
			<td>Employee Salary</td>
			
  	</tr>
  	<tr>
		<td><form:input path="ename" /></td>
		<td colspan="2" align="center"><input type="submit"
				value="register employee" /></td>
				</tr>
				<tr>
		<td><form:input path="job" /></td>
		<td colspan="2" align="center"><input type="submit"
				value="register employee" /></td>
				</tr>
				<tr>
			<td><form:input path="sal" /></td>
			<td colspan="2" align="center"><input type="submit"
				value="register employee" /></td>
				</tr>
		
	</table>
</form:form>
 --%>

 <form:form modelAttribute="emp">
	<table border="1" bgcolor="pink" align="center">

		<tr>
			<td>Employee Name</td>
			<td><form:input path="ename" /></td>
		</tr>

		<tr>
			<td>Employee Desg</td>
			<td><form:input path="job" /></td>
		</tr>

		<tr>
			<td>Employee Salary</td>
			<td><form:input path="sal" /></td>
		</tr>

		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="register employee" /></td>
		</tr>

	</table>
</form:form> 


