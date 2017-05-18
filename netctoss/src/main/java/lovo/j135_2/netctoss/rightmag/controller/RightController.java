package lovo.j135_2.netctoss.rightmag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.rightmag.beans.Page;
import lovo.j135_2.netctoss.rightmag.beans.Right;
import lovo.j135_2.netctoss.rightmag.service.RightService;

@RequestMapping("/right")
@RestController
public class RightController {
	
	@Resource
	private RightService rightServiceImpl;
	@RequestMapping(value="/show", produces = "application/json;charset=utf-8")
	public Page showRight(@RequestParam("page")String page,@RequestParam("rows")String rows){
		Page pager=new Page();
		int index=(Integer.parseInt(page)-1)*(Integer.parseInt(rows));
		pager.setIndex(index);
		pager.setLines(Integer.parseInt(rows));
		pager=rightServiceImpl.getRights(pager);
		return pager;
	}
//	@RequestMapping(value="/show")
//	public List<Right> showRight(){
//		return rightServiceImpl.getRights();
//	}
	
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
