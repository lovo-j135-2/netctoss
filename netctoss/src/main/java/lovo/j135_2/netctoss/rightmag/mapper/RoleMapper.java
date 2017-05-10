package lovo.j135_2.netctoss.rightmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import lovo.j135_2.netctoss.rightmag.beans.Role;

public interface RoleMapper {

	@Insert(value={"insert into t_role(name,role_type) values (#{role.name},#{role.roleType})"})
	public void saveRole(@Param("role")Role role);
	
	@Delete(value={"delete from t_role where id=#{id}"})
	public void deleteRole(long id);
	
	@Update(value={"update t_role set name=#{role.name},role_type=#{role.roleType} where id=#{role.id}"})
	public void updateRole(@Param("role")Role role);
	
	@Select(value={"select * from t_role where name like CONCAT(#{roleName},'%') and role_type=#{roleType}"})
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="name",column="name",javaType=String.class),
		@Result(property="roleType",column="role_type",javaType=String.class)
	})
	public List<Role> getRole(@Param("roleName")String roleName,@Param("roleType")String roleType);
}
