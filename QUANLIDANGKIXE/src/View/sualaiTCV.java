package View;


	import java.awt.BorderLayout;
	import java.awt.FlowLayout;
	import java.awt.Font;
	import java.awt.HeadlessException;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
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
	import javax.swing.table.DefaultTableModel;

	import Controller.JDBC;
	import Controller.ManagementListener;
	import Model.ManagementVehicleModel;
	import Model.RegisterModel;

	public class sualaiTCV extends JFrame {
	    private DefaultTableModel model;
	    private JTable table;
	    private JScrollPane scrollPane;
	    private JDBC jdbcUtil = new JDBC();

	    public sualaiTCV(ManagementVehicleModel managementVehicleModel) throws HeadlessException {
	        this.init();
	    }

	     public sualaiTCV() {
			// TODO Auto-generated constructor stub
	     }

	    public void init() {
	    	Vector<String> columnNames = new Vector<>();
	        Vector<Vector<String>> data = new Vector<>();

	        try {
	            Connection connection = JDBC.getConnection();
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM Register");
	            ResultSetMetaData metaData = resultSet.getMetaData();
	            int columnCount = metaData.getColumnCount();

	            for (int i = 1; i <= columnCount; i++) {
	                columnNames.add(metaData.getColumnLabel(i));
	            }

	            while (resultSet.next()) {
	                Vector<String> row = new Vector<>();
	                for (int i = 1; i <= columnCount; i++) {
	                    row.add(resultSet.getString(i));
	                }
	                data.add(row);
	            }

	            JDBC.closeConnection(connection);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        model = new DefaultTableModel(data, columnNames);
	        table = new JTable(model);
	        scrollPane = new JScrollPane(table);

	        setTitle("Quản lí đăng kí xe");
	        setSize(600, 600);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JMenuBar menuBar = new JMenuBar();
	        JMenu menuQuanLiXe = new JMenu("Quản lí xe");
	        JMenuItem menuItemDangKiQuanLiXe = new JMenuItem("Đăng kí quản lí xe");
	        menuQuanLiXe.add(menuItemDangKiQuanLiXe);
	        menuBar.add(menuQuanLiXe);
	        setJMenuBar(menuBar);

	        JPanel panel = new JPanel();
	        JLabel labelThongTinQuanLiXe = new JLabel("Thông tin quản lí xe", JLabel.CENTER);
	        Font font = new Font("Arial", Font.BOLD, 30);
	        labelThongTinQuanLiXe.setFont(font);

	        JPanel panelSouth = new JPanel();
	        panelSouth.setLayout(new FlowLayout());

	        JButton buttonThem = new JButton("Thêm");
	        buttonThem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // TODO: Implement add button logic
	            }
	        });

	        JButton buttonSua = new JButton("Sửa");
	        buttonSua.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // TODO: Implement edit button logic
	            }
	        });

	        JButton buttonXoa = new JButton("Xóa");
	        buttonXoa.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // TODO: Implement delete button logic
	            }
	        });

	        JButton buttonTimKiem = new JButton("Tìm kiếm");
	        buttonTimKiem.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // TODO: Implement search button logic
	            }
	        });

	        JButton buttonLuu = new JButton("Lưu");
	        buttonLuu.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // TODO: Implement save button logic
	            }
	        });

	        panelSouth.add(buttonThem);
	        panelSouth.add(buttonXoa);
	        panelSouth.add(buttonSua);
	        panelSouth.add(buttonTimKiem);
	        panelSouth.add(buttonLuu);

	        setLayout(new BorderLayout());
	        add(labelThongTinQuanLiXe, BorderLayout.NORTH);
	        add(panelSouth, BorderLayout.SOUTH);
	        add(scrollPane, BorderLayout.CENTER);

	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                sualaiTCV view = new sualaiTCV();
	                view.setSize(600, 600);
	                view.setVisible(true);
	            }
	        });
	    }
	}

