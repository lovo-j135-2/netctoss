package lovo.j135_2.netctoss.dmsmag.service;

import java.util.Date;
import java.util.List;

import lovo.j135_2.netctoss.dmsmag.beans.DMS;


public interface DMSService {
	
	public List<DMS> findAccountByDate() throws Exception;
}
