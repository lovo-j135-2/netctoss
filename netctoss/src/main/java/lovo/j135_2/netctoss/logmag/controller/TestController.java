package lovo.j135_2.netctoss.logmag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	
	@RequestMapping("/age.do")
	public String testController(){
		return "age";
	}
}
