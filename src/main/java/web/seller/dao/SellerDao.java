package web.seller.dao;

import web.vo.Seller;

public interface SellerDao {

	int insert(Seller seller);

	Integer delete(Seller seller);

	Seller selectForLogin(Seller seller);

	Seller selectEmail(Seller seller);

	Integer updatePassword(Seller seller);

	Seller selectAccount(Seller seller);

}