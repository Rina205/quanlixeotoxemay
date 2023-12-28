package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Model.RegisterModel;
import Test.main;

public class DangkiquanlixeView extends JFrame {
	public TrangChuView trangChuView;
	public RegisterModel registerModel;
	public JLabel jLabel_TenNguoi;
	public JTextField jtf_HoTen;
	public JLabel jLabel_NgaySinh;
	public JTextField jtf_NgaySinh;
	public JLabel jLabel_CCCD;
	public JTextField jtf_CCCD;
	public JLabel jLabel_Diachi;
	public JTextField jtf_Diachi;
	public JLabel jLabel_SDT;
	public JTextField jtf_SDT;
	public JLabel jLabel_BienSo;
	public JTextField jtf_BienSo;
	public JLabel jLabel_HangXe;
	public JTextField jtf_HangXe;
	public JLabel jLabel_MauSac;
	public JTextField jtf_MauSac;
	public JLabel jLabel_LoaiXe;
	public JLabel jLabel_KT;
	public ButtonGroup bt_loaixe;
	public JRadioButton jr_XeMay;
	public JRadioButton jr_OTO;
	public JButton jButton_Quaylai;
	public JButton jButton_Luu;
	public JLabel jLabel_id;
	public JTextField jtf_id;
	private AbstractButton jtb;

	public DangkiquanlixeView() {
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setTitle("Đăng kí quản lí xe");
		JLabel jLabel_Dki = new JLabel("Đăng kí quản lí xe", JLabel.CENTER);
		Font font = new Font("Arial", Font.BOLD, 30);
		jLabel_Dki.setFont(font);
		JPanel pn_Center = new JPanel();
		pn_Center.setLayout(new GridLayout(10, 2, 5, 5));
		 
		 jLabel_id = new JLabel("ID:", JLabel.RIGHT);
		 jtf_id = new JTextField(10);
		jLabel_TenNguoi = new JLabel("HỌ VÀ TÊN: ", JLabel.RIGHT);
		 jtf_HoTen = new JTextField(30);
		 jLabel_NgaySinh = new JLabel("NGÀY SINH:", JLabel.RIGHT);
		 jtf_NgaySinh = new JTextField(30);
		 jLabel_CCCD = new JLabel("CCCD:", JLabel.RIGHT);
		  jtf_CCCD = new JTextField(30);
		 jLabel_Diachi = new JLabel("ĐỊA CHỈ:", JLabel.RIGHT);
		 jtf_Diachi = new JTextField(30);
	     jLabel_SDT = new JLabel("SDT: ", JLabel.RIGHT);
		 jtf_SDT = new JTextField(30);
		 jLabel_BienSo = new JLabel("BIỂN SỐ: ", JLabel.RIGHT);
		 jtf_BienSo = new JTextField(30);
		 jLabel_HangXe = new JLabel("HÃNG XE:", JLabel.RIGHT);
		 jtf_HangXe = new JTextField(30);
		 jLabel_MauSac = new JLabel("MÀU SẮC: ", JLabel.RIGHT);
		 jtf_MauSac = new JTextField(30);
		JPanel jPanel_Loaixe = new JPanel();
		jPanel_Loaixe.setLayout(new FlowLayout());
		 jLabel_LoaiXe = new JLabel("LOẠI XE: ", JLabel.RIGHT);
		 jLabel_KT = new JLabel(" ");
		 bt_loaixe = new ButtonGroup();
		 jr_XeMay = new JRadioButton("Xe máy");
		 jr_OTO = new JRadioButton("Ô Tô");
		jPanel_Loaixe.add(jr_XeMay);
		jPanel_Loaixe.add(jr_OTO);
		bt_loaixe.add(jr_XeMay);
		bt_loaixe.add(jr_OTO);
		pn_Center.add(jLabel_id);
		pn_Center.add(jtf_id);
		pn_Center.add(jLabel_TenNguoi);
		pn_Center.add(jtf_HoTen);
		pn_Center.add(jLabel_NgaySinh);
		pn_Center.add(jtf_NgaySinh);
		pn_Center.add(jLabel_CCCD);
		pn_Center.add(jtf_CCCD);
		pn_Center.add(jLabel_SDT);
		pn_Center.add(jtf_SDT);
		pn_Center.add(jLabel_Diachi);
		pn_Center.add(jtf_Diachi);
		pn_Center.add(jLabel_BienSo);
		pn_Center.add(jtf_BienSo);
		pn_Center.add(jLabel_HangXe);
		pn_Center.add(jtf_HangXe);
		pn_Center.add(jLabel_MauSac);
		pn_Center.add(jtf_MauSac);
		pn_Center.add(jLabel_LoaiXe);
		pn_Center.add(jPanel_Loaixe);
		JLabel jLabel_East = new JLabel("               ");
//		pn_Center.add(jr_OTO);
//		pn_Center.add(jr_XeMay);
//		pn_Center.add(jLabel_TenNguoi);
//		pn_Center.add(jLabel_TenNguoi);
//		pn_Center.add(jLabel_TenNguoi);
		JPanel jPanel_South = new JPanel();
		jPanel_South.setLayout(new FlowLayout());
		 jButton_Luu = new JButton("Lưu");
		jButton_Luu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new TrangChuView();
			}
		});
		 jButton_Quaylai = new JButton("Quay lại");
		jPanel_South.add(jButton_Luu);
		jPanel_South.add(jButton_Quaylai);
		this.setLayout(new BorderLayout());
		this.add(pn_Center, BorderLayout.CENTER);
		this.add(jLabel_East, BorderLayout.EAST);
		this.add(jLabel_Dki, BorderLayout.NORTH);
		this.add(jPanel_South, BorderLayout.SOUTH);
		this.setVisible(true);

	}

	public void hienThiThongTinDangKiQuanLiXe(RegisterModel dkixe) {
		// TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel)jtb.getModel();
		//jtb.getSelectedRow();
	}
	

}
