package subject.service.impl;

import java.util.List;
import java.util.Set;

import subject.dao.Itemcatedao;
import subject.dao.Itemcatedaointerface;
import subject.vo.Itemcatevo;
import subject.vo.itemvo;

public class Itemcateservice {
	private Itemcatedaointerface dao;
	
	public Itemcateservice() {
		dao = new Itemcatedao();		
	}
	
	public List<Itemcatevo> getAll(){
		return dao.getAll();
	}
	
	public Itemcatevo getOneItemcate(String categoryno) {
		return dao.findByPrimaryKey(categoryno);		
	}
	
	public Set<itemvo> getItemByItemcate(String categoryno){
		return dao.getItemByCateno(categoryno);		
	}
	
	
	
	
	
	
	
	
	
	
	
}
