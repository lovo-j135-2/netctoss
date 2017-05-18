package lovo.j135_2.netctoss.logmag.logaspectj;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.service.IOperateLogService;
import lovo.j135_2.netctoss.managermag.beans.Manager;
import lovo.j135_2.netctoss.managermag.service.ManagerService;

@Component
@Aspect
public class LogAspectJ_managermag {
	@Resource
	private IOperateLogService operateLogServiceImpl;
	@Resource
	private ManagerService managerServiceImpl;
	@Resource
	private HttpServletRequest req;
	
//	@Before(value="execution(* usermag.dao.impl.*.save*(..))")
	public void before(JoinPoint jp) throws NumberFormatException, Exception{
		System.out.println("*************** 进入AOP ***************");
		
		Object obj = jp.getTarget();	//目标对象
		Class cla = obj.getClass();		//目标对象的class对象

		String str = jp.getSignature().getName();
		
		OperateLogBean operateLog = new OperateLogBean();
		operateLog.setOperateClass(cla.getName());		//获取类名
		operateLog.setOperateMethod(jp.getSignature().getName());	//获取方法名
		operateLog.setOperateParam(jp.getArgs()[0].toString());		//获取参数		
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		operateLog.setOperateTime(time);
		
		Manager man = (Manager) req.getSession().getAttribute("manager");
		String name = man.getName();	//获取到登录管理员的名字
		System.out.println("登录管理员：from AOP"+name);
		Long loginLogId = (Long) req.getSession().getAttribute("id");	//获取到对应的登录日志记录的ID		
		
		operateLog.setAccount(name);
		operateLog.setLoginLog(new LoginLogBean(loginLogId, null, null, null));	
		
		if(str.indexOf("delete")!=-1){
				//调用方法查找删除这条记录的详细信息
			Manager manager = managerServiceImpl.getManager(Long.parseLong(jp.getArgs()[0].toString()));
			operateLog.setOperateOldValue(manager.toString());
			operateLog.setOperateType("删除");
			operateLogServiceImpl.saveOperateLog(operateLog);
			
		}else if(str.indexOf("update")!=-1){
			Manager manager = (Manager) jp.getArgs()[0];
			Long id = manager.getId();
			Manager oldManager = managerServiceImpl.getManager(id);	//调用方法查找修改这条记录的详细信息
			operateLog.setOperateOldValue(oldManager.toString());
			operateLog.setOperateType("修改");
			operateLogServiceImpl.saveOperateLog(operateLog);
		}
		
	}
	
	public void after(JoinPoint jp){
		System.out.println("*************** 进入AOP ***************");
		
		Object obj = jp.getTarget();	//目标对象
		Class cla = obj.getClass();		//目标对象的class对象
		
		String str = jp.getSignature().getName();
		
		OperateLogBean operateLog = new OperateLogBean();
		operateLog.setOperateClass(cla.getName());		//获取类名
		operateLog.setOperateMethod(jp.getSignature().getName());	//获取方法名
		operateLog.setOperateParam(jp.getArgs()[0].toString());		//获取参数		
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		operateLog.setOperateTime(time);
		
		Manager man = (Manager) req.getSession().getAttribute("manager");
		String name = man.getName();	//获取到登录管理员的名字
		System.out.println("登录管理员：from AOP"+name);
		Long loginLogId = (Long) req.getSession().getAttribute("id");	//获取到对应的登录日志记录的ID		
		
		operateLog.setAccount(name);
		operateLog.setLoginLog(new LoginLogBean(loginLogId, null, null, null));	
		
		if(str.indexOf("save")!=-1){
			operateLog.setOperateOldValue(null);		
			operateLog.setOperateType("增加");			
			operateLogServiceImpl.saveOperateLog(operateLog);			
		}
		
	}
}
