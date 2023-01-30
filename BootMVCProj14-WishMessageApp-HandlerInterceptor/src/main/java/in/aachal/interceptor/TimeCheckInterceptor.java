package in.aachal.interceptor;

import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class TimeCheckInterceptor implements HandlerInterceptor {
  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	System.out.println("TimeCheckInterceptor.preHandle()");
	//get system date and time
	LocalDateTime ldt = LocalDateTime.now();
	//get current hour of the day
	int hour = ldt.getHour();
	if(hour<9 || hour>10) {
		RequestDispatcher rd = request.getRequestDispatcher("/timeout.jsp");
       rd.forward(request, response);
       return false;
	}
	return true;
	}
}
