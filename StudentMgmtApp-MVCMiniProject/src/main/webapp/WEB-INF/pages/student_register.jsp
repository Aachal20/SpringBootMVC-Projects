
<%@ page language="java" isELIgnored="false" %>
<%@ taglib uri ="http://www.springframework.org/tags/form" prefix="form" %> 


<h1 style="color:red;text-align:center"> Student Registration</h1>

<form:form modelAttribute="stud"> 
<table border="1" bgcolor="pink"  align="center">
  
  
  <tr>
     <td>Student FirstName </td>
     <td><form:input path = "fname" /> </td>
  </tr>
  
   <tr>
     <td>Student LastName </td> &nbsp;&nbsp;
     <td><form:input path = "lname" /> </td>
  </tr>
  
   <tr>
     <td>Student Address </td> &nbsp;&nbsp;
     <td><form:input path = "addrs" /> </td>
  </tr>
  
   <tr>
     <td>Course </td> &nbsp;&nbsp;
     <td><form:input path = "course" /> </td>
  </tr>
  
   <tr>
     <td>Student Email ID </td> &nbsp;&nbsp;
     <td><form:input path = "email" /> </td>
  </tr>
  
   <tr>
     <td>Student Mobile Number </td> &nbsp;&nbsp;
     <td><form:input path = "phno" /> </td>
  </tr>
  
  <tr>
 <td colspan="2" align="center"><input type="submit" value="Register Student">  </td>
   </tr>
</table>

</form:form>
