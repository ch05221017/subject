package subject.vo;

import java.sql.Date;

public class CouponjspVO {
	private Integer couponserialnumber;	
	private String  couponname;
	private Date	startdate;
	private Date	enddate;
	private Float 	refundpercent;
	
	@Override
	public String toString() {
		return "CouponjspVO [couponserialnumber=" + couponserialnumber + ", couponname=" + couponname + ", startdate="
				+ startdate + ", enddate=" + enddate + ", refundpercent=" + refundpercent + "]";
	}

	public Integer getCouponserialnumber() {
		return couponserialnumber;
	}

	public void setCouponserialnumber(Integer couponserialnumber) {
		this.couponserialnumber = couponserialnumber;
	}

	public String getCouponname() {
		return couponname;
	}

	public void setCouponname(String couponname) {
		this.couponname = couponname;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Float getRefundpercent() {
		return refundpercent;
	}

	public void setRefundpercent(Float refundpercent) {
		this.refundpercent = refundpercent;
	}	

}
