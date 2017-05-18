package lovo.j135_2.netctoss.logmag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.logmag.beans.OperateLogBean;
import lovo.j135_2.netctoss.logmag.beans.OperateLogPageBean;
import lovo.j135_2.netctoss.logmag.service.IOperateLogService;

@RequestMapping(value="/showoperatelog")
@RestController
public class OperateLogController {
	@Resource
	private IOperateLogService operateLogServiceImpl;
	
	@RequestMapping(value="/alldatas")
	public List<OperateLogBean> findAllOperateLog(String account,String operateType,String beginTime,String endTime){
		
//		account = account==null?"":account;
//		operateType = operateType==null?"":operateType;
		beginTime = beginTime==""?"10000000":beginTime;
		endTime = endTime==""?"30000000":endTime;	
		
//		System.out.println("account:"+account);
		
		List<OperateLogBean> list = operateLogServiceImpl.findAllOperateLogBeansByAccountAndOperateTypeAndBeginTimeAndEndTime(account, operateType, beginTime, endTime);
		
		return list;
	}	
	
	@RequestMapping(value="/everypage")
	public OperateLogPageBean findOperateLogPageBean(
			@RequestParam("page")String page,@RequestParam("rows")String rows){
	
		OperateLogPageBean op = new OperateLogPageBean();
		op.setPage(Integer.parseInt(page));		//当前页数
		op.setIndex((Integer.parseInt(page)-1)*Integer.parseInt(rows));		//当页数据起始下标
		op.setLines(Integer.parseInt(rows));	//rows 每页显示的行数
		
		try {
			op = operateLogServiceImpl.findOperateLogBeanByTimeToPage(op, "", "", "19700101", "20180808");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return op;		//limit index,lines; --> 没有括号！！
	}
	
	@RequestMapping(value="/search")
	public OperateLogPageBean serach(@RequestParam("account")String account,@RequestParam("type")String type,
			@RequestParam("beginTime")String beginTime,@RequestParam("endTime")String endTime,
			@RequestParam("page")String page,@RequestParam("rows")String rows){
		
		OperateLogPageBean op = new OperateLogPageBean();
		op.setPage(Integer.parseInt(page));		//当前页数
		op.setIndex((Integer.parseInt(page)-1)*Integer.parseInt(rows));		//当页数据起始下标
		op.setLines(Integer.parseInt(rows));	//rows 每页显示的行数
		
		try {
			op = operateLogServiceImpl.findOperateLogBeanByTimeToPage(op, account, type, beginTime, endTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return op;
	}
	
	
	
}
