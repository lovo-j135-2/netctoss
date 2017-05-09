package lovo.j135_2.netctoss.loginmag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.loginmag.service.IManagerLoginService;
import lovo.j135_2.netctoss.managermag.beans.Manager;
import lovo.j135_2.netctoss.pojos.Messager;

//@RestController === @ResponseBody +  @Controller
@RequestMapping("/managersLogin")
@RestController
// 将所有方法的执行结果放入到响应体中，并且将该组件交给spring容器
public class ManagerLoginController {
	
	@Resource
	private IManagerLoginService managerLoginServiceImpl;
	
	
	@RequestMapping(value="/managers",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public List<Manager> queryManagerByaccountsAndPassword(@RequestBody Manager manager) {
		Messager msg = new Messager(true, "操作成功");
		List<Manager> list = null;
		try {
			list = managerLoginServiceImpl.queryManagerByaccountsAndPassword(manager);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后再试");
		}

		return list;
	}

	
	
	
}
