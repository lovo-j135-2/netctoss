package lovo.j135_2.netctoss.util;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lovo.j135_2.netctoss.managermag.beans.Manager;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

public class URLFilter implements Filter{
	private List<String> list = new ArrayList<String>();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		
		String uri = request.getRequestURI();
		if(list.contains(uri.substring(uri.lastIndexOf("/")))){
			chain.doFilter(request, response);
			return;
		}
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute("manager");
		AcconutUser accountUser = (AcconutUser) session.getAttribute("user");
		
		if(manager==null && accountUser==null ){
			System.out.println("被过滤了");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String value = config.getInitParameter("noFilterURL");
		String[] urls = value.split(",");
		for(int i=0;i<urls.length;i++){
			list.add(urls[i]);
		}
	}

}
