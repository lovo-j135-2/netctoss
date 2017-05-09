package lovo.j135_2.netctoss.accoutmag.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.labmag.bean.PageDayTimeFiles;
import lovo.j135_2.netctoss.labmag.service.LabDayFilesService;

@RestController
@RequestMapping("/accountmag")
public class AccountController {
	
	@Resource
	private LabDayFilesService labDayFilesServiceImpl;
	
	@RequestMapping(value="/loadMonth")
	public PageDayTimeFiles loadMonthLabFiles(@RequestParam("page")String page,@RequestParam("rows")String rows){
		
		return null;
	}

}
