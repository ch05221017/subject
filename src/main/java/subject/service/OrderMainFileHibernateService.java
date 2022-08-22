package subject.service;

import java.util.List;

import suject.cart.Cart;
import suject.cart.Cartlist;

public interface OrderMainFileHibernateService {
	String orderMaininsert(String couponname, Cart cart, List<Cartlist> cartlist,Integer carttotal);
}