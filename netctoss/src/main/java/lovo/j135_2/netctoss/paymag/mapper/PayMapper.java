package lovo.j135_2.netctoss.paymag.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import lovo.j135_2.netctoss.paymag.beans.PagePay;
import lovo.j135_2.netctoss.paymag.beans.Pay;

public interface PayMapper {

	/**
	 * 添加资费
	 * 
	 * @param pay
	 * @return
	 */
	@Insert(value = "insert into t_pay values(null,#{pay.payName},#{pay.payType},#{pay.payTime},#{pay.basicCost},#{pay.unitCost},#{pay.costDiscrip},#{pay.payStatus},#{pay.createTime})")
	public int addPay(@Param("pay")Pay pay) throws Exception;

	/**
	 * 删除资费
	 * 
	 * @param id
	 * @return
	 */
	@Delete(value="delete from t_pay where id=#{id}")
	public int deletePay(Long id) throws Exception;

	/**
	 * 更新资费内容
	 * 
	 * @param pay
	 * @return
	 * @throws Exception
	 */
	public int updatePay(@Param("pay")Pay pay) throws Exception;

	/**
	 * 修改资费状态
	 * 
	 * @param pay
	 * @return
	 * @throws Exception
	 */
	@Update(value="update t_pay set pay_status=#{pay.payStatus} where id=#{pay.id}")
	public int updatePayStatus(@Param("pay")Pay pay) throws Exception;

	/**
	 * 通过资费的开通时间来查找资费
	 * 
	 * @param dates
	 * @return 返回资费查找list
	 * @throws Exception
	 */
//	@Select(value="select * from t_pay where create_time between dates.get(0) and dates.get(1) limit pagePay.fromLine,pagePay.lines  ")
//	@Results({
//		@Result(id=true,property="id",column="id",javaType=Long.class),
//		@Result(property="payName",column="pay_name",javaType=String.class),
//		@Result(property="payType",column="pay_type",javaType=String.class),
//		@Result(property="payTime",column="pay_time",javaType=Integer.class),
//		@Result(property="basicCost",column="basic_cost",javaType=BigDecimal.class),
//		@Result(property="unitCost",column="unit_cost",javaType=BigDecimal.class),
//		@Result(property="costDiscrip",column="cost_discription",javaType=String.class),
//		@Result(property="payStatus",column="pay_status",javaType=Integer.class),
//		@Result(property="createTime",column="create_time",javaType=Date.class)
//	})
	public List<Pay> findPaysByTime(@Param("dates")List<Date> dates, @Param("pagePay")PagePay pagePay) throws Exception;

	/**
	 * 通过资费的开通时间来查找资费的总条数
	 * 
	 * @param dates
	 * @return
	 * @throws Exception
	 */
	
	public int findPayCountByTime(@Param("dates")List<Date> dates) throws Exception;
	
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
	public Pay findPayById(Long id) throws Exception;
	
	public Pay findPayWithBusinessById(@Param("id")Long id) throws Exception;
}
