<%@ page isELIgnored="false"  %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>

<noscript>
    <h1 style="color:red;text-align:center">Please enable java script </h1>
</noscript>

<style media = "all">
         body {
            background-color: pink;
         }
         span {
            color: red;
         }
      </style>
      
      <script language="JavaScript"  src="js/validation.js">
      </script>

 <h1 style="color:red;text-align:center"> Register Employee </h1>
 <form:form modelAttribute="emp" onsubmit="return validation(this)"  name="frm">
   <%-- <p style="color:red;text-align:center">
      <form:errors  path="*"/>
   </p>
    --%>
   <table border="1" bgcolor="cyan"  align="center">
     
      <tr>
         <td> employee name ::  </td>
         <td> <form:input path="ename"/>    <form:errors  path="ename"/>  <span id="enameErr"></span></td>
      </tr>
     
       
      <tr>
         <td> employee desg ::  </td>
         <td> <form:input path="job"/>  <form:errors  path="job"/> <span id="jobErr"></span></td>
      </tr>
      
      <tr>
         <td> employee salary ::  </td>
         <td> <form:input path="sal"/>   <form:errors  path="sal"/><span id="salErr"></span></td>
      </tr>
      
     <script language= "JavaScript"> 
     function sendRequestForStates(frm){
    	 frm.action="stateurl";   //req path for handeler method
    	 frm.submit(); //submit the request
    	 
     }
     
     </script>
     
      <tr>
			<td>Select Countries::</td>
			<td><form:select path="country"  onchange="sendRequestForStates()" >
					<form:options items="${countriesinfo}" />
				</form:select></td>
		</tr>
		
		 <tr>
			<td>Select State::</td>
			<td><form:select path="state">
					<form:options items="${statesInfo}"/>
				</form:select></td>
		</tr>
		
      <tr>
         <td colspan="2" align="center"><input type="submit" value="Register Employee"/></td>
      </tr>
   </table>
   <%--   <form:hidden path="vflag" /> --%>
 </form:form> 
     