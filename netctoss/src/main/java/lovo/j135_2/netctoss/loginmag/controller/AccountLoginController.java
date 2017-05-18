package lovo.j135_2.netctoss.loginmag.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.loginmag.service.IAccountUserLoginService;
import lovo.j135_2.netctoss.pojos.Messager;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

@RequestMapping("/accountUserLogin")
@RestController
// 将所有方法的执行结果放入到响应体中，并且将该组件交给spring容器
public class AccountLoginController {

	@Resource
	private IAccountUserLoginService accountUserServiceImpl;
	
	char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	// 用户登录
	@RequestMapping(value = "/accountUsers", method = RequestMethod.POST, produces = {
			"application/json;charset=utf-8" })
	public Messager queryAccountUserByaccountNameAndPassword(@RequestBody AcconutUser account,
			HttpServletRequest request) {
		Messager msg = new Messager();
		System.out.println(account);
		if (account.getAccount_name() == null || account.getPassword() == null) {
			msg.setStatus(false);
			msg.setMsg("请输入用户名或密码");
		} else {
			HttpSession session = request.getSession();
			AcconutUser ac = null;

			try {
				ac = accountUserServiceImpl.queryAcconutUserByAccountNameAndPwd(account);
				if (ac == null) {
					msg.setStatus(false);
					msg.setMsg("密码或账号错误，请重新输入");
				} else {
					msg.setStatus(true);
					msg.setMsg(ac.getAccount_name() + "成功");
					request.getSession().setAttribute("user", ac);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg.setStatus(false);
				msg.setMsg("系统繁忙，请稍后再试");
			}
			AcconutUser a = (AcconutUser) session.getAttribute("user");
			System.out.println("session" + a);
		}
		System.out.println(msg);

		return msg;
	}

	// 修改个人密码
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = { "application/json;charset=utf-8" })
	public Messager updateAccountUser(@RequestBody AcconutUser account,@PathVariable("id")Long id,HttpServletRequest request) {
		Messager msg = new Messager();
		AcconutUser ac = null;
		account.setId(id);
		try {
			System.out.println(account);
			int number = accountUserServiceImpl.updatePasswordByAccountName(account);
			System.out.println(number);
			if(number==1){
				msg.setMsg("修改成功");
				msg.setStatus(true);				
			}else{
				msg.setStatus(false);
				msg.setMsg("系统繁忙，请稍后再试");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg.setStatus(false);
			msg.setMsg("系统繁忙，请稍后再试");
		}
		HttpSession session = request.getSession();
		ac = (AcconutUser) session.getAttribute("user");
		System.out.println(ac);
		return msg;

	}

	// 查询个人用户信息
	@RequestMapping(value = "/showUserInfo", method = RequestMethod.POST, produces = {
			"application/json;charset=utf-8" })
	public AcconutUser getAccountUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AcconutUser ac = null;
		try {
			ac = (AcconutUser) session.getAttribute("user");
			System.out.println(ac.getAccount_name());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return ac;
	}
	
	@RequestMapping(value="/loginOut",method=RequestMethod.GET,produces={"application/json;charset=utf-8"})
	public Messager loginOut(HttpServletRequest request){
		Messager msg = new Messager();
		HttpSession session = request.getSession();
		session.invalidate();		
		
		return msg;
		
	}
	/**
	 * 产生验证码随机数
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping(value = "/code", method = RequestMethod.GET, produces = { "application/json;charset=utf-8" })
	public StringBuffer getCode(HttpServletRequest req, HttpServletResponse resp) {

		// 创建一个随机数生成器类
		Random random = new Random();
		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();

		for (int i = 0; i < 5; i++) {
			// 得到随机产生的验证码数字。
			String code = String.valueOf(codeSequence[random.nextInt(codeSequence.length - 1)]);
			// 将产生的四个随机数组合在一起。
			randomCode.append(code);
		}
//		// 将四位数字的验证码保存到Session中。
//		HttpSession session = req.getSession();
//		System.out.print(randomCode);
//		session.setAttribute("code", randomCode.toString());
//		String co = (String) session.getAttribute("code");
//		System.out.println("session中的验证码：" + co);
		return randomCode;

	}
	

}
