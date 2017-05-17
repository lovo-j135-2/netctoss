package lovo.j135_2.netctoss.pojos;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.billmag.service.DayCostBusinessService;
import lovo.j135_2.netctoss.billmag.service.MonthCostAccountService;
import lovo.j135_2.netctoss.billmag.service.MonthCostBusinessService;

/**
 * spring定时任务切面，监听
 * @author Johney
 *
 */

@Repository
@Aspect
public class TimerTaskAspectJ {

	@Resource
	private DayCostBusinessService dayCostBuisnessServiceImpl;
	
	@Resource
	private MonthCostBusinessService monthCostBusinessServiceImpl;
	
	@Resource
	private MonthCostAccountService monthCostAccountServiceImpl;
	
	@AfterReturning(returning="rvt",pointcut="execution(* lovo.j135_2.netctoss.labmag.service.impl.LabDayFilesServiceImpl.insertDayTimeLabFiles(..))")
	public void timerTask(JoinPoint jp,Object rvt){
		try {
			dayCostBuisnessServiceImpl.addDayCostBusiness();
			monthCostBusinessServiceImpl.insertMonthCostBusinessBatch();
			monthCostAccountServiceImpl.insertMonthCostAccountBatch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
