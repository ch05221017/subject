package subject.dao;

import java.io.Serializable;

import subject.vo.OrderDetailHibernate;

public interface OrderDetailDao {

	Serializable insert(OrderDetailHibernate vo);

}