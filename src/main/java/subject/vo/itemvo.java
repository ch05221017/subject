package subject.vo;

import java.io.Serializable;

public class itemvo implements Serializable{
	private Integer serialnumber;
	private String name;
	private String description;
	private Integer price;
	private Integer stock;
	//賣家編號FK應該直接根據登入身分直接帶入(去session找)
	private Integer sellerserialnumber;
	private String categoryno;
	private byte[] photo;

	
	public itemvo(Integer serialnumber, String name, String description, Integer price, Integer stock,
			Integer sellerserialnumber, String categoryno, byte[] photo) {
		super();
		this.serialnumber = serialnumber;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.sellerserialnumber = sellerserialnumber;
		this.categoryno = categoryno;
		this.photo = photo;

	}
	
	public itemvo() {		
	}
	
	public Integer getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(Integer serialnumber) {
		this.serialnumber = serialnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getSellerserialnumber() {
		return sellerserialnumber;
	}
	public void setSellerserialnumber(Integer sellerserialnumber) {
		this.sellerserialnumber = sellerserialnumber;
	}
	public String getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(String categoryno) {
		this.categoryno = categoryno;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	
	
	
	

	

}

