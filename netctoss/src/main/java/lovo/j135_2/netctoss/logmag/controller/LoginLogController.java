package lovo.j135_2.netctoss.logmag.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.logmag.beans.LoginLogBean;
import lovo.j135_2.netctoss.logmag.beans.LoginLogPageBean;
import lovo.j135_2.netctoss.logmag.service.ILoginLogService;

@RequestMapping("/showloginlog")
@RestController
public class LoginLogController {
	
	@Resource
	private ILoginLogService loginLogServiceImpl;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public LoginLogPageBean findLoginLogPageBeanByTime(String beginTime,String endTime,@RequestParam("page")int page){
		LoginLogPageBean lp = null;
		lp = new LoginLogPageBean();
		lp.setRows(10);
		int index = (page-1)*10;	//每页显示10条
		lp.setIndex(index);
		
		try {
			List<LoginLogBean> list = loginLogServiceImpl.findLoginLogBeanByTimeToPage(lp, beginTime, endTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return lp;
	}
}
