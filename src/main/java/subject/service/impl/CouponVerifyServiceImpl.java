package subject.service.impl;

import subject.dao.CouponDao;
import subject.dao.CouponRecordDao;
import subject.dao.impl.CouponDaoImpl;
import subject.dao.impl.CouponRecordDaoImpl;
import subject.service.CouponVerifyService;
import subject.vo.Coupon;
import subject.vo.CouponRecord;

//用過coupon直接insert使用紀錄
public class CouponVerifyServiceImpl implements CouponVerifyService {
	private CouponDao couponDao;
	private CouponRecordDao couponRecordDao;
	Coupon coupon;

	public CouponVerifyServiceImpl() {
		couponDao = new CouponDaoImpl();
		couponRecordDao = new CouponRecordDaoImpl();
	}

	@Override
	public String Couponverify(String couponname) {
		if (couponname != null) {
			if (couponname.equals(couponDao.selectcouponname(couponname))) { // 如果輸入的名字=資料庫名字
				if (couponRecordDao.selectbyrecordpk(couponname, 1636001) == null) { // (應getMemberserialnumber())
					CouponRecord couponRecord = new CouponRecord(); // 如果使用狀態沒有紀錄,新增一筆紀錄
					couponRecord.setCouponserialnumber(couponDao.selectcouponserialnumber(couponname));
					couponRecord.setMemberserialnumber(1636001);
					couponRecord.setCouponrecordstatus(1);
					couponRecordDao.insert(couponRecord); // 新增到資料庫
					return "使用Coupon券成功，本次回饋數為" + String.valueOf(Couponrefundpercent(couponname));
				} else {
					return "此優惠券已被您使用";
				}
			}
			return "查無此優惠券";
		} else {
			return "請輸入優惠碼";
		}
	}

	@Override
	public Float Couponrefundpercent(String couponname) { // 用couponname呼叫selectcouporefundpercent查饋數
		Float refundpercent = couponDao.selectcouporefundpercent(couponname);
		return refundpercent;
	}

	@Override
	public String Couponnamestr(String couponname) { // 用couponname呼叫selectcouponname丟到前端
		String couponnamestr = couponDao.selectcouponname(couponname);
		return couponnamestr;
	}

}
