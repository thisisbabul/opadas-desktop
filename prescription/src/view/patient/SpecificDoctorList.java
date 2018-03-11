package view.patient;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SpecificDoctorList extends JFrame{

	private JButton[] buttons;
	private Container c;
	private GridLayout gridLayout;
	private static String[] denistDoctorList = {"<html><center>Dr. Sk. Nazrul Islam<br>BDS (DU), PGT (BK), FAES (USA), MCPS (BD),<br>Fellow of Endodontics Assistant Professor & Head of the Department<br>Expertise: Root Canal Specialis First Root Canal Specialist In Bangladesh With American Degree<br>(35 Years of Experience)<br>Chamber: Endo Dental<br>Anannya Shopping Complex (3rd Floor)<br>DOHS Baridhara, Gulshan, Dhaka-1206, Bangladesh.<br>Phone: Cell: +8801711528345</center></html>","","",""};
	
	public SpecificDoctorList() {
		initComponents();	
	}
	
	private void initComponents() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
        c = this.getContentPane();
   
        gridLayout = new GridLayout(2,2,10,10);
        c.setLayout(gridLayout);
        buttons = new JButton[4];
        
        for(int i = 0; i<4; i++){
            buttons[i] = new JButton(denistDoctorList[i]);
            c.add(buttons[i]);
            
            buttons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					PatientInfo frame = new PatientInfo("Patient Information");
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					int height = screenSize.height;
					int width = screenSize.width;
					frame.setSize(width/2, height/2);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}
			});
        }
        
        
    }

}
