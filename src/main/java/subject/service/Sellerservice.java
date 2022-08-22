package subject.service;

import web.vo.Seller;

public interface Sellerservice {
	

	Integer sellerUpdate(Seller seller);
	
	Seller getsellerGetForUpdate(Integer serialnumber);

}