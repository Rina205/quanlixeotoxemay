package Model;

import java.util.ArrayList;

public class ManagementVehicleModel {
	
		private ArrayList<RegisterModel> managementRegister;
		private String LuaChon ;

		public ManagementVehicleModel() {
			this.managementRegister = new ArrayList<RegisterModel>();
			this.LuaChon = "";
	     
		}

		public String getLuaChon() {
			return LuaChon;
		}

		public void setLuaChon(String LuaChon) {
			this.LuaChon = LuaChon;
		}

		public ManagementVehicleModel(ArrayList<RegisterModel> managementRegister) {
			this.managementRegister = managementRegister;
		}

		public ArrayList<RegisterModel> getManagementRegister() {
			return managementRegister;
		}

		public void setManagementRegister(ArrayList<RegisterModel> managementRegister) {
			this.managementRegister = managementRegister;
		}
		public void them(RegisterModel managementRegister) {
			this.managementRegister.add(managementRegister);
		}
		public void xoa(RegisterModel managementRegister) {
			this.managementRegister.remove(managementRegister);
		}
		public void sua(RegisterModel managementRegister) {
			this.managementRegister.remove(managementRegister);
			this.managementRegister.add(managementRegister);
		}

		public boolean kiemTraTonTai(RegisterModel dkixe) {
			
				for(RegisterModel registerModel : managementRegister) {
					if(registerModel.getID() == dkixe.getID())
						return true;
				}
				return false;
			
			
		}

	
		
		
		

	}


