package lovo.j135_2.netctoss.labmag.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.labmag.beans.PageDayTimeFiles;
import lovo.j135_2.netctoss.labmag.service.LabDayFilesService;

@RestController
@RequestMapping("/accountmag")
public class AccountController {
	
	@Resource
	private LabDayFilesService labDayFilesServiceImpl;
	
	@RequestMapping(value="/searchMonth")
	public PageDayTimeFiles searchMonthLabFiles(@RequestParam("page")String page,
			@RequestParam("rows")String rows,
			@RequestParam("year")String year,@RequestParam("month")String month){
		PageDayTimeFiles pageTime=new PageDayTimeFiles();
		pageTime.setPage(Integer.parseInt(page));
		pageTime.setLines(Integer.parseInt(rows));
		try {
			pageTime=labDayFilesServiceImpl.findLabMonthMesByYearAndMonth(Integer.parseInt(year), Integer.parseInt(month), pageTime);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageTime;
	}
	
	@RequestMapping(value="/searchDay")
	public PageDayTimeFiles searchDayLabFiles(@RequestParam("page")String page,
			@RequestParam("rows")String rows,@RequestParam("ip")String ip,
			@RequestParam("year")String year,@RequestParam("month")String month){
		PageDayTimeFiles pageTime=new PageDayTimeFiles();
		pageTime.setPage(Integer.parseInt(page));
		pageTime.setLines(Integer.parseInt(rows));
		try {
			pageTime=labDayFilesServiceImpl.findLabDayMesByYearAndMonth(Integer.parseInt(year), Integer.parseInt(month), ip, pageTime);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageTime;
	}
	
	@RequestMapping(value="/searchYear")
	public PageDayTimeFiles searchYearLabFiles(@RequestParam("page")String page,
			@RequestParam("rows")String rows,
			@RequestParam("year")String year){
		PageDayTimeFiles pageTime=new PageDayTimeFiles();
		pageTime.setPage(Integer.parseInt(page));
		pageTime.setLines(Integer.parseInt(rows));
		try {
			pageTime=labDayFilesServiceImpl.findLabYearMesByYear(Integer.parseInt(year), pageTime);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageTime;
	}
	
	
	@RequestMapping(value="/searchYearMonth")
	public PageDayTimeFiles searchYearMonthLabFiles(@RequestParam("page")String page,
			@RequestParam("rows")String rows,@RequestParam("ip")String ip,
			@RequestParam("year")String year){
		PageDayTimeFiles pageTime=new PageDayTimeFiles();
		pageTime.setPage(Integer.parseInt(page));
		pageTime.setLines(Integer.parseInt(rows));
		try {
			pageTime=labDayFilesServiceImpl.findLabYearsMonthCountByYearAndIp(Integer.parseInt(year), ip, pageTime);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageTime;
	}
	
	
	@RequestMapping(value="/searchYearMonthDay")
	public PageDayTimeFiles searchYearMonthDayLabFiles(@RequestParam("page")String page,
			@RequestParam("rows")String rows,@RequestParam("ip")String ip,
			@RequestParam("year")String year,@RequestParam("month")String month){
		String[] ips=ip.split(":");
		String ip_num=ips[1];
		PageDayTimeFiles pageTime=new PageDayTimeFiles();
		pageTime.setPage(Integer.parseInt(page));
		pageTime.setLines(Integer.parseInt(rows));
		try {
			pageTime=labDayFilesServiceImpl.findLabDayMesByYearAndMonth(Integer.parseInt(year), Integer.parseInt(month), ip_num, pageTime);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageTime;
	}

}
