package suject.cart;

import java.util.List;

public class Cart {
	public List<Cartlist> cartlist;
	public String couponname;
	public Integer goldremaining;
	public Integer carttotal;
	
	@Override
	public String toString() {
		return "Cart [cartlist=" + cartlist + ", couponname=" + couponname + ", goldremaining=" + goldremaining + "]";
	}	
}
