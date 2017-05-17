package lovo.j135_2.netctoss.dmsmag.dao;

import java.util.Date;
import java.util.List;

import lovo.j135_2.netctoss.dmsmag.beans.DMS;

public interface DMSDao {
	public List<DMS> findAccountByDate(List<Date> dates) throws Exception;
	
	public int insertDMS(DMS dms) throws Exception;
}
