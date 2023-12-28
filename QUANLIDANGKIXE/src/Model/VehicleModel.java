package Model;

import java.util.Objects;

public class VehicleModel {
	private String ID;
	private String Licenseplates;
	private String Brand;
	private String Color;
	private boolean Type;
	public VehicleModel() {
		
	}
	public VehicleModel(String iD, String licenseplates, String brand, String color, boolean type) {
		ID = iD;
		Licenseplates = licenseplates;
		Brand = brand;
		Color = color;
		Type = type;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getLicenseplates() {
		return Licenseplates;
	}
	public void setLicenseplates(String licenseplates) {
		Licenseplates = licenseplates;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public boolean isType() {
		return Type;
	}
	public void setType(boolean type) {
		Type = type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Brand, Color, ID, Licenseplates, Type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleModel other = (VehicleModel) obj;
		return Objects.equals(Brand, other.Brand) && Objects.equals(Color, other.Color) && Objects.equals(ID, other.ID)
				&& Objects.equals(Licenseplates, other.Licenseplates) && Type == other.Type;
	}
	@Override
	public String toString() {
		return "VehicleModel [ID=" + ID + ", Licenseplates=" + Licenseplates + ", Brand=" + Brand + ", Color=" + Color
				+ ", Type=" + Type + "]";
	}
}
	
	
	
