package view.patient;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DoctorSpecialistList extends JFrame{

	private static final long serialVersionUID = 1L;
	private JButton[] buttons;
	private Container c;
	private GridLayout gridLayout;
	private String[] specialistList = {"Dentist", "Gynecologist", "Microbiologist", "Neonatologist", "Neurologist", "OrthopedicSurgeon", "Pediatrician", "Urologist", "Podiatrist", "PlasticSurgeon", "Neurosurgeon", "Nndocrinologists"};
	
	public DoctorSpecialistList() {
		super("Doctor Specialization");
		initComponents();	
	}
	
	private void initComponents() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        c = this.getContentPane();
   
        gridLayout = new GridLayout(4,3,10,10);
        c.setLayout(gridLayout);
        buttons = new JButton[12];
        
        for(int i = 0; i<12; i++){
            buttons[i] = new JButton(specialistList[i]);
            c.add(buttons[i]);
            
            buttons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("Dentist")) {
						// TODO Auto-generated method stub
						SpecificDoctorList frame = new SpecificDoctorList();
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
		// TODO Auto-generated method stub
		DoctorSpecialistList frame = new DoctorSpecialistList();
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width/2, height/2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
