package subject.memberupdate.model;

public class MemberupdateVO implements java.io.Serializable{

	private Integer memberserialnumber;
	private String name;
	private String address;
	private String email;
	private String phone;
	@Override
	public String toString() {
		return "MemberupdateVO [memberserialnumber=" + memberserialnumber + ", name=" + name + ", address=" + address
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	public Integer getMemberserialnumber() {
		return memberserialnumber;
	}
	public void setMemberserialnumber(Integer memberserialnumber) {
		this.memberserialnumber = memberserialnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
}
