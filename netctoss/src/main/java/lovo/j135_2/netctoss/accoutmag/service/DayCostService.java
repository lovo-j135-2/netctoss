package lovo.j135_2.netctoss.accoutmag.service;

import java.util.List;

import lovo.j135_2.netctoss.accoutmag.beans.DayCost;

public interface DayCostService {

	public List<DayCost> findAllDayCostByBusinessIdAndAccountId(Long businessId, Long accountId, int month);
}
