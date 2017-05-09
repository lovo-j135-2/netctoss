package lovo.j135_2.netctoss.loginmag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.loginmag.service.IAccountUserLoginService;
import lovo.j135_2.netctoss.pojos.Messager;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

//@RestController === @ResponseBody +  @Controller
@RequestMapping("/accountUserLogin")
@RestController
// 将所有方法的执行结果放入到响应体中，并且将该组件交给spring容器
public class AccountLoginController {

	@Resource
	private IAccountUserLoginService accountUserServiceImpl;

	// 注册用户
	@RequestMapping(value = "/saveAccountUser", method = RequestMethod.POST, produces = {
			"application/json;charset=utf-8" })
	public Messager saveAccountUser(@RequestBody AcconutUser account) {

		Messager msg = new Messager(true, "操作成功");
		try {
			accountUserServiceImpl.saveAccountUser(account);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后再试");
		}
		return msg;

	}

	// 用户登录
	@RequestMapping(value = "/accountUsers", method = RequestMethod.GET, produces = {
			"application/json;charset=utf-8" })
	public List<AcconutUser> queryAccountUserByaccountNameAndPassword(@RequestBody AcconutUser account) {
		Messager msg = new Messager(true, "操作成功");
		List<AcconutUser> list = null;
		try {
			list = accountUserServiceImpl.queryAcconutUserByAccountAndPwd(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后再试");
		}
		return list;
	}

	// 修改个人密码
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = { "application/json;charset=utf-8" })
	public Messager updateAccountUser(@RequestBody AcconutUser ac, @PathVariable Long id) {
		Messager msg = new Messager(true, "操作成功");
		try {
			ac.setId(id);
			accountUserServiceImpl.updateAccountUser(ac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后再试");
		}
		return msg;

	}

	// 查询个人用户信息
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { "application/json;charset=utf-8" })
	public AcconutUser getAccountUser(@PathVariable Long id) {
		Messager msg = new Messager(true, "操作成功");
		AcconutUser ac = null;
		try {
			ac = accountUserServiceImpl.getAccountUser(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后再试");
		}

		return ac;
	}

}
