package Tuan01.Bai03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class CongTruNhanChia extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton btnGiai, btnXoa, btnThoat, btnDo, btnXanh, btnVang;
	JLabel lbNhapA, lbNhapB, lbKetQua, lbTieuDe;
	JTextField tfNhapA, tfNhapB, tfKetQua;
	JRadioButton rbCong, rbTru, rbNhan, rbChia;
	
//======================Giao-Dien======================
	public CongTruNhanChia () {
		//======JFrame======
		this.setTitle("Cộng - Trừ - Nhân - Chia");
		this.setSize(500, 400);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setLayout(new BorderLayout());
		
		//======JPanel-North======
		JPanel pnNorth = new JPanel();
		this.add(pnNorth, BorderLayout.NORTH);
		
		lbTieuDe = new JLabel("Cộng Trừ Nhân Chia");
		lbTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		lbTieuDe.setForeground(Color.blue);
		
		pnNorth.add(lbTieuDe);
		
		//======JPanel-West======
		JPanel pnWest = new JPanel();
		JPanel pnBtnWest = new JPanel();
		
		pnBtnWest.setBackground(Color.LIGHT_GRAY);
		pnBtnWest.setLayout(new BoxLayout(pnBtnWest, BoxLayout.Y_AXIS));
		
		pnWest.setBackground(Color.LIGHT_GRAY);
		pnBtnWest.setLayout(new GridLayout(3, 1, 5, 10));
		pnWest.setPreferredSize(new Dimension(100, 0));
		this.add(pnWest, BorderLayout.WEST);
		
		pnBtnWest.add(btnGiai = new JButton("Giải"));
		pnBtnWest.add(btnXoa = new JButton("Xóa"));
		pnBtnWest.add(btnThoat = new JButton("Thoát"));
		
		pnWest.add(pnBtnWest, BorderLayout.NORTH);
		
		Border bdChonTacVu = BorderFactory.createLineBorder(Color.blue);
		TitledBorder ttlbdChonTacVu = BorderFactory.createTitledBorder(bdChonTacVu, "Chọn tác vụ");
		
		pnWest.setBorder(ttlbdChonTacVu);
		
		//======Panel-South======
		JPanel pnSouth = new JPanel();
		JPanel pnBtnSouth = new JPanel();
		
		pnBtnSouth.setPreferredSize(new Dimension(120, 30));
		pnBtnSouth.setLayout(new GridLayout(1, 3, 10, 0));
		
		pnBtnSouth.setBackground(Color.pink);
		
		pnBtnSouth.add(btnXanh = new JButton());
		pnBtnSouth.add(btnDo = new JButton());
		pnBtnSouth.add(btnVang = new JButton());
		
		btnDo.setBackground(Color.red);
		btnXanh.setBackground(Color.blue);
		btnVang.setBackground(Color.yellow);
		
		this.add(pnSouth, BorderLayout.SOUTH);
		pnSouth.add(pnBtnSouth, BorderLayout.NORTH);
		
		pnSouth.setPreferredSize(new Dimension(0, 70));
		pnSouth.setBackground(Color.pink);
		
		//======Panel-Center======
		JPanel pnCenter = new JPanel();
		JPanel pnCenter_North = new JPanel();
		JPanel pnCenter_Center = new JPanel();
		JPanel pnCenter_South = new JPanel();
		
		pnCenter.setLayout(new BorderLayout());
		
		pnCenter.add(pnCenter_North, BorderLayout.NORTH);
		pnCenter.add(pnCenter_Center, BorderLayout.CENTER);
		pnCenter.add(pnCenter_South, BorderLayout.SOUTH);
		
		this.add(pnCenter, BorderLayout.CENTER);
		
		//======Panel-Center_South======
		pnCenter_South.setPreferredSize(new Dimension(0, 50));
		pnCenter_South.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
		
		pnCenter_South.add(lbKetQua = new JLabel("Kết quả:"));
		pnCenter_South.add(tfKetQua = new JTextField(27));
		
		tfKetQua.setEditable(false);
		
		//======Panel-Center_North======
		pnCenter_North.setPreferredSize(new Dimension(10, 80));
		pnCenter_North.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		pnCenter_North.add(lbNhapA = new JLabel("Nhập a:"));
		pnCenter_North.add(tfNhapA = new JTextField(28));
		pnCenter_North.add(lbNhapB = new JLabel("Nhập b:"));
		pnCenter_North.add(tfNhapB = new JTextField(28));
		
		Border brdTinhToan = BorderFactory.createLineBorder(Color.blue);
		TitledBorder ttlBrdTinhToan = BorderFactory.createTitledBorder(brdTinhToan, "Tính toán");
		
		pnCenter.setBorder(ttlBrdTinhToan);
		//======Panel-Center_Center======
		pnCenter_Center.setPreferredSize(new Dimension(0, 100));
		pnCenter_Center.setBackground(Color.yellow);
		pnCenter_Center.setLayout(new BorderLayout());
		
		JPanel pnCenter_Center_Center = new JPanel();
		pnCenter_Center.add(pnCenter_Center_Center, BorderLayout.CENTER);
		
		JPanel pnCenter_Center_West = new JPanel();
		pnCenter_Center.add(pnCenter_Center_West, BorderLayout.WEST);
		pnCenter_Center_West.setPreferredSize(new Dimension(72, 0));
		
		JPanel pnCenter_Center_East = new JPanel();
		pnCenter_Center.add(pnCenter_Center_East, BorderLayout.EAST);
		pnCenter_Center_East.setPreferredSize(new Dimension(22, 0));
		
		Border brdPhepToan = BorderFactory.createLineBorder(Color.blue);
		TitledBorder ttlBrdPhepToan = BorderFactory.createTitledBorder(brdPhepToan, "Phép toán");
		
		pnCenter_Center_Center.setBorder(ttlBrdPhepToan);
		
		pnCenter_Center_Center.setLayout(new GridLayout(2, 2));
		
		rbCong = new JRadioButton("Cộng");
		rbTru = new JRadioButton("Trừ");
		rbNhan = new JRadioButton("Nhân");
		rbChia = new JRadioButton("Chia");
		
		ButtonGroup btnGrp = new ButtonGroup();
		
		btnGrp.add(rbCong);
		btnGrp.add(rbTru);
		btnGrp.add(rbNhan);
		btnGrp.add(rbChia);
		
		rbCong.setSelected(true);
		
		pnCenter_Center_Center.add(rbCong);
		pnCenter_Center_Center.add(rbTru);
		pnCenter_Center_Center.add(rbNhan);
		pnCenter_Center_Center.add(rbChia);
		
		//======Dang-ky-su-kien======
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
		btnDo.addActionListener(this);
		btnXanh.addActionListener(this);
		btnVang.addActionListener(this);
	
	}
