package web.vo;

import java.io.Serializable;
import java.util.Date;

public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer serialnumber;
	private String account;
	private String password;
	private String name;
	private String idnumber;
	private String email;
	private String holder;
	private String holderid;
	private String phone;
	private String mainaddress;
	private String branchaddress;
	private String description;
	private Date revisedate;
	private Integer quantity;
	private Integer stars;
	
	
	
	@Override
	public String toString() {
		return "Seller [serialnumber=" + serialnumber + ", account=" + account + ", password=" + password + ", name="
				+ name + ", idnumber=" + idnumber + ", email=" + email + ", holder=" + holder + ", holderid=" + holderid
				+ ", phone=" + phone + ", mainaddress=" + mainaddress + ", branchaddress=" + branchaddress
				+ ", description=" + description + ", revisedate=" + revisedate + ", quantity=" + quantity + ", stars="
				+ stars + "]";
	}

	public Seller() {
		
	}

	public Seller(Integer serialnumber, String account, String password, String name, String idnumber, String email,
			String holder, String holderid, String phone, String mainaddress, String branchaddress, String description,
			Date revisedate, Integer quantity, Integer stars) {
		super();
		this.serialnumber = serialnumber;
		this.account = account;
		this.password = password;
		this.name = name;
		this.idnumber = idnumber;
		this.email = email;
		this.holder = holder;
		this.holderid = holderid;
		this.phone = phone;
		this.mainaddress = mainaddress;
		this.branchaddress = branchaddress;
		this.description = description;
		this.revisedate = revisedate;
		this.quantity = quantity;
		this.stars = stars;
	}

	public Integer getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(Integer serialnumber) {
		this.serialnumber = serialnumber;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getHolderid() {
		return holderid;
	}

	public void setHolderid(String holderid) {
		this.holderid = holderid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMainaddress() {
		return mainaddress;
	}

	public void setMainaddress(String mainaddress) {
		this.mainaddress = mainaddress;
	}

	public String getBranchaddress() {
		return branchaddress;
	}

	public void setBranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRevisedate() {
		return revisedate;
	}

	public void setRevisedate(Date revisedate) {
		this.revisedate = revisedate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	
	
	
	
	
	
	
	
}

//`SELLER_SERIAL_NUMBER` INT NOT NULL primary key,
//`COMPANY_NAME` VARCHAR(25) CHARACTER SET 'utf8' NOT NULL,
//`COMPANY_MEMBER_ACCOUNT` VARCHAR(25) NOT NULL,
//`COMPANY_MEMBER_PASSWORD` VARCHAR(25) NOT NULL,
//`ID_NUMBER` CHAR(8) NOT NULL,
//`SELLER_EMAIL` VARCHAR(60) NOT NULL,
//`COMPANY_HOLDER` VARCHAR(10) CHARACTER SET 'utf8' NOT NULL,
//`COMPANY_HOLDER_ID` VARCHAR(10) NOT NULL,
//`SELLER_PHONE_NUMBER` VARCHAR(10) NOT NULL,
//`SELLER_MAIN_ADDRESS` VARCHAR(60) CHARACTER SET 'utf8' NOT NULL,
//`SELLER_BRANCH_ADDRESS` VARCHAR(60) CHARACTER SET 'utf8' NOT NULL,
//`STORE_DESCRIPTION` LONGTEXT NOT NULL,
//`ADMINISTRATOR_REVISE_DATE` DATE NOT NULL,
//`SELLER_EVALUATE_QUANTITY` INT NOT NULL,
//`SELLER_EVALUATE_STARS` INT NOT NULL);