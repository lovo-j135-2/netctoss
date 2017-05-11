package lovo.j135_2.netctoss.usermag.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import lovo.j135_2.netctoss.usermag.beans.Lab;

public interface LabMapper {

	@Select(value="select* from t_lab where id=#{id}")
	public Lab findLabById(@Param("id")Long id) throws Exception;
}
