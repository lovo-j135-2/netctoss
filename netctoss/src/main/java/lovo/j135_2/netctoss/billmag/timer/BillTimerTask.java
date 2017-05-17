package lovo.j135_2.netctoss.billmag.timer;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.billmag.service.DayCostBusinessService;
import lovo.j135_2.netctoss.billmag.service.MonthCostAccountService;
import lovo.j135_2.netctoss.billmag.service.MonthCostBusinessService;

@Repository
public class BillTimerTask {

	@Resource
	private DayCostBusinessService dayCostBuisnessServiceImpl;
	
	@Resource
	private MonthCostBusinessService monthCostBusinessServiceImpl;
	
	@Resource
	private MonthCostAccountService monthCostAccountServiceImpl;
	
	
	/**
	 * 月底结算每天账务对应业务使用明细
	 */
	public void insertDayCostBusinessDetailEndTheMonth(){
		
		try {
			dayCostBuisnessServiceImpl.addDayCostBusiness();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 月底结算每个账号对应的业务账号及费用总和
	 */
	public void insertMonthCostBusinessEndTheMonth(){
		try {
			monthCostBusinessServiceImpl.insertMonthCostBusinessBatch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 月底结算每个账号费用总和
	 */
	public void insertMonthCostCostEndTheMonth(){
		try {
			monthCostAccountServiceImpl.insertMonthCostAccountBatch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
