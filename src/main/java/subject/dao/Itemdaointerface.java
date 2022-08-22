package subject.dao;

import java.util.List;

import subject.vo.itemvo;

public interface Itemdaointerface {

	itemvo findByPrimaryKey(Integer serialnumber);

	List<itemvo> getAll();

	void insert(itemvo itemvo);

	void update(itemvo itemvo);

	void delete(Integer serialnumber);

}