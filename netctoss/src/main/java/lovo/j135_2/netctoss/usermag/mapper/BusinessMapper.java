package lovo.j135_2.netctoss.usermag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import lovo.j135_2.netctoss.paymag.beans.Pay;
import lovo.j135_2.netctoss.usermag.beans.AcconutUser;
import lovo.j135_2.netctoss.usermag.beans.Business;
import lovo.j135_2.netctoss.usermag.beans.Lab;
import lovo.j135_2.netctoss.usermag.beans.Pager;


public interface BusinessMapper {
	
	/**
	 * 添加业务
	 * @param business
	 * @return
	 * @throws Exception
	 */
	@Insert(value="insert into t_business values(null,#{business.business_name},#{business.password},#{business.lab.id},#{business.fk_accountuser_id.id},#{business.pay.id})")
	public int saveBusiness(@Param("business")Business business) throws Exception;
	/**
	 * 删除业务
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Delete(value="delete from t_business where id=#{id}")
	public int deleteBusiness(int id) throws Exception;
	/**
	 * 修改业务
	 * @param business
	 * @return
	 * @throws Exception
	 */
	@Update(value="update t_business set password=#{business.password} where id=#{business.id}")
	public int updateBusiness(@Param("business")Business business) throws Exception;
	/**
	 * 查询业务
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Select(value="select * from t_business where id=#{id}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="business_name",column="business_name",javaType=String.class),
		@Result(property="password",column="password",javaType=String.class),
		@Result(property="fk_accountuser_id",column="fk_accountuser_id",javaType=AcconutUser.class,one=@One(fetchType=FetchType.LAZY,select="queryAcconutUserById")),
		@Result(property="pay",column="pay",javaType=Pay.class,one=@One(fetchType=FetchType.LAZY,select="queryPayById")),
		@Result(property="lab",column="lab",javaType=Lab.class,one=@One(fetchType=FetchType.LAZY,select="queryLabById"))
	})
	public Business queryBusinessById(int id) throws Exception;
	@Select(value="select * from t_accountuser where id=#{id}")
	@ResultType(AcconutUser.class)
	public AcconutUser queryAcconutUserById(int id) throws Exception;
	@Select(value="select * from t_pay where id=#{id}")
	@ResultType(Pay.class)
	public Pay queryPayById(int id) throws Exception;
	@Select(value="select * from t_lab where id=#{id}")
	@ResultType(Lab.class)
	public Lab queryLabById(int id) throws Exception;
	/**
	 * 分页查询业务
	 * @param pager
	 * @return
	 * @throws Exception
	 */
	@Select(value="select * from t_business limit #{pager.fromLine},#{pager.lines}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="business_name",column="business_name",javaType=String.class),
		@Result(property="password",column="password",javaType=String.class),
		@Result(property="fk_accountuser_id",column="fk_accountuser_id",javaType=AcconutUser.class,one=@One(fetchType=FetchType.LAZY,select="queryAcconutUserById")),
		@Result(property="pay",column="pay",javaType=Pay.class,one=@One(fetchType=FetchType.LAZY,select="queryPayById")),
		@Result(property="lab",column="lab",javaType=Lab.class,one=@One(fetchType=FetchType.LAZY,select="queryLabById"))
	})
	public List<Business> queryBusinessByPager(@Param("pager")Pager pager)throws Exception;
}
