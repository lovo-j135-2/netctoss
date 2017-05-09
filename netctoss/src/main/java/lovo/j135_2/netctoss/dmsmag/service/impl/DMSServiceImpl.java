package lovo.j135_2.netctoss.dmsmag.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.dmsmag.beans.DMS;
import lovo.j135_2.netctoss.dmsmag.dao.DMSDao;
import lovo.j135_2.netctoss.dmsmag.service.DMSService;
import lovo.j135_2.netctoss.util.MyDate;

@Service
public class DMSServiceImpl implements DMSService {

	@Resource 
	private DMSDao dMSDaoImpl;
	
	@Override
	public List<DMS> findAccountByDate() throws Exception {
		// TODO Auto-generated method stub
		Date date=new Date();
		String string=MyDate.dateToString(date);
		String[] strings=string.split("-| |:");
		String stringBegin=strings[0]+"-"+strings[1]+"-"+"01"+" "+"00:00:00";
		Date beginDate=MyDate.stringToUtilDate(stringBegin);
		List<Date> dates=new ArrayList<Date>();
		dates.add(beginDate);
		dates.add(date);
		return dMSDaoImpl.findAccountByDate(dates);
	}

}
