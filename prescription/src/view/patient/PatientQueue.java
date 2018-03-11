package view.patient;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.PatientManager;
import model.Patient;
import view.doctor.Prescription;

public class PatientQueue extends JFrame{
	
	private JButton[] buttons;
	private JPanel common;
	private PatientManager pm;
	private List<Patient> patientList;
	
	
	public PatientQueue() throws HeadlessException {
		
	}



	public PatientQueue(String msg) {
		super(msg);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(null);
		
		pm = new PatientManager();
		patientList = pm.getPatientList();
		
		int size = patientList.size();
		int i = 1;
		common = new JPanel(new GridLayout(10,1,5,5));
		
		buttons = new JButton[20];
		
		
		for(Patient patient: patientList) {
			buttons[i] = new JButton(i+". "+patient.getName());
			common.add(buttons[i]);
			buttons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Prescription frame = new Prescription("Prescription");
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				}
			});
			i++;
		}
		
		add(common);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PatientQueue frame = new PatientQueue("Patient Queue");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width/2, height/2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}



	

}
