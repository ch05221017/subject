package subject.dao.impl;

import web.vo.Seller;

public interface SellerUpdateDao {

	void updateseller(Seller seller);
	
	Seller selectByID(Integer serialnumber);

}