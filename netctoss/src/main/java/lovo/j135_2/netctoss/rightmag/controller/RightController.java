package lovo.j135_2.netctoss.rightmag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.rightmag.beans.Right;
import lovo.j135_2.netctoss.rightmag.service.RightService;

@RequestMapping("/right")
@RestController
public class RightController {
	
	@Resource
	private RightService rightServiceImpl;
	@RequestMapping(value="/show")
	public List<Right> showRight(){
		List<Right>rightList = rightServiceImpl.getRights();
		return rightList;
	}
	
	@RequestMapping(value="/save",produces={"application/json;charset=utf-8"})
	public void saveRight(@RequestBody Right right){
		//System.out.println("welcome");
		rightServiceImpl.saveRight(right);
	}
	
	@RequestMapping(value="/update",produces={"application/json;charset=utf-8"})
	public void updateRight(@RequestBody Right right){
		rightServiceImpl.updateRight(right);
	}
	
	@RequestMapping(value="/delete")
	public void deleteRight(@Param("id") long id ){
		//System.out.println(id);
		//System.out.println("delete of RightController");
		rightServiceImpl.deleteRight(id);
	}
}
