package view.admin;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Dashboard extends JFrame implements ActionListener{

	private JButton[] buttons;
	private Container c;
	private GridLayout gridLayout;
	private static String[] dashboard = {"Profile","Doctor","Pharmacy","Patient"};
	
	public Dashboard(String msg) {
		super(msg);
		initComponents();	
	}
	
	private void initComponents() {
                       
        c = this.getContentPane();
   
        gridLayout = new GridLayout(2,2,100,100);
        c.setLayout(gridLayout);
        buttons = new JButton[4];
        
        for(int i = 0; i<4; i++){
            buttons[i] = new JButton(dashboard[i]);
            c.add(buttons[i]);
            buttons[i].addActionListener(this);
        }
        
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Profile")) {
			AdminProfile frame = new AdminProfile("Admin - Profile");
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setVisible(true);
		}else if(e.getActionCommand().equals("Doctor")) {
			DoctorProfile frame = new DoctorProfile("Doctor - Profile");
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setVisible(true);
		}else if(e.getActionCommand().equals("Pharmacy")) {
			PharmacyProfile frame = new PharmacyProfile("Pharmacy - Profile");
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setVisible(true);
		}else if(e.getActionCommand().equals("Patient")) {
			PharmacyProfile frame = new PharmacyProfile("Pharmacy - Profile");
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		Dashboard frame = new Dashboard("Dashboard - Admin");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width / 2, height / 2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
		
}
