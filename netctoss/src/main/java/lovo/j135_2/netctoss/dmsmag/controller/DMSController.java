package lovo.j135_2.netctoss.dmsmag.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.dmsmag.listener.SessionListener;
import lovo.j135_2.netctoss.dmsmag.service.DMSService;
import lovo.j135_2.netctoss.paymag.beans.MessagePay;
import lovo.j135_2.netctoss.usermag.beans.Business;
import lovo.j135_2.netctoss.usermag.beans.Lab;
import lovo.j135_2.netctoss.usermag.service.BusinessService;
import lovo.j135_2.netctoss.usermag.service.LabService;

@RestController
@RequestMapping("/dmsmag")
@ResponseBody
public class DMSController {
	
	private HttpSession session;
	
	@Resource
	private LabService labServiceImpl;
	
	@Resource
	private DMSService dMSServiceImpl;
	
	@Resource
	private BusinessService businessServiceImpl;
	
	private Business busi;

	@RequestMapping(value="/loadIP")
	public List<Lab> loadLab(){
		List<Lab> list=labServiceImpl.findAllLab();
		return list;
	}
	
	@RequestMapping(value="/loginIP")
	public MessagePay loadIp(@RequestParam("id")String id,@RequestParam("password")String password,
			@RequestParam("ip")String ip,HttpServletRequest request){
		MessagePay pay=new MessagePay();
		try {
			busi=businessServiceImpl.findBusinessByIdAndPassword(new Long(id),password);
			if(busi!=null){
				SessionListener user=new SessionListener();
				user.setId(busi.getId());
				user.setIp(ip);
				user.setAccountId(busi.getFk_accountuser_id().getId());
				session=request.getSession();
				session.setAttribute("user", user);
				pay.setFlag(true);
				pay.setMessage("登录成功");
			}else{
				pay.setFlag(false);
				pay.setMessage("登录失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pay;
	}
	
	@RequestMapping(value="/loginOut",produces="application/json;charset=utf-8")
	public void loginOut(HttpServletRequest request){
		SessionListener user=(SessionListener) session.getAttribute("user");
		if(user.getId()==busi.getId()){
			session.removeAttribute("user");
		}
	}
}
