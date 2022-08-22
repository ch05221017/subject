package subject.vo;

import java.io.Serializable;

public class Itemcatevo implements Serializable{
	private String categoryno;
	private String mainname;
	
	public Itemcatevo(String categoryno, String mainname) {		
		this.categoryno = categoryno;
		this.mainname = mainname;
	}
	
	public Itemcatevo() {	
	}
	
	public String getCategoryno() {
		return categoryno;
	}
	public void setCategoryno(String categoryno) {
		this.categoryno = categoryno;
	}
	public String getMainname() {
		return mainname;
	}
	public void setMainname(String mainname) {
		this.mainname = mainname;
	}
	
	
	
	
	
}
