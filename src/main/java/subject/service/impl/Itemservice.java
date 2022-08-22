package subject.service.impl;


import java.util.List;
import subject.dao.Itemdaointerface;
import subject.dao.itemdao;
import subject.vo.itemvo;

public class Itemservice {
		private Itemdaointerface dao;
		public Itemservice() {
			dao = new itemdao();			
		}
		
		
		public itemvo getOneItem(Integer serialnumber) {
			return dao.findByPrimaryKey(serialnumber);
		}

		public List<itemvo> getAll() {			
			return dao.getAll();
		}
		

		public itemvo add(String name,String description,Integer price, Integer stock ,Integer sellID, String categoryno, byte[] photo) {

			itemvo itemvo = new itemvo();
			itemvo.setName(name);
			itemvo.setDescription(description);
			itemvo.setPrice(price);
			itemvo.setStock(stock);
			itemvo.setSellerserialnumber(sellID);
			itemvo.setCategoryno(categoryno);
			itemvo.setPhoto(photo);			
			dao.insert(itemvo);
			return itemvo;
		}
		
		public itemvo update(Integer serialnumber, String name,String description,Integer price, Integer stock,Integer sellID,  String categoryno, byte[] photo) {

			itemvo itemvo = new itemvo();
			itemvo.setSerialnumber(serialnumber);
			itemvo.setName(name);
			itemvo.setDescription(description);
			itemvo.setPrice(price);
			itemvo.setStock(stock);
			itemvo.setSellerserialnumber(sellID);
			itemvo.setCategoryno(categoryno);
			itemvo.setPhoto(photo);			
			dao.update(itemvo);
			return itemvo;
		}
		
		
		
		
		public void delete(Integer serialnumber) {
			dao.delete(serialnumber);
		}

		
		
}
