package subject.dao;

import java.util.List;

import subject.vo.CouponRecord;

public interface CouponRecordDao {

//	//insert方法
	CouponRecord insert(CouponRecord couponRecord);
	//select方法
//	List<Integer> selectbyrecordpk(Integer couponserialnumber,Integer memberserialnumber);
	Integer selectbyrecordpk(String couponname,Integer memberserialnumber);

}