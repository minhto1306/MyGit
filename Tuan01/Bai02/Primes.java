package Tuan01.Bai02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Primes extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton btnGenerate;
	JTextField tfNhap;
	JTextArea taHienThi;
	JPanel pnNorth, pnCenter;
	
	public Primes () {
		//JFrame
		this.setTitle("Primes");
		this.setSize(400, 300);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//JPanel North
		pnNorth = new JPanel();
		this.add(pnNorth, BorderLayout.NORTH);
		pnNorth.add(tfNhap = new JTextField(20));
		pnNorth.add(btnGenerate = new JButton("Generate"));
		
		//JPanel Center
		pnCenter = new JPanel();
		this.add(pnCenter, BorderLayout.CENTER);
		pnCenter.add(taHienThi = new JTextArea(10, 30));
		taHienThi.setEditable(false);
		JScrollPane scrPn = new JScrollPane(taHienThi);
		pnCenter.add(scrPn);
		
		//Dang-ki-su-kien
		btnGenerate.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj.equals(btnGenerate)) {
			taHienThi.setText("");
			
			try {
				String text = tfNhap.getText();
				if (text.isEmpty()) return;
				
				int n = Integer.parseInt(text);
				
				int count = 0;
				int i = 2;
				
				while (count < n) {
					if (isPrime(i)) {
						taHienThi.append(i + "\n");
						count++;
					}
					i++;
				}
				tfNhap.requestFocus();
				tfNhap.selectAll();
				
			} catch (NumberFormatException nfe) {
				taHienThi.setText("Vui lòng nhập số nguyên hợp lệ!");
			}
		}
		
	}
	
	public boolean isPrime (int k) {
		if (k < 2) {
			return false;
		}
		for (int i=2; i<Math.sqrt(k); i++) {
			if (k % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
