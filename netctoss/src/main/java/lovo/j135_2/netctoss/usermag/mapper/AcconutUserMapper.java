package lovo.j135_2.netctoss.usermag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.usermag.beans.Pager;


public interface AcconutUserMapper {
	/**
	 * 添加账务账号
	 * @param user 账务账号
	 * @return
	 */
	@Insert(value="insert into t_accountuser values(null,#{user.real_name},#{user.id_num},#{user.password},#{user.gender},#{user.account_name},#{user.phone},#{user.address},#{user.postcode},#{user.qq},#{user.status})")
	public int saveAcconutUser(@Param("user")AcconutUser user) throws Exception;
	/**
	 * 按账务id删除账务账号
	 * @param id
	 * @return
	 */
	@Delete(value="delete from t_accountuser where id=#{id}")
	@Transactional(readOnly=false)
	public int deleteAcconutUser(@Param("id")int id) throws Exception;
	/**
	 * 修改账务账号状态
	 * @param user
	 * @return
	 */
	@Update(value="update t_accountuser set status=#{user.status} where id=#{user.id}")
	public int updateAcconutUser(@Param("user")AcconutUser user) throws Exception;
	/**
	 * 按账务id查询账务信息
	 * @param id 账务id
	 * @return 账务对象
	 */
	@Select(value="select * from t_accountuser where id=#{id}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="real_name",column="real_name",javaType=String.class),
		@Result(property="id_num",column="id_num",javaType=String.class),
		@Result(property="password",column="password",javaType=String.class),
		@Result(property="gender",column="gender",javaType=Integer.class),
		@Result(property="account_name",column="account_name",javaType=String.class),
		@Result(property="phone",column="phone",javaType=String.class),
		@Result(property="address",column="address",javaType=String.class),
		@Result(property="postcode",column="postcode",javaType=String.class),
		@Result(property="qq",column="qq",javaType=String.class),
		@Result(property="status",column="status",javaType=Integer.class)
	})
	public AcconutUser queryAcconutUserById(int id) throws Exception; 
	/**
	 * 分页查询账务
	 * @param pager
	 * @return
	 * @throws Exception
	 */
	@Select(value="select * from t_accountuser limit #{pager.fromLine},#{pager.lines}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="real_name",column="real_name",javaType=String.class),
		@Result(property="id_num",column="id_num",javaType=String.class),
		@Result(property="password",column="password",javaType=String.class),
		@Result(property="gender",column="gender",javaType=Integer.class),
		@Result(property="account_name",column="account_name",javaType=String.class),
		@Result(property="phone",column="phone",javaType=String.class),
		@Result(property="address",column="address",javaType=String.class),
		@Result(property="postcode",column="postcode",javaType=String.class),
		@Result(property="qq",column="qq",javaType=String.class),
		@Result(property="status",column="status",javaType=Integer.class)
	})
	public List<AcconutUser> queryAcconutUserByPager(@Param("pager")Pager pager)throws Exception;
}
