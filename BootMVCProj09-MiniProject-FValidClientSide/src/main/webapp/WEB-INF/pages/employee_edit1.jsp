<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<h1 style="color: red; text-align: center">Edit Employee</h1>

<script  language ="JavaScript" src="js/validation.js">

</script>

 <form:form modelAttribute="emp" onsubmit="return validation(this)">
 <%-- <p style="color:red;text-align:center"> 
 <form:errors path="*"/>
 </p> --%>
 
	<table border="1" bgcolor="pink" align="center">
<tr>
			<td>Employee No </td>
			<td><form:input path="empno"  readonly="true"/></td>
		</tr>

		<tr>
			<td>Employee Name</td>
			<td><form:input path="ename" /><span id="enameErr"></span></td>
		</tr>

		<tr>
			<td>Employee Desg</td>
			<td><form:input path="job" /> <span id="jobErr" ></span></td>
		</tr>

		<tr>
			<td>Employee Salary</td>
			<td><form:input path="sal" />  <span id="salErr" ></span></td>
		</tr>

		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="Edit Employee" /></td>
				<a href="employee_report">Home</a>
		</tr>

	</table>
</form:form> 


