package lovo.j135_2.netctoss.dmsmag.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.dmsmag.beans.DMS;
import lovo.j135_2.netctoss.dmsmag.dao.DMSDao;
import lovo.j135_2.netctoss.dmsmag.mapper.DMSMapper;

@Repository
public class DMSDaoImpl implements DMSDao {
	
	@Resource
	private DMSMapper dmsMapper;
	
	@Override
	public List<DMS> findAccountByDate(List<Date> dates) throws Exception {
		// TODO Auto-generated method stub
		return dmsMapper.findAccountByDate(dates);
	}

}
