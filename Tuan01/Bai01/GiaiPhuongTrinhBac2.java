package Tuan01.Bai01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GiaiPhuongTrinhBac2 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton btnGiai, btnXoa, btnThoat;
    JTextField tfA, tfB, tfC, tfKQ;
	
	public GiaiPhuongTrinhBac2() {
		//JFrame
		this.setTitle("GIAI PHUONG TRINH BAC HAI");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		//JPanel North
		JPanel pnNorth = new JPanel();
		JLabel lblTieuDe = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI");
		pnNorth.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 20));
		pnNorth.setBackground(Color.cyan);
		this.add(pnNorth, BorderLayout.NORTH);		
		//JPanel South
		JPanel pnSouth = new JPanel();
		
		btnGiai = new JButton("Giải");
        btnXoa = new JButton("Xóa rỗng");
        btnThoat = new JButton("Thoát");
		
		pnSouth.add(btnGiai);
		pnSouth.add(btnXoa);
		pnSouth.add(btnThoat);
		
		Border brdChonTacVu = BorderFactory.createLineBorder(Color.gray);
		TitledBorder tlbrdChonTacVu = BorderFactory.createTitledBorder(brdChonTacVu, "Chọn tác vụ");
		
		pnSouth.setBorder(tlbrdChonTacVu);
		
		this.add(pnSouth, BorderLayout.SOUTH);
		
		//JPanel Center 
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		
		JLabel lblA = new JLabel("Nhập a:");
		JLabel lblB = new JLabel("Nhập b:");
		JLabel lblC = new JLabel("Nhập c:");
		JLabel lblKQ = new JLabel("Kết quả:");

		tfA = new JTextField(30);
        tfB = new JTextField(30);
        tfC = new JTextField(30);
        tfKQ = new JTextField(30);
        tfKQ.setEditable(false);

		JLabel[] lbl = {lblA, lblB, lblC, lblKQ};
		JTextField[] txtf = {tfA, tfB, tfC, tfKQ};
		
		for (int i = 0; i < lbl.length; i++) {
		    pnCenter.add(lbl[i]);     
		    pnCenter.add(txtf[i]);  
		}
		
		this.add(pnCenter, BorderLayout.CENTER);
		
		btnGiai.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj.equals(btnGiai)) {
			xuLyGiai();
		}
		else if (obj.equals(btnXoa)) {
			tfA.setText("");
            tfB.setText("");
            tfC.setText("");
            tfKQ.setText("");
            tfA.requestFocus();
		}
		else if (obj.equals(btnThoat)) {
			System.exit(0);
		}
	}
	
	public void xuLyGiai () {
		try {
			double a = Double.parseDouble(tfA.getText());
			double b = Double.parseDouble(tfB.getText());
			double c = Double.parseDouble(tfC.getText());
			
			String ketQua = "";
			
			if (a == 0) {
                if (b == 0) {
                    ketQua = (c == 0) ? "Vô số nghiệm" : "Vô nghiệm";
                } else {
                    ketQua = "x = " + (-c / b);
                }
            } else {
                // Giải pt bậc 2
                double delta = b * b - 4 * a * c;
                if (delta < 0) {
                    ketQua = "Vô nghiệm";
                } else if (delta == 0) {
                    ketQua = "x = " + (-b / (2 * a));
                } else {
                    double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    ketQua = String.format("x1 = %.2f; x2 = %.2f", x1, x2);
                }
                
            }
            tfKQ.setText(ketQua);
		} catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Lỗi: Vui lòng nhập số hợp lệ!");
	    }
	}
}

