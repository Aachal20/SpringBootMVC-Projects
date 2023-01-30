
function validation(frm){
	//empty the error messages
	 document.getElementById("enameErr").innerHTML="";
	 document.getElementById("jobErr").innerHTML="";
	 document.getElementById("salErr").innerHTML="";
	//read form data
	let ename=frm.ename.value;
	letjob=frm.job.value;
	let sal = frm.sal.value;
	let flag=true;
	//form validation(client side)
	if(ename==""){                           //ename required rule
		document.getElementById("enameErr").innerHTML="Employee Name is mandator(cs)";
		flag=false;
	}
		else if(ename.length()>10){        //ename -max length rule
		document.getElementById("enameErr").innerHTML="Employee Name must have  max of 10 chars(cs)";
		flag=false;
	}
	
	
	if(job==""){                           //ename required rule
		document.getElementById("jobErr").innerHTML="Employee job  is mandator(cs)";
		flag=false;
	}
		else if(job.length()>9){        //ename -max length rule
		document.getElementById("jobErr").innerHTML="Employee desg  must have  max of 9 chars(cs)";
		flag=false;
	}
	
	
	
	if(sal==""){                           //ename required rule
		document.getElementById("salErr").innerHTML="Employee salary is mandator(cs)";
		flag=false;
	}
	else if(isNaN(Sal)){        //ename -max length rule
		document.getElementById("salErr").innerHTML="Employee salary  must be numeric value(cs)";
		flag=false;
	}
		else if(sal<0 || sal>100000){        //ename -max length rule
		document.getElementById("salErr").innerHTML="Employee salary  must be in a range of 1 to 100000(cs)";
		flag=false;
	}
	
	return flag;
}





