package lovo.j135_2.netctoss.accoutmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import lovo.j135_2.netctoss.accoutmag.beans.DayCost;

public interface DayCostMapper {

	public List<DayCost> findAllDayCostByBusinessIdAndAccountId(@Param("bId")Long businessId,@Param("aId")Long accountId,@Param("month")int month);
}
