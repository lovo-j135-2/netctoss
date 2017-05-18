package lovo.j135_2.netctoss.logmag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;
import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.service.ILoginLogService;

@RequestMapping("/showloginlog")
@RestController
public class LoginLogController {
	
	@Resource
	private ILoginLogService loginLogServiceImpl;
	
	@RequestMapping(value="/everypage")
	public LoginLogPageBean findLoginLogPageBeanByTime(
			@RequestParam("page")String page,@RequestParam("rows")String rows){

		LoginLogPageBean lp = new LoginLogPageBean();
		lp.setPage(Integer.parseInt(page));
		lp.setIndex((Integer.parseInt(page)-1)*Integer.parseInt(rows));
		lp.setLines(Integer.parseInt(rows));	//rows 每页显示的行数
		
		try {
			lp = loginLogServiceImpl.findLoginLogBeanByTimeToPage(lp,"","10000000","30000000");
//			System.out.println(lp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lp;
	}
	
	@RequestMapping(value="/searchData")
	public LoginLogPageBean search(@RequestParam("account")String account,@RequestParam("beginTime")String beginTime,
			@RequestParam("endTime")String endTime,@RequestParam("page")String page,@RequestParam("rows")String rows){		
//		System.out.println(beginTime);
//		System.out.println(endTime);
		
		LoginLogPageBean lp = new LoginLogPageBean();
		lp.setPage(Integer.parseInt(page));
		lp.setIndex((Integer.parseInt(page)-1)*Integer.parseInt(rows));
		lp.setLines(Integer.parseInt(rows));	//rows 每页显示的行数
		
		try {
			lp = loginLogServiceImpl.findLoginLogBeanByTimeToPage(lp,account,beginTime,endTime);
//			System.out.println(lp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lp;
	}
	
	@RequestMapping(value="/alldatas",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public List<LoginLogBean> findAllLoginLogBeanByTime(String account,String beginTime,String endTime){
		
		String beginTime1 = (beginTime==""?"10000000":beginTime);
		String endTime1 = (endTime==""?"30000000":endTime);
		
		System.out.println(beginTime);
		
		List<LoginLogBean> list = loginLogServiceImpl.findAllLoginLogBeanByTimeToPage(account,beginTime1, endTime1);	
		
//		System.out.println(list);
		return list;
	}
	
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public List<OperateLogBean> findLoginLogBeanById(@PathVariable("id")Long id){
		
		LoginLogBean loginLog = loginLogServiceImpl.findLoginLogBeanById(id);
		
		List<OperateLogBean> operateLogs = loginLog.getOperateLogs();
		
		return operateLogs;
	}
	

	
}
