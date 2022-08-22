package web.vo;

import java.io.Serializable;
import java.sql.Date;


public class Member implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer memberserialnumber;
	private String account;
	private String password;
	private String name;
	private Date birthday;
	private String address;
	private String email;
	private String phone;
	private Boolean status;
	private Integer goldremaining;
	private Integer quantity;
	private Integer stars;
	

	@Override
	public String toString() {
		return "Member [memberserialnumber=" + memberserialnumber + ", account=" + account + ", password=" + password
				+ ", name=" + name + ", birthday=" + birthday + ", address=" + address + ", email=" + email + ", phone="
				+ phone + ", status=" + status + ", goldremaining=" + goldremaining + ", quantity=" + quantity
				+ ", stars=" + stars + "]";
	}


	public Member() {
		
	}


	public Member(Integer memberserialnumber, String account, String password, String name, Date birthday,
			String address, String email, String phone, Boolean status, Integer goldremaining, Integer quantity,
			Integer stars) {
		super();
		this.memberserialnumber = memberserialnumber;
		this.account = account;
		this.password = password;
		this.name = name;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.goldremaining = goldremaining;
		this.quantity = quantity;
		this.stars = stars;
	}


	public Integer getMemberserialnumber() {
		return memberserialnumber;
	}


	public void setMemberserialnumber(Integer memberserialnumber) {
		this.memberserialnumber = memberserialnumber;
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


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	public Integer getGoldremaining() {
		return goldremaining;
	}


	public void setGoldremaining(Integer goldremaining) {
		this.goldremaining = goldremaining;
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
	
	
	
	
	

//`MEMBER_SERIAL_NUMBER` INT NOT NULL primary key,
//`MEMBER_ACCOUNT` VARCHAR(25) NOT NULL,
//`MEMBER_PASSWORD` VARCHAR(25) NOT NULL,
//`MEMBER_NAME` VARCHAR(30) CHARACTER SET 'utf8' NOT NULL,
//`MEMBER_BIRTHDAY` DATE NOT NULL,
//`MEMBER_ADDRESS` VARCHAR(60) CHARACTER SET 'utf8' NOT NULL,
//`MEMBER_EMAIL` VARCHAR(60) NOT NULL,
//`MEMBER_PHONE_NUMBER` VARCHAR(10) NOT NULL,
//`MEMBER_STATUS` TINYINT NOT NULL,
//`GOLD_REMAINING` INT NOT NULL,
//`MEMBER_EVALUATE_QUANTITY` INT NOT NULL,
//`MEMBER_EVALUATE_STARS` INT NOT NULL);