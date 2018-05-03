package internation.dao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Label;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import internation.model.Sub;

public class HightLineInternation {
	
	  // Khai báo form khách hàng
    static JFrame frmKhachHang;

	private static String subInternation;

	private static char[] internation;

	private static String word = "";

	public static void main(String[] args) {

		 EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                	HightLineInternation KH = new HightLineInternation();
	                    KH.frmKhachHang.setVisible(true);
	                } catch (Exception e) {

	                }
	            }
	        });
//		Huy();

	}

	public HightLineInternation(){
		Huy();
		
	}
	
	public static void Huy() {
		
		 // Tạo form chính 
        frmKhachHang = new JFrame("Demo");        // Set tiêu đề cho form
        frmKhachHang.setBounds(320, 80, 800, 570);              // Set vị trí và size cho form
        frmKhachHang.getContentPane().setLayout(null);          // Set layout cho form

     // Panel chung Thông tin 
        JPanel Panel = new JPanel();
        Panel.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        Panel.setBounds(10, 10, 765, 510);
        frmKhachHang.getContentPane().add(Panel);
        Panel.setLayout(null);
        
        Label amount = new Label();
		amount.setBounds(200,200,120,20);
		Panel.add(amount);
		
		List<Sub> lsubtsub = GetSub.GetListSub(1);
		for (Sub s : lsubtsub) {
			if (s.getContent_internation() != null) {

				subInternation = s.getContent_internation();

				// System.out.println("Internation : " + subInternation);

				internation = subInternation.toCharArray();

				for (int i = 0; i < internation.length; i++) {

					
					if (internation[i] == '+') {

						for (int j = i + 1; j < internation.length; j++) {
							// System.out.print(internation[j]);
							word = word + internation[j];

							if (internation[j] == ' ') {
								break;
							}
							
						}
						amount.setText(word);
						amount.setForeground(Color.RED);
						System.out.println(word);	
						
						
					}
					if (internation[i] == '-') {
						for (int j = i + 1; j < internation.length; j++) {
							// System.out.print(internation[j]);
							if (internation[j] == ' ') {
								break;
							}
						}
					} else {

					}
				}

			} else {
				// System.out.println("Sub : " + s.getContent());
			}
		}
	}

}
