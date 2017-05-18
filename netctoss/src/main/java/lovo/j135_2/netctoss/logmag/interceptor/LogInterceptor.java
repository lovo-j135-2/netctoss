package lovo.j135_2.netctoss.logmag.interceptor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;
import lovo.j135_2.netctoss.logmag.service.ILoginLogService;
import lovo.j135_2.netctoss.managermag.beans.Manager;


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
		
//		Enumeration<String> keys = req.getParameterNames(); 
//		while(keys.hasMoreElements()) { 
//		    String k = keys.nextElement(); 
//		    System.out.println(k + " 111= " + req.getParameter(k) ); 
//		} 
		
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
		
//		HandlerMethod h = (HandlerMethod) obj;
//		System.out.println(h.getBean().getClass().getName());
		
		Manager man = (Manager) req.getSession().getAttribute("manager");	//用session来取，拦截器的意义何在？
																			//但是不用session，直接获取参数，那错误登录的用户有有何意义？
																			//如果写一个普通方法也能获取session，但是登录方法必须调用
																			//拦截器不需要调用，如此看来还是有点意义嘛小伙子！
		String name = man.getName();
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		
		LoginLogBean bean = new LoginLogBean();
		bean.setAccount(name);
		bean.setLoginTime(time);
		loginLogServiceImpl.saveLoginLog(bean);	
		Long id = bean.getId();		//返回刚刚存入这条登录日志的ID
		
		req.getSession().setAttribute("id", id);	//将这条记录的ID存入session中，操作日志中要用到
		
//		Map<String, String[]> map = req.getParameterMap();
//		System.out.println(map);		//参数是一个map集合，key对应的是一个String[]
//		
//		Enumeration<String> keys = req.getParameterNames(); 
//		while(keys.hasMoreElements()) { 
//		    String k = keys.nextElement(); 
//		    System.out.println(k + " = " + req.getParameter(k) ); 
//		} 
		
		
		
		
//		System.out.println(bean.getId());
		
		
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
