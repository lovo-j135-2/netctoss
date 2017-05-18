package lovo.j135_2.netctoss.usermag.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.paymag.beans.Pay;
import lovo.j135_2.netctoss.paymag.service.PayService;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.usermag.beans.Business;
import lovo.j135_2.netctoss.usermag.beans.Lab;
import lovo.j135_2.netctoss.usermag.beans.Message;
import lovo.j135_2.netctoss.usermag.beans.Pager;
import lovo.j135_2.netctoss.usermag.service.AcconutUserService;
import lovo.j135_2.netctoss.usermag.service.BusinessService;
import lovo.j135_2.netctoss.usermag.service.LabService;


@RestController
@RequestMapping("/businessmag")
public class BusinessController {
	
	@Resource
	private LabService labServiceImpl;
	
	@Resource
	private PayService payServiceImpl;
	
	@Resource
	private BusinessService businessServiceImpl;
	
	@Resource
	private AcconutUserService acconutUserServiceImpl;
	
	@RequestMapping(value = "/load")
	public Pager load(@RequestParam("page")String page,@RequestParam("rows")String rows){
		List<Business> list = new ArrayList<Business>();
		if(page.equals("0")){
			page="1";
		}
		Pager pager = new Pager();
		pager.setPage(Integer.parseInt(page));
		pager.setLines(Integer.parseInt(rows));
		pager.setFromLine((Integer.parseInt(page)-1)*Integer.parseInt(rows));
		try {
			list = businessServiceImpl.queryBusinessByPager(pager);
			pager.setRows(list);
			pager.setTotal(businessServiceImpl.countTotalBusiness());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pager;
	}
	
	@RequestMapping(value="/add",produces="application/json;charset=utf-8")
	public Message add(@RequestBody Business business){
		System.out.println(business);
		Message message = new Message("添加业务操作成功",true);
		try {
			//businessServiceImpl.saveBusiness(business);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return message;
		
	}
	@RequestMapping(value="/delete",produces="application/json;charset=utf-8")
	public Message deleteBusiness(@RequestBody Business business){
		Message message = new Message("删除业务操作成功",true);
		try {
			businessServiceImpl.deleteBusiness(business.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return message;
		
	}
	@RequestMapping(value="/updatePwd",produces="application/json;charset=utf-8")
	public Message updatePwd(@RequestBody Business business){
		Message message = new Message();
		try {
			businessServiceImpl.updateBusiness(business);
			message.setFlag(true);
			message.setMessage("更新密码成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			message.setFlag(false);
			message.setMessage("网络异常，请稍后重试");
		}
		return message;
		
	}
	@RequestMapping(value="/find",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	public Pager find(@RequestBody Business business){
		List<Business> list = new ArrayList<Business>();
		Business bs = null;
		Pager pager = new Pager();
		try {
			bs = businessServiceImpl.queryBusinessByName(business.getBusiness_name());
			System.out.println(bs);
			list.add(bs);
			pager.setRows(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pager;
	}
	
	@RequestMapping(value = "/loadAccount",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	public List<AcconutUser> loadAccount(){
		List<AcconutUser> list = new ArrayList<AcconutUser>();
		try {
			list=acconutUserServiceImpl.findAllUserAccount();
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i).getStatus()==0){
					list.remove(i);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/loadPay",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	public List<Pay> loadPay(){
		List<Pay> list = new ArrayList<Pay>();
		try {
			list=payServiceImpl.findAllPays();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping(value = "/loadLab",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	public List<Lab> loadLab(){
		List<Lab> list = new ArrayList<Lab>();
		list=labServiceImpl.findAllLab();
		return list;
	}
	
	@RequestMapping(value = "/loadBusinessDetail",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	public Business loadBusinessDetail(@RequestBody Business business){
		try {
			business=businessServiceImpl.findBusinessById(business.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return business;
	}
}