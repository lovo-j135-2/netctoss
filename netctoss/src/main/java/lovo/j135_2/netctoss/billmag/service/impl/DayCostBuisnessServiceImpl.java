package lovo.j135_2.netctoss.billmag.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lovo.j135_2.netctoss.billmag.beans.DayCostBussiness;
import lovo.j135_2.netctoss.billmag.beans.MonthCostBussiness;
import lovo.j135_2.netctoss.billmag.dao.DayCostBusinessDao;
import lovo.j135_2.netctoss.billmag.service.DayCostBusinessService;
import lovo.j135_2.netctoss.dmsmag.beans.DMS;
import lovo.j135_2.netctoss.dmsmag.service.DMSService;
import lovo.j135_2.netctoss.usermag.beans.Business;
import lovo.j135_2.netctoss.usermag.service.BusinessService;
import lovo.j135_2.netctoss.util.MyDate;

@Service
public class DayCostBuisnessServiceImpl implements DayCostBusinessService {
	
	@Resource
	private DMSService dMSServiceImpl;
	
	@Resource 
	private BusinessService businessServiceImpl;
	
	@Resource
	private DayCostBusinessDao dayCostBusinessDaoImpl;
	
	@Override
	public int addDayCostBusiness() throws Exception {
		// TODO Auto-generated method stub
		List<DMS> dmss=dMSServiceImpl.findAccountByDate();
		List<DayCostBussiness> list=new ArrayList<DayCostBussiness>();
		for (DMS dms : dmss) {
			String time=MyDate.dateToString(dms.getBeginTime());
			String[] strings=time.split("-| |:");
			String time2=MyDate.dateToString(dms.getEndTime());
			String[] strings2=time2.split("-| |:");
			int year=Integer.parseInt(strings[0]);
			int month=Integer.parseInt(strings[1]);
			int day=Integer.parseInt(strings[2]);
			int endSecond=Integer.parseInt(strings2[3])*3600+Integer.parseInt(strings2[4])*60+
					Integer.parseInt(strings2[5]);
			int beginSecond=Integer.parseInt(strings[3])*3600+Integer.parseInt(strings[4])*60+
					Integer.parseInt(strings[5]);
			int second=endSecond-beginSecond;
			int min=(int) Math.ceil((double)second/(double)60);
			Business busi=businessServiceImpl.findBusinessContainLabAndAccountAndPayByBusiId(dms.getBusinessId());
			DayCostBussiness dayCostBusiness=new DayCostBussiness(year, month, min, day, busi.getPay().getUnitCost(), busi.getBusiness_name(), dms.getBeginTime(), dms.getEndTime(),dms.getAccountId(),dms.getIp());
			dayCostBusiness.setBussiness(busi);
			list.add(dayCostBusiness);
		}
		return dayCostBusinessDaoImpl.addDayCostBusiness(list);
	}

	@Override
	public List<MonthCostBussiness> findMonthTotalMesInDayCostBusinessByYearAndMonth()
			throws Exception {
		// TODO Auto-generated method stub
		Date date=MyDate.getDate();
		String time=date.toString();
		String[] times=time.split("-");
		int year=Integer.parseInt(times[0]);
		int month=Integer.parseInt(times[1]);
		int[] days=new int[2];
		days[0]=1;
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
			days[1]=31;
		}else{
			days[1]=30;
		}
		List<MonthCostBussiness> list=new ArrayList<MonthCostBussiness>();
		list=dayCostBusinessDaoImpl.findMonthTotalMesInDayCostBusinessByYearAndMonth(year, month, days);
		List<MonthCostBussiness> list1=new ArrayList<MonthCostBussiness>();
		list1=dayCostBusinessDaoImpl.findMonthTotalCostMesInDayCostBusinessByYearAndMonth(year, month, days);
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getBussiness().getId()==list1.get(i).getBussiness().getId()){
				list.get(i).setCost(list1.get(i).getCost());
			}
		}
		return list;
	}

}
