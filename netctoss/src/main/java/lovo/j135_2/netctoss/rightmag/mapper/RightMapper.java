package lovo.j135_2.netctoss.rightmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import lovo.j135_2.netctoss.rightmag.beans.Right;

public interface RightMapper {

	@Insert(value={"insert into t_right(name,discription) values (#{right.name},#{right.discription})"})
	public void saveRight(@Param("right")Right right);
	
	@Delete(value={"delete from t_right where id=#{id};delete from t_right_role where fk_right_id=#{id}"})
	public void deleteRight(long id);
	
	@Update(value={"update t_right set name=#{right.name},discription=#{right.discription} where id=#{right.id}"})
	public void updateRight(@Param("right")Right right);
	
	@Select(value={"select * from t_right"})
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="name",column="name",javaType=String.class),
		@Result(property="discription",column="discription",javaType=String.class),
		@Result(property="url",column="url",javaType=String.class),
		@Result(property="parentId",column="p_id",javaType=Long.class),
	})
	public List<Right> getRights();
}
