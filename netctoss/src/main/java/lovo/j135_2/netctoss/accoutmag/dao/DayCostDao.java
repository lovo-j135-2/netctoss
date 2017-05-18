package lovo.j135_2.netctoss.accoutmag.dao;

import java.util.List;

import lovo.j135_2.netctoss.accoutmag.beans.DayCost;

public interface DayCostDao {

	public List<DayCost> findAllDayCostByBusinessIdAndAccountId(Long businessId, Long accountId, int month);
}
