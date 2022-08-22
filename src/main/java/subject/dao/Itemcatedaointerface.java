package subject.dao;

import java.util.List;
import java.util.Set;

import subject.vo.Itemcatevo;
import subject.vo.itemvo;

public interface Itemcatedaointerface {

	Itemcatevo findByPrimaryKey(String categoryno);

	List<Itemcatevo> getAll();

	Set<itemvo> getItemByCateno(String categoryno);

}