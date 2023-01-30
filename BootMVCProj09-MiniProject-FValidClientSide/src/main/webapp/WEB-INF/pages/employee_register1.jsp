<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

 <style media ="all">
  body{
     background-color: pink;
  }
  span{
  color:red;
  }
</style> 

<h1 style="color: red; text-align: center">Register Employee</h1>

<%-- 

<form:form modelAttribute="emp">
 
<form:form modelAttribute="emp>


<form:errors path="*" />
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

<script  language ="JavaScript" src="js/validation.js">

</script>
 <form:form modelAttribute="emp" onsubmit="return validation(this)">
<%--  <p style="color:blue;text-align:center">
 <form:errors path="*"/>
 </p> --%>
 
	<table border="1"  bgcolor="pink" align="center">

		<tr>
			<td>Employee Name</td>
			<td><form:input path="ename" /><span id="enameErr"></span></td>
		</tr>

		<tr>
			<td>Employee Desg</td>
			<td><form:input path="job" /><span id="jobErr"></span></td>
		</tr>

		<tr>
			<td>Employee Salary</td>
			<td><form:input path="sal" /><span id="salErr"></span></td>
		</tr>

		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="register employee" /></td>
		</tr>

	</table>
</form:form> 


