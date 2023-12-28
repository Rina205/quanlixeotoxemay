package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import Model.RegisterModel;
import Model.VehicleModel;
import View.DangkiquanlixeView;
import View.TrangChuView;

public class ManagementListener implements ActionListener{
	private TrangChuView trangChuView;
	private DangkiquanlixeView dangkiquanlixeView;
	private RegisterModel dkixe;

	

	public ManagementListener(TrangChuView trangChuView) {
		this.trangChuView = trangChuView;
		this.dangkiquanlixeView = dangkiquanlixeView;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cm = e.getActionCommand();
		JOptionPane.showMessageDialog(trangChuView,"Bạn đã chọn"+ cm );
		if(cm.equals("Thêm")) {
			this.trangChuView.managementVehicleModel.setLuaChon("Thêm");
			
		}
		else if(cm.equals("Lưu")) {
			try {
				String id = this.dangkiquanlixeView.jtf_id.getText();
				String ten = this.dangkiquanlixeView.jtf_HoTen.getText();
				String diaChi = this.dangkiquanlixeView.jtf_Diachi.getText();
				int soDienThoai = Integer.valueOf(this.dangkiquanlixeView.jtf_SDT.getText());
				int cccd = Integer.valueOf(this.dangkiquanlixeView.jtf_CCCD.getText());
				Date ngaySinh = new Date(this.dangkiquanlixeView.jtf_NgaySinh.getText());  
				boolean loaiXe = true;
				String chonLoaiXe = this.dangkiquanlixeView.bt_loaixe.getSelection()+"";
				if(chonLoaiXe.equals("Xe máy")) {
					loaiXe = true;
				}else if(chonLoaiXe.equals("Ô tô ")) {
					loaiXe = false;
				}
			
				String bienSo = this.dangkiquanlixeView.jLabel_BienSo.getText();
				String hangXe = this.dangkiquanlixeView.jtf_HangXe.getText();
				String mauSac = this.dangkiquanlixeView.jLabel_MauSac.getText();
				RegisterModel dkixe = new RegisterModel(id, diaChi, chonLoaiXe, soDienThoai, cccd, null, bienSo, loaiXe, hangXe, mauSac, ngaySinh);
 				this.trangChuView.themhoacsuadkixe(dkixe);
			
			if(this.trangChuView.managementVehicleModel.getLuaChon().equals("")||this.trangChuView.managementVehicleModel.getLuaChon().equals("Thêm")) {
				this.trangChuView.themdkixe(dkixe);
			}
		     else if( this.trangChuView.managementVehicleModel.getLuaChon().equals("Sửa")) {
				this.trangChuView.suadkixe(dkixe);
			}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			else if (cm.equals("Sửa")) {
				this.trangChuView.hienThiThongTinDangKiQuanLiXe(dkixe);
			}else if (cm.equals("Xoá")) {
				this.trangChuView.thuchienxoa(dkixe);
			}
		
		
		}
	}

			
			
		
	
	


