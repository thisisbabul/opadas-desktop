package view.doctor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.PatientManager;
import model.Patient;
import view.common.LoginForm;
import view.doctor.Prescription;

public class DoctorPatientQueue extends JFrame implements ActionListener{
	
	private JButton[] buttons;
	private JPanel common;
	private PatientManager pm;
	private List<Patient> patientList;
	private JButton btnLogout;
	private JLabel lbl;
	
	public DoctorPatientQueue(String msg) {
		super(msg);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(null);
		
		lbl = new JLabel();
		
		pm = new PatientManager();
		patientList = pm.getPatientList();
		
		int size = patientList.size();
		int i = 1;
		common = new JPanel(new GridLayout(10,1,5,5));
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(this);
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
					pm.delete(patient);
				}
			});
			i++;
		}
		common.add(lbl);
		common.add(btnLogout);
		add(common);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoctorPatientQueue frame = new DoctorPatientQueue("Patient Queue");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width/2, height/2);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnLogout)) {
			LoginForm frame = new LoginForm("Login Form");
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int height = screenSize.height;
			int width = screenSize.width;
			frame.setSize(width / 3, height / 4);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			this.dispose();
		}
	}



	

}
