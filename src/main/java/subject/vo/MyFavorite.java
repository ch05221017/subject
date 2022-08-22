package subject.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_favorite")
public class MyFavorite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "my_favorite_number")
	private Integer myfavoritenumber;
	@Column(name = "item_serial_number")
	private Integer itemserialnumber;
	@Column(name = "member_serial_number")
	private Integer memberserialnumber;

	@Override
	public String toString() {
		return "MyFavorite [myfavoritenumber=" + myfavoritenumber + ", itemserialnumber=" + itemserialnumber
				+ ", memberserialnumber=" + memberserialnumber + "]";
	}

	public MyFavorite() {
	}

	public Integer getMyfavoritenumber() {
		return myfavoritenumber;
	}

	public void setMyfavoritenumber(Integer myfavoritenumber) {
		this.myfavoritenumber = myfavoritenumber;
	}

	public Integer getItemserialnumber() {
		return itemserialnumber;
	}

	public void setItemserialnumber(Integer itemserialnumber) {
		this.itemserialnumber = itemserialnumber;
	}

	public Integer getMemberserialnumber() {
		return memberserialnumber;
	}

	public void setMemberserialnumber(Integer memberserialnumber) {
		this.memberserialnumber = memberserialnumber;
	}

}
