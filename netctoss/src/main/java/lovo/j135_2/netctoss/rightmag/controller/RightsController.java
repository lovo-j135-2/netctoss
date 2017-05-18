package lovo.j135_2.netctoss.rightmag.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lovo.j135_2.netctoss.rightmag.beans.Right;
import lovo.j135_2.netctoss.rightmag.beans.Role;
import lovo.j135_2.netctoss.rightmag.service.RoleService;


@RestController
@RequestMapping("/rightmag")
public class RightsController {
	@Resource
	private RoleService roleServiceImpl;
	
	@RequestMapping(value = "/loadRights")
	public List<Right> load(@RequestParam("id") Long id){
		System.out.println(id);
		Role role = roleServiceImpl.getRoleById(id);
		List<Right> rights = role.getRights();
		System.out.println("rightController");
		System.out.println(role);

		return rights;
	}
	
}
