package lovo.j135_2.netctoss.logmag.interceptor;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lovo.j135_2.netctoss.logmag.service.ILoginLogService;


public class LogInterceptor implements HandlerInterceptor{
	
	@Resource
	private ILoginLogService loginLogServiceImpl;
	private Long id;
	
	/**
	 * 拦截目标方法执行之前的方法
	 * 适用场合：退出系统之前，记录退出系统日志
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		
		System.out.println("Interceptor----preHandle");
		
//		HandlerMethod h = (HandlerMethod) obj;
//		System.out.println(h.getBean().getClass().getName());	//获取类名 LoginController
//		System.out.println(h.getMethod().getName());		//获取对应的方法名testLogin
//		
//		Date date = new Date();
//		Timestamp time = new Timestamp(date.getTime());
//		
//		loginLogServiceImpl.updateLoginLog(time, id);
		//如果在此处方法返回为false，那么目标方法将不被执行
		return true;
	}	
	
	/**
	 * 拦截目标方法执行之后的方法
	 * 适用场合：登录之后，记录登录日志
	 */
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView mav)
			throws Exception {
		System.out.println("Interceptor----postHandle");
		
		HandlerMethod h = (HandlerMethod) obj;
		System.out.println(h.getBean().getClass().getName());

		String[] str = (String[]) req.getParameterMap().get("userName");
		System.out.println(str[0]);		//参数是一个map集合，key对应的是一个String[]
		
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		
		loginLogServiceImpl.saveLoginLog(str[0], time);	
		
//		id = loginLogServiceImpl.findLoginLogIdByLoginDate(time);
//		System.out.println(id);
		
	}
	

	/**
	 * 所有的拦截器中方法执行完毕之后的方法
	 * 通常用于关闭连接，或者收尾的工作
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("Interceptor----afterHandle");		
	}
}
