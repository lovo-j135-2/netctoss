package lovo.j135_2.netctoss.rightmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import lovo.j135_2.netctoss.rightmag.beans.Page;
import lovo.j135_2.netctoss.rightmag.beans.Role;

public interface RoleMapper {

	@Insert(value={"insert into t_role(name,role_type) values (#{role.name},#{role.roleType})"})
	@Options(useGeneratedKeys=true,keyProperty="role.id")
	public void saveRole(@Param("role")Role role);
	
	@Delete(value={"delete from t_role where id=#{id};delete from t_right_role where fk_role_id=#{id}"})
	public void deleteRole(long id);
	
	@Update(value={"update t_role set name=#{role.name},role_type=#{role.roleType} where id=#{role.id}"})
	public void updateRole(@Param("role")Role role);
	
	@Select(value={"select * from t_role where name like CONCAT(#{roleName},'%') and role_type like CONCAT(#{roleType}) limit #{page.index},#{page.lines}"})
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="name",column="name",javaType=String.class),
		@Result(property="roleType",column="role_type",javaType=String.class)
	})
	public List<Role> searchRole(@Param("roleName")String roleName,@Param("roleType")String roleType,@Param("page")Page page);
	
	@Select(value={"select count(*) from t_role where name like CONCAT(#{roleName},'%') and role_type like CONCAT(#{roleType})"})
	@ResultType(Integer.class)
	public int searchRoleCount(@Param("roleName")String roleName,@Param("roleType")String roleType,@Param("page")Page page);
	
	public void saveBatchRightToRole(@Param("role")Role role);
	
	@Delete(value={"delete from t_right_role where fk_role_id=#{id}"})
	public void deleteRightOfRole(long id);
	
	@Select(value={"select * from t_role"})
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="name",column="name",javaType=String.class),
		@Result(property="roleType",column="role_type",javaType=String.class)
	})
	public List<Role> getRole();
	
	@Select(value={"select * from t_role where id=#{id}"})
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="name",column="name",javaType=String.class),
		@Result(property="roleType",column="role_type",javaType=String.class)
	})
	public Role findRoleBeanById(long id);
	
	@Select(value={"select fk_right_id from t_right_role where fk_role_id=#{id}"})
	@ResultType(List.class)
	public List<Long> idList (long id);
	
}
