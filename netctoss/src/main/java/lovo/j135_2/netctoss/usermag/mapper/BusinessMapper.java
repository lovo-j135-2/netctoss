package lovo.j135_2.netctoss.usermag.mapper;

import java.math.BigDecimal;
import java.util.Date;
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
	public int deleteBusiness(Long id) throws Exception;
	/**
	 * 修改业务
	 * @param business
	 * @return
	 * @throws Exception
	 */
	@Update(value="update t_business set password=#{business.password} where id=#{business.id}")
	public int updateBusiness(@Param("business")Business business) throws Exception;
	/**
	 * 按业务账号查询业务
	 * @param name
	 * @return
	 * @throws Exception
	 */
	//@Select(value="select * from t_business where business_name=#{name}")
	@Select(value="SELECT * from t_business as b LEFT JOIN t_accountuser as a on b.fk_accountuser_id=a.id LEFT JOIN t_lab as lab on lab.id=b.fk_lab_id LEFT JOIN t_pay as p on b.fk_pay_id=p.id where business_name=#{name}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="business_name",column="business_name",javaType=String.class),
		@Result(property="password",column="password",javaType=String.class),
		@Result(property="fk_accountuser_id",column="fk_accountuser_id",javaType=AcconutUser.class,one=@One(select="queryAcconutUserById")),
		@Result(property="pay",column="fk_pay_id",javaType=Pay.class,one=@One(select="queryPayById")),
		@Result(property="lab",column="fk_lab_id",javaType=Lab.class,one=@One(select="queryLabById"))
	})
	public Business queryBusinessByName(String name) throws Exception;
	
	@Select(value="select * from t_accountuser where id=#{id}")
	@ResultType(AcconutUser.class)
	public AcconutUser queryAcconutUserById(int id) throws Exception;
	@Select(value="select * from t_pay where id=#{id}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="payName",column="pay_name",javaType=String.class),
		@Result(property="payType",column="pay_type",javaType=String.class),
		@Result(property="payTime",column="pay_time",javaType=Integer.class),
		@Result(property="basicCost",column="basic_cost",javaType=BigDecimal.class),
		@Result(property="unitCost",column="unit_cost",javaType=BigDecimal.class),
		@Result(property="costDiscrip",column="cost_discription",javaType=String.class),
		@Result(property="payStatus",column="pay_status",javaType=Integer.class),
		@Result(property="createTime",column="create_time",javaType=Date.class)
	})
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
	@Select(value="SELECT * from t_business as b LEFT JOIN t_accountuser as a on b.fk_accountuser_id=a.id LEFT JOIN t_lab as lab on lab.id=b.fk_lab_id LEFT JOIN t_pay as p on b.fk_pay_id=p.id limit #{pager.fromLine},#{pager.lines}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="business_name",column="business_name",javaType=String.class),
		@Result(property="password",column="password",javaType=String.class),
		@Result(property="fk_accountuser_id",column="fk_accountuser_id",javaType=AcconutUser.class,one=@One(select="queryAcconutUserById")),
		@Result(property="pay",column="fk_pay_id",javaType=Pay.class,one=@One(select="queryPayById")),
		@Result(property="lab",column="fk_lab_id",javaType=Lab.class,one=@One(select="queryLabById"))
	})
	
	public List<Business> queryBusinessByPager(@Param("pager")Pager pager)throws Exception;
	
	//public int countTotalRows()throws Exception;
	public Business findBusinessContainLabAndAccountAndPayByBusiId(@Param("id")Long id) throws Exception;
	@Select(value="select count(*) from t_business")
	@ResultType(Integer.class)
	public int countTotalBusiness()throws Exception;
	

	@Select(value="select id,business_name,fk_accountuser_id,fk_lab_id from t_business where id=#{id} and password=#{password}")
	@Results({
		@Result(id=true,property="id",column="id",javaType=Long.class),
		@Result(property="business_name",column="business_name",javaType=String.class),
		@Result(property="password",column="password",javaType=String.class),
		@Result(property="fk_accountuser_id",column="fk_accountuser_id",javaType=AcconutUser.class,one=@One(fetchType=FetchType.LAZY,select="queryAcconutUserById")),
		@Result(property="pay",column="pay",javaType=Pay.class,one=@One(fetchType=FetchType.LAZY,select="queryPayById")),
		@Result(property="lab",column="fk_lab_id",javaType=Lab.class,one=@One(fetchType=FetchType.LAZY,select="queryLabById"))
	})
	public Business findBusinessByIdAndPassword(@Param("id")Long id,@Param("password")String password) throws Exception;

	
}
