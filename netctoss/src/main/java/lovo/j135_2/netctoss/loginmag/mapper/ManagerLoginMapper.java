package lovo.j135_2.netctoss.loginmag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import lovo.j135_2.netctoss.managermag.beans.Manager;

public interface ManagerLoginMapper {

@Select("select * from t_manager where accounts=#{ma.accounts} and password=#{ma.password}")
@ResultType(Manager.class)
public Manager queryManagerByaccountsAndPassword(@Param("ma")Manager manager) throws Exception;
	
@Select("select * from t_manager where id=#{id}")
@ResultType(Manager.class)
public Manager getManagerById(Long id)throws Exception;

@Select("select * from t_manager where accounts=#{ma.accounts}")
@ResultType(Manager.class)
public Manager getManagerByaccounts(@Param("ma")Manager manager)throws Exception;

@Update("update t_manager set password=#{ma.password} where accounts=#{ma.accounts}")
public int updatePasswordByAccounts(@Param("ma")Manager manager)throws Exception; 
   
	/**
     * 退出系统
     */
	
}