//======================Chuc-Nang======================

@Override
	public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	
	//======Thoat======
	if(o.equals(btnThoat)) {
		int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?", "Hỏi", JOptionPane.YES_NO_OPTION);
		if(choice == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	//======Xoa======
	else if(o.equals(btnXoa)) {
		tfNhapA.setText("");
		tfNhapB.setText("");
		tfKetQua.setText("");
		tfNhapA.requestFocus(); 
	}
	
	//======Doi-mau======
	else if(o.equals(btnXanh)) {
		lbTieuDe.setForeground(Color.BLUE);
	} else if(o.equals(btnDo)) {
		lbTieuDe.setForeground(Color.RED);
	} else if(o.equals(btnVang)) {
		lbTieuDe.setForeground(Color.YELLOW);
	}
	
	//======Giai======
	else if(o.equals(btnGiai)) {
		try {
			//Kiem-tra-du-lieu-nhap-vao
			if(tfNhapA.getText().equals("") || tfNhapB.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Chưa nhập đủ a hoặc b");
				return;
			}
			
			double a = Double.parseDouble(tfNhapA.getText());
			double b = Double.parseDouble(tfNhapB.getText());
			double kq = 0;
			
			if(rbCong.isSelected()) {
				kq = a + b;
			} else if(rbTru.isSelected()) {
				kq = a - b;
			} else if(rbNhan.isSelected()) {
				kq = a * b;
			} else if(rbChia.isSelected()) {
				if(b == 0) {
					JOptionPane.showMessageDialog(this, "Không thể chia cho 0");
					return;
				}
				kq = a / b;
			}
			
			tfKetQua.setText(String.valueOf(kq));
			
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào phải là số!");
		}
	}
	}
}
