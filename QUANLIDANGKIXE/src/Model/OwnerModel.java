package Model;

import java.util.ArrayList;
import java.util.Objects;

public class OwnerModel {
	private String ID;
	private String Name;
	private String Address;
	private String Phonenumber;
	public OwnerModel(int i, String tenTinh) {

	}
	public OwnerModel(String iD, String name, String address, String phonenumber) {
		ID = iD;
		Name = name;
		Address = address;
		Phonenumber = phonenumber;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhonenumber() {
		return Phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Address, ID, Name, Phonenumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OwnerModel other = (OwnerModel) obj;
		return Objects.equals(Address, other.Address) && Objects.equals(ID, other.ID)
				&& Objects.equals(Name, other.Name) && Objects.equals(Phonenumber, other.Phonenumber);
	}
	@Override
	public String toString() {
		return "OwnerModle [ID=" + ID + ", Name=" + Name + ", Address=" + Address + ", Phonenumber=" + Phonenumber
				+ "]";
	}
	public static ArrayList<OwnerModel> getDSTinh(){
		String[] arr_tinh = {"An Giang",
							"Bà Rịa – Vũng Tàu",
							"Bạc Liêu",
							"Bắc Giang",
							"Bắc Kạn",
							"Bắc Ninh",
							"Bến Tre",
							"Bình Dương",
							"Bình Định",
							"Bình Phước",
							"Bình Thuận",
							"Cà Mau",
							"Cao Bằng",
							"Cần Thơ",
							"Đà Nẵng",
							"Đắk Lắk",
							"Đắk Nông",
							"Điện Biên",
							"Đồng Nai",
							"Đồng Tháp",
							"Gia Lai",
							"Hà Giang",
							"Hà Nam",
							"Hà Nội",
							"Hà Tĩnh",
							"Hải Dương",
							"Hải Phòng",
							"Hậu Giang",
							"Hòa Bình",
							"Thành phố Hồ Chí Minh",
							"Hưng Yên",
							"Khánh Hòa",
							"Kiên Giang",
							"Kon Tum",
							"Lai Châu",
							"Lạng Sơn",
							"Lào Cai",
							"Lâm Đồng",
							"Long An",
							"Nam Định",
							"Nghệ An",
							"Ninh Bình",
							"Ninh Thuận",
							"Phú Thọ",
							"Phú Yên",
							"Quảng Bình",
							"Quảng Nam",
							"Quảng Ngãi",
							"Quảng Ninh",
							"Quảng Trị",
							"Sóc Trăng",
							"Sơn La",
							"Tây Ninh",
							"Thái Bình",
							"Thái Nguyên",
							"Thanh Hóa",
							"Thừa Thiên Huế",
							"Tiền Giang",
							"Trà Vinh",
							"Tuyên Quang",
							"Vĩnh Long",
							"Vĩnh Phúc",
							"Yên Bái"};
		

		ArrayList<OwnerModel> listTinh = new ArrayList();
		int i = 0;
		for (String tenTinh : arr_tinh) {
			OwnerModel t = new OwnerModel(i, tenTinh);
			listTinh.add(t);
		}
		return listTinh;
	}
	
	

}