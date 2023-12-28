package Model;

import java.util.Date;
import java.util.Objects;

public class RegisterModel {
	private String ID;
	private String Name;
	private String Address;
	private int phonenumber;
	private int CCCD;
	private VehicleModel vehicleID;
	private String bienSoXE;
	private boolean loaixe;
	private String hangXe;
	private String mauSac;
	private Date ngaySinh;
	private String luaChon;
	
	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public RegisterModel() {
	}

	public RegisterModel(String iD, String name, String address, int phonenumber, int cCCD, VehicleModel vehicleID,
			String bienSoXE, boolean loaixe,String hangXe, String mauSac, Date ngaySinh) {
		super();
		ID = iD;
		Name = name;
		Address = address;
		this.phonenumber = phonenumber;
		CCCD = cCCD;
		this.vehicleID = vehicleID;
		this.bienSoXE = bienSoXE;
		this.loaixe = loaixe;
		this.hangXe = hangXe;
		this.mauSac = mauSac;
		this.ngaySinh = ngaySinh;
	}

	public boolean isLoaixe() {
		return loaixe;
	}
	
	public String getHangXe() {
		return hangXe;
	}

	public void setHangXe(String hangXe) {
		this.hangXe = hangXe;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public void setLoaixe(boolean loaixe) {
		this.loaixe = loaixe;
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

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getCCCD() {
		return CCCD;
	}

	public void setCCCD(int cCCD) {
		CCCD = cCCD;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	
	public VehicleModel getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(VehicleModel vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getBienSoXE() {
		return bienSoXE;
	}

	public void setBienSoXE(String bienSoXE) {
		this.bienSoXE = bienSoXE;
	}

	public String getMauSac() {
		return mauSac;
	}

	public void setMauSac(String mauSac) {
		this.mauSac = mauSac;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Address, CCCD, ID, Name, bienSoXE, hangXe, loaixe, mauSac, ngaySinh, phonenumber,
				vehicleID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisterModel other = (RegisterModel) obj;
		return Objects.equals(Address, other.Address) && CCCD == other.CCCD && Objects.equals(ID, other.ID)
				&& Objects.equals(Name, other.Name) && Objects.equals(bienSoXE, other.bienSoXE)
				&& Objects.equals(hangXe, other.hangXe) && loaixe == other.loaixe
				&& Objects.equals(mauSac, other.mauSac) && Objects.equals(ngaySinh, other.ngaySinh)
				&& phonenumber == other.phonenumber && Objects.equals(vehicleID, other.vehicleID);
	}

	@Override
	public String toString() {
		return "RegisterModel [ID=" + ID + ", Name=" + Name + ", Address=" + Address + ", phonenumber=" + phonenumber
				+ ", CCCD=" + CCCD + ", vehicleID=" + vehicleID + ", bienSoXE=" + bienSoXE + ", loaixe=" + loaixe
				+ ", hangXe=" + hangXe + ", mauSac=" + mauSac + ", ngaySinh=" + ngaySinh + "]";
	}

	
	


	



	
	
	
	

}