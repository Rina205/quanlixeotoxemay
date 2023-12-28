package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import Controller.JDBC;
import Controller.ManagementListener;
import Model.ManagementVehicleModel;
import Model.RegisterModel;
import Test.main;

public class TrangChuView extends JFrame {
//	public static void main(String[] args) {
//		TrangChuView view = new TrangChuView();
//		view.setVisible(true);
//		view.setSize(400,400);
		
	//}
	public  ManagementVehicleModel managementVehicleModel;
	public DangkiquanlixeView dangkiquanlixeView;
	public Vector vData;
	public Vector vTitle;
	ResultSet rs;
	int Collum = 0;
	ResultSetMetaData rss = null;
	private DefaultTableModel df;
	private JTable jtb;
	private JScrollPane tb;
	private DefaultTableModel model_table;
	private JDBC jdbcUtil = new JDBC();
	private RegisterModel dkixe2;
	private Date ngaySinh;
	public TrangChuView(ManagementVehicleModel managementVehicleModel) throws HeadlessException {
		
		this.managementVehicleModel = managementVehicleModel;
		this.init();
	
	}
	public TrangChuView() {
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		try {
			rs = jdbcUtil.stm.executeQuery("SELECT * FROM Register");
			rss = (ResultSetMetaData)rs.getMetaData();
			Collum = rss.getColumnCount();
			vTitle = new Vector(Collum);
			for(int i= 1; i<= Collum; i++) {
				vTitle.add(rss.getColumnLabel(i));
			}
			vData = new Vector(10, 10);
			while(rs.next()) {
				Vector row = new Vector(Collum);
				for (int i = 1; i<= Collum; i++) {
					row.add(rs.getString(i));
				vData.add(row); 
				}
			}
		
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		df = new DefaultTableModel(vData, vTitle);
		jtb = new JTable(df);
		 
		tb = new JScrollPane(jtb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//ActionListener actionListener = new ManagementListener(this);
		
		this.setTitle("Quản lí đăng kí xe");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar jMenuBar = new JMenuBar();
		JMenu menuqlixe = new JMenu("Quản lí xe");
		JMenuItem jMenuItem_dkqlx = new JMenuItem("Đăng kí quản lí xe");
		jMenuBar.add(menuqlixe);
		menuqlixe.add(jMenuItem_dkqlx);
		this.setJMenuBar(jMenuBar);
		JPanel jPanel = new JPanel();
		JLabel jLabel_ThongTinQuanLiXe = new JLabel("Thong tin quan li xe", JLabel.CENTER);
		Font font = new Font("Arial", Font.BOLD, 30);
		jLabel_ThongTinQuanLiXe.setFont(font);
		JPanel jPanel_South = new JPanel();
		jPanel_South.setLayout(new FlowLayout());
		JButton bt_them = new JButton("Thêm");
		bt_them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
		JButton bt_sua = new JButton("Sửa");
		bt_sua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JButton bt_xoa = new JButton("Xóa");
		bt_xoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JButton bt_timkiem = new JButton("Tìm kiếm");
		bt_timkiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JButton bt_luu = new JButton("Lưu");
		bt_luu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jPanel_South.add(bt_them);
		jPanel_South.add(bt_xoa);
		jPanel_South.add(bt_sua);
		jPanel_South.add(bt_timkiem);
		jPanel_South.add(bt_luu);
		this.setLayout(new BorderLayout());
		this.add(jLabel_ThongTinQuanLiXe, BorderLayout.NORTH);
		this.add(jPanel_South, BorderLayout.SOUTH);
		this.add(tb, BorderLayout.CENTER);
		this.setVisible(true);
		
	}
	public void themhoacsuadkixe(RegisterModel dkixe) {
		if(!this.managementVehicleModel.kiemTraTonTai(dkixe)) {
			this.managementVehicleModel.them(dkixe);
			this.themDangKiQuanLiXeVaoTable(dkixe);
		}
		else {
			this.managementVehicleModel.sua(dkixe);
			int soLuongDong = model_table.getRowCount();
			for(int i= 0; i<soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0) + "";
				if (id.equals(dkixe.getID() + "")) {
					model_table.setValueAt(dkixe.getID() + "", i, 0);
					model_table.setValueAt(dkixe.getName() + "", i, 1);
					model_table.setValueAt(dkixe.getAddress()+ "", i, 2);
					model_table.setValueAt(dkixe.getNgaySinh().getDate() + "/" + (dkixe.getNgaySinh().getMonth() + 1) + "/"
							+ (dkixe.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt(dkixe.getPhonenumber() +"", i, 4);
					model_table.setValueAt(dkixe.getCCCD() + "", i, 5);
					model_table.setValueAt(dkixe.getBienSoXE() + "", i, 6);
					model_table.setValueAt(dkixe.getHangXe() + "", i, 7);
					model_table.setValueAt(dkixe.getMauSac() + "", i, 8);
					model_table.setValueAt((dkixe.isLoaixe() ? "Xe máy" : "Ô tô"), i, 9);
				}
			}
		}
	}
		
		
	private void themDangKiQuanLiXeVaoTable(RegisterModel dkixe) {
		// TODO Auto-generated method stub
		
	}
	public void hienThiThongTinDangKiQuanLiXe(RegisterModel dkixe) {
		// TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel)jtb.getModel();
		int i_row = jtb.getSelectedRow();
		String id = model_table.getValueAt(i_row, 0)+"";
		String ten = model_table.getValueAt(i_row, 1)+"";
		String diaChi = model_table.getValueAt(i_row, 2)+"";
		int soDienThoai = Integer.valueOf(model_table.getValueAt(i_row, 3)+"");
		int cccd = Integer.valueOf(model_table.getValueAt(i_row, 4)+"");
		String textLoaiXe = model_table.getValueAt(i_row, 5)+"";
		boolean loaiXe =textLoaiXe.equals("Xe máy ") ;
		String bienSo = model_table.getValueAt(i_row,7 )+"";
		String mauSac = model_table.getValueAt(i_row, 8)+"";
		
		this.dangkiquanlixeView.jtf_id.setText(id+"");
		this.dangkiquanlixeView.jtf_HoTen.setText(ten+"");
		this.dangkiquanlixeView.jtf_Diachi.setText(diaChi+"");
		this.dangkiquanlixeView.jtf_SDT.setText(soDienThoai+"");
		this.dangkiquanlixeView.jtf_CCCD.setText(cccd+"");
		if(loaiXe) {
			this.dangkiquanlixeView.jr_XeMay.setSelected(true);
		}
		else {
			this.dangkiquanlixeView.jr_OTO.setSelected(true);
		}
		this.dangkiquanlixeView.jtf_BienSo.setText(bienSo+"");
		this.dangkiquanlixeView.jtf_MauSac.setText(mauSac+"");
		
		
		
	}
	public void themdkixe(RegisterModel dkixe) {
		// TODO Auto-generated method stub
		
	}
	public void suadkixe(RegisterModel dkixe) {
		// TODO Auto-generated method stub
		
	}
	public void thuchienxoa(RegisterModel dkixe) {
		// TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel)jtb.getModel();
		int i_row = jtb.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắn chắn xóa dòng đã chọn?");
		if(luaChon == JOptionPane.YES_OPTION) {
					RegisterModel dkixe2 = getThiSinhDangChon();
					this.managementVehicleModel.xoa(dkixe);
					model_table.removeRow(i_row);
				}

			}
	private RegisterModel getThiSinhDangChon() {
		// TODO Auto-generated method stub
		
		DefaultTableModel model_table = (DefaultTableModel)jtb.getModel();
		int i_row = jtb.getSelectedRow();
		String id = model_table.getValueAt(i_row, 0)+"";
		String ten = model_table.getValueAt(i_row, 1)+"";
		String diaChi = model_table.getValueAt(i_row, 2)+"";
		int soDienThoai = Integer.valueOf(model_table.getValueAt(i_row, 3)+"");
		int cccd = Integer.valueOf(model_table.getValueAt(i_row, 4)+"");
		String textLoaiXe = model_table.getValueAt(i_row, 5)+"";
		boolean loaiXe =textLoaiXe.equals("Xe máy ") ;
		String bienSo = model_table.getValueAt(i_row,7 )+"";
		String mauSac = model_table.getValueAt(i_row, 8)+"";
		RegisterModel dkixe2 = new RegisterModel(id, diaChi, textLoaiXe, soDienThoai, cccd, null, bienSo, loaiXe, bienSo, mauSac, ngaySinh);
		return dkixe2;
		
		
	}
		public static void main(String[] args) {
			new TrangChuView();
		}
		
	}

		        

