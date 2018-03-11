package view.doctor;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import view.patient.PatientQueue;

public class DoctorDashboard extends JFrame{

	private JButton[] buttons;
	private Container c;
	private GridLayout gridLayout;
	private static String[] doctorProfile = {"Patient Queue","Profile","Patient Information","Report"};
	
	public DoctorDashboard(String msg) {
		super(msg);
		initComponents();	
	}
	
	private void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
        c = this.getContentPane();
   
        gridLayout = new GridLayout(2,2,10,10);
        c.setLayout(gridLayout);
        buttons = new JButton[4];
        
        for(int i = 0; i<4; i++){
            buttons[i] = new JButton(doctorProfile[i]);
            c.add(buttons[i]);
            buttons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(e.getActionCommand().equals("Patient Queue")) {
						DoctorPatientQueue frame = new DoctorPatientQueue("Patient Queue");
						Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
						int height = screenSize.height;
						int width = screenSize.width;
						frame.setSize(width/2, height/2);
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					}
				}
			});
        }
        
        
    }
	
	public static void main(String[] args) {
		DoctorDashboard frame = new DoctorDashboard("Dashboard");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width/2, height/2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
