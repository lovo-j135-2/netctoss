package lovo.j135_2.netctoss.rightmag.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.rightmag.beans.Page;
import lovo.j135_2.netctoss.rightmag.beans.Right;
import lovo.j135_2.netctoss.rightmag.beans.Role;
import lovo.j135_2.netctoss.rightmag.service.RightService;
import lovo.j135_2.netctoss.rightmag.service.RoleService;

@RequestMapping("/role")
@RestController
public class RoleController {

	@Resource
	private RoleService roleServiceImpl;
	@Resource
	private RightService rightServiceImpl;
	
	@RequestMapping(value="/show", produces = "application/json;charset=utf-8")
	public Page showRole(@RequestParam("page")String page,@RequestParam("rows")String rows){
		
		System.out.println("每页条数"+rows);
		Page pager=new Page();
		int index=(Integer.parseInt(page)-1)*(Integer.parseInt(rows));
		pager.setIndex(index);
		pager.setLines(Integer.parseInt(rows));
		pager= roleServiceImpl.searchRole("%", "%", pager);
		return pager;
	}
	
	@RequestMapping(value="/searchRight")
	public List<Right> searchRight(){ //查询权限表，返回权限的List
		//System.out.println("welcome rolecontroller");
		List<Right>rightList=rightServiceImpl.getRights();
		//System.out.println(rightList);
		return rightList;
	}
	
	@RequestMapping(value="/searchRightOfRole")
	public List<Long>searchRightOfRole(@Param("id") long id){
		List<Long>idList=roleServiceImpl.idList(id);
		//System.out.println(idList);
		return idList;
	}
	
	@RequestMapping(value="/save")
	public void saveRole(@RequestParam("name")String name,@RequestParam("roleType")String roleType,@RequestParam("id[]")String[] data){
		Role role=new Role();
		List<Right> rightList=new ArrayList();
		for(int i=0;i<data.length;i++){
			Right right=new Right();
			long id=Long.parseLong(data[i]);
			right.setId(id);
			rightList.add(right);
		}
		role.setName(name);
		role.setRoleType(roleType);
		role.setRights(rightList);
		roleServiceImpl.saveRole(role);
		//System.out.println(role.getId()); 
	}
	
	@RequestMapping(value="/update")
	public void updateRole(@RequestParam("name")String name,@RequestParam("roleType")String roleType,@RequestParam("id[]")String[] data,@RequestParam("roleId")long roleId){
		System.out.println("updateController");
		Role role=new Role();
		List<Right>rightList = new ArrayList();
		for(int i=0;i<data.length;i++){
			Right right = new Right();
			long id = Long.parseLong(data[i]);
			right.setId(id);
			rightList.add(right);
		}
		role.setId(roleId);
		role.setName(name);
		role.setRoleType(roleType);
		role.setRights(rightList);
		roleServiceImpl.updateRole(role);
	}
	
	@RequestMapping(value="/searchRole",produces={"application/json;charset=utf-8"})
	public Page searchRole(@RequestParam("name")String name,@RequestParam("roleType")String roleType,@RequestParam("page")String page,@RequestParam("lines")String lines){ //模糊查询角色表，返回筛选后的角色List
		System.out.println("come on");
		Page pager=new Page();
		pager.setLines(Integer.parseInt(lines));
		int index=(Integer.parseInt(page)-1)*(Integer.parseInt(lines));
		pager.setIndex(index);
		pager=roleServiceImpl.searchRole(name,roleType,pager);
		return pager;
	}
	
	@RequestMapping(value="/delete")
	public void deleteRole(@Param("id") long id){
		System.out.println("delete");
		roleServiceImpl.deleteRole(id);
	}
}
