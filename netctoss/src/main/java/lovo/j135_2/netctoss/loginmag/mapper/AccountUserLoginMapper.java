package lovo.j135_2.netctoss.loginmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import lovo.j135_2.netctoss.usermag.beans.AcconutUser;

public interface AccountUserLoginMapper {

	@Insert("insert into t_accountuser(password,account_name) values(#{account.password},#{account.account_name})")
	@Options(useGeneratedKeys=true,keyProperty="account.id")
	public int saveAccountUser(@Param("account")AcconutUser account) throws Exception;
	
	@Select("select * from t_accountuser where account_name=#{account.account_name} and password=#{account.password}")
	@ResultType(AcconutUser.class)
	public List<AcconutUser> queryAcconutUserByAccountAndPwd(@Param("account")AcconutUser account)throws Exception;
	
	@Select("select * from t_accountuser where id=#{id}")
	@ResultType(AcconutUser.class)
	public AcconutUser getAccountUser(Long id)throws Exception;
	
	@Update("update t_accountuser set password=#{account.password} where id=#{account.id}")
	public int updateAccountUser(@Param("account")AcconutUser account)throws Exception;
	/**
	 * 退出系统
	 */
}
