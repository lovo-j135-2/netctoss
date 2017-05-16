package lovo.j135_2.netctoss.dmsmag.listener;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.dmsmag.beans.DMS;
import lovo.j135_2.netctoss.dmsmag.service.DMSService;
import lovo.j135_2.netctoss.dmsmag.service.impl.DMSServiceImpl;

@Repository
public class SessionListener implements HttpSessionBindingListener{
	
	private Long id;
	
	private Long accountId;
	
	private String ip;
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//开始时间，结束时间属性
	private Date beginTime;
	
	private Date endTime;
	
	

	@Override
	public void valueBound(HttpSessionBindingEvent value) {
		// TODO Auto-generated method stub
		beginTime=new Date();
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent value) {
		// TODO Auto-generated method stub
		endTime=new Date();
		DMS dms=new DMS(beginTime,endTime,id,ip,accountId);
		//获得spring配置文件
		ApplicationContext ct=new ClassPathXmlApplicationContext("spring-context.xml");
		//打印全部自动装配到容器中的bean
//		System.out.println(ct.getAutowireCapableBeanFactory());
		//获得交给容器管理的bean DMSServiceImpl
		DMSService dMSServiceImpl=(DMSService) ct.getBean("DMSServiceImpl");
		try {
			dMSServiceImpl.insertDMS(dms);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
